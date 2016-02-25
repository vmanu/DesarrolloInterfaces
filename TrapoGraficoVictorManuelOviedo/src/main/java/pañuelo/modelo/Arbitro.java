/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pañuelo.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class Arbitro implements Runnable {

    private CyclicBarrier entrada;
    private CountDownLatch primeraVez;
    private ArrayList<Niño> niños;
    private HashMap<String, Integer> equipos;
    private Lock pañuelo;
    private ArrayList<Condition> numerosSalida;
    private ArrayList<Integer> numerosTurno;
    private boolean terminado;
    private Niño[] ganadoresTurno;
    private Niño[] corredores;
    private Niño niñoConPañuelo;
    private boolean pañueloCogido;

    private Condition arbitroDescansa;
    private Condition cogerPañuelo;
    private boolean numeroLibres;

    public Arbitro() {
        terminado=false;
        pañuelo = new ReentrantLock();
        equipos = new HashMap<>();
        numerosSalida = new ArrayList<>();
        numerosTurno = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            numerosSalida.add(pañuelo.newCondition());
            numerosTurno.add(i);
        }
        ganadoresTurno = new Niño[5];
        corredores = new Niño[2];
        arbitroDescansa = pañuelo.newCondition();
        cogerPañuelo = pañuelo.newCondition();
        niños = new ArrayList<>();
        entrada = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                equipos.put(Constantes.EQUIPO1, 0);
                equipos.put(Constantes.EQUIPO2, 0);
                for (int i = 0; i < 5; i++) {
                    niños.get(i).setEquipo(Constantes.EQUIPO1);
                    niños.get(i + 5).setEquipo(Constantes.EQUIPO2);
                    niños.get(i).setNumeroPañuelo(i);
                    niños.get(i + 5).setNumeroPañuelo(i);
                }
            }
        });
        primeraVez = new CountDownLatch(10);

        Thread t = new Thread(this);
        t.start();
    }

    public void addNiño(Niño niño) {
        this.niños.add(niño);
    }

    public int comienzoCarrera(Niño niño) {
        int posicion = 0;
        this.pañuelo.lock();
        try {
            if (corredores[0] == null) {
                corredores[0] = niño;
            } else {
                corredores[1] = niño;
                posicion = 1;
            }
        } finally {
            this.pañuelo.unlock();
        }
        return posicion;
    }

    public void volverEnCarrera(int posicionNiño, int metros) {
        boolean finCarrera = false;
       
        try {
            this.pañuelo.lock();
            Niño niño = corredores[posicionNiño];
            Niño niño2 = corredores[(posicionNiño + 1) % 2];
            niño.avanzaMetrosRecorridos(metros);
            if (niño.isTienePañuelo())
            {
                if (niño.getMetrosRecorridos() <=0)
                {
                    this.ganador(niño);
                    System.out.println("Gana " + niño.getNombre() + " hasta el final");
                    finCarrera = true;
                }
            }
            else { 
                // el que persigue
                if (niño.getMetrosRecorridos()<= niño2.getMetrosRecorridos())
                {
                    // le ha pillado
                    this.ganador(niño);
                     System.out.println("Gana " + niño.getNombre() + " ha pillado a "+ niño2.getNombre());
                    finCarrera = true;
                }
            }

            if (finCarrera) {
                niño.setFinCarrera(true);
                niño2.setFinCarrera(true);
            }
        } finally {
            this.pañuelo.unlock();
        }
    }

    public void avanzaEnCarrera(int posicionNiño, int metros) {
        boolean finCarrera = false;
        try {
            this.pañuelo.lock();

            Niño niño = corredores[posicionNiño];
            Niño niño2 = corredores[(posicionNiño + 1) % 2];
            niño.avanzaMetrosRecorridos(metros);
            //si se pasa pierde.
            if (!pañueloCogido) {
                if (niño.getMetrosRecorridos() > 110) {
                    //se pasa de la linea 
                    System.out.println("se pasa " + niño.getNombre() + " gana "+niño2.getNombre());
                    this.ganador(niño2);
                    finCarrera = true;
                } else if (niño.getMetrosRecorridos() >= 100) {
                    this.niñoConPañuelo = niño;
                    this.pañueloCogido = true;
                    if (this.cogerPañuelo.await(500, TimeUnit.MILLISECONDS) == false) {
                        this.niñoConPañuelo = null;
                        System.out.println("vuelve " + niño.getNombre() + " con el pañuelo");
                        niño.setTienePañuelo(true);
                        niño.darVuelta();
                    }
                }
            } else if (niño.getMetrosRecorridos() >= 100) {
                if (niñoConPañuelo != null) {
                    //le coge y gana
                    finCarrera = true;
                    System.out.println("ha ganado " + niño.getNombre() + " toca al del pañuelo");
                    this.cogerPañuelo.signalAll();
                    this.ganador(niño);
                } else {
                    System.out.println("vuelve " + niño.getNombre() + " ");
                    niño.darVuelta();
                }
            }

            if (finCarrera) {
                niño.setFinCarrera(true);
                niño2.setFinCarrera(true);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Arbitro.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.pañuelo.unlock();
        }
    }

    public void ganador(Niño niñoGanador) {

        if (ganadoresTurno[niñoGanador.getNumeroPañuelo()] == null) {

            equipos.put(niñoGanador.getEquipo(), equipos.get(niñoGanador.getEquipo()) + 1);
            ganadoresTurno[niñoGanador.getNumeroPañuelo()] = niñoGanador;

            this.arbitroDescansa.signalAll();
        }
    }

    public void esperarQueLLeguenTodos(Niño niño) {
        try {
            System.out.println("llega niño" + niño.getNombre());
            this.addNiño(niño);
            this.entrada.await();
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Arbitro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Arbitro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void esperarQueSalgaMiNumero(int numeroPañuelo) {
        try {
            this.pañuelo.lock();
            System.out.println("esperando por numero pañuelo" + numeroPañuelo);
            this.numerosSalida.get(numeroPañuelo).await();
        } catch (InterruptedException ex) {
            Logger.getLogger(Arbitro.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.pañuelo.unlock();
        }
    }

    public void countDown() {
        this.pañuelo.lock();
        primeraVez.countDown();
        this.pañuelo.unlock();
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            //esperando que todos los niños hagan el countdown
            primeraVez.await();
            this.pañuelo.lock();
            while (this.numerosTurno.size() > 0) {
                // elige un numero aleatorio y despierta la condicion, y se vuelve a dormir.
                corredores[0] = null;
                corredores[1] = null;
                niñoConPañuelo = null;
                pañueloCogido = false;
                int indiceNumerosTurno = random.nextInt(this.numerosTurno.size());
                int numeroActual = this.numerosTurno.get(indiceNumerosTurno);
                System.out.println("arbitro dice que el numero es " + numeroActual);
                this.numerosTurno.remove(indiceNumerosTurno);
                this.numerosSalida.get(numeroActual).signalAll();
                System.out.println("arbitro se duerme");
                this.arbitroDescansa.await();
            }
            corredores[0]=null;
            corredores[1]=null;
            terminado=true;
            // comprobar el ganador
            System.out.println(" Fin Juego");
            System.out.println(" puntos de equipo 1: " + equipos.get(Constantes.EQUIPO1));
            System.out.println(" puntos de equipo 2: " + equipos.get(Constantes.EQUIPO2));

        } catch (InterruptedException ex) {
            Logger.getLogger(Arbitro.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.pañuelo.unlock();
        }
    }

    public Niño[] getCorredores(){
        return corredores;
    }
    
    public boolean isTerminado(){
        return terminado;
    }
    
    public ArrayList<Condition> getConditions(){
        return numerosSalida;
    }

    public Niño[] getGanadores() {
        return ganadoresTurno;
    }
    
    public ArrayList<Niño>getNiños(){
        return niños;
    }
}
