/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pañuelo.modelo;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oscar
 */
public class Niño implements Runnable {

    private int velocidad;
    private int avance;
    private String nombre;
    private String equipo;
    private Random random;
    private Arbitro arbitro;
    private int numeroPañuelo;
    private int metrosRecorridos;
    private int posicionEnCarrera;
    private boolean finCarrera;
    private boolean volver;
    private boolean tienePañuelo;

    public Niño(String nombre, Arbitro arbitro) {
        random = new Random();
        this.nombre = nombre;
        this.arbitro = arbitro;
        this.velocidad = random.nextInt(20) + 20;
        Thread t = new Thread(this);
        t.start();
        t.setName(this.nombre);
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getNumeroPañuelo() {
        return numeroPañuelo;
    }

    public void setNumeroPañuelo(int numeroPañuelo) {
        this.numeroPañuelo = numeroPañuelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFinCarrera(boolean finCarrera) {
        this.finCarrera = finCarrera;
    }

    public int getMetrosRecorridos() {
        return metrosRecorridos;
    }

    public void avanzaMetrosRecorridos(int metrosRecorridos) {
        this.metrosRecorridos += metrosRecorridos;
    }

    public void darVuelta() {
        this.metrosRecorridos = 100;
        this.avance = this.velocidad;
        this.volver = true;
    }

    public boolean isTienePañuelo() {
        return tienePañuelo;
    }

    public void setTienePañuelo(boolean tienePañuelo) {
        this.tienePañuelo = tienePañuelo;
    }

    @Override
    public void run() {
        try {
            finCarrera = false;

            arbitro.esperarQueLLeguenTodos(this);
            arbitro.countDown();
            arbitro.esperarQueSalgaMiNumero(numeroPañuelo);
            // correr hasta el pañuelo

            System.out.println(nombre + " con numero" + numeroPañuelo + " corriendo" + this.velocidad);
            avance = this.velocidad;
            this.volver = false;
            posicionEnCarrera = arbitro.comienzoCarrera(this);
            do {
                if (!finCarrera) {
                    if (!volver) {
                        arbitro.avanzaEnCarrera(posicionEnCarrera, avance);
                    } else {
                        arbitro.volverEnCarrera(posicionEnCarrera, avance);
                    }

                    if (avance > 10) {
                        avance -= random.nextInt(8);
                    }
                    if (avance < 10) {
                        avance = 10;
                    }
                    if (volver) {
                        avance *= -1;
                    }
                    System.out.println(nombre + " numero " + numeroPañuelo + " metros" + metrosRecorridos);

                    TimeUnit.MILLISECONDS.sleep(500);
                }
            } while (!finCarrera);

        } catch (InterruptedException ex) {
            Logger.getLogger(Niño.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean isVolver(){
        return volver;
    }
}
