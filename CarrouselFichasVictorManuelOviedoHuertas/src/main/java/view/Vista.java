/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import control.ControlFichas;
import modelo.Ficha;
import modelo.ComboOpciones;
import static constantes.ComboItems.*;
import static constantes.Constantes.*;
import java.awt.Color;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 *
 * @author dam2
 */
public class Vista extends javax.swing.JFrame {

    private ControlFichas control;
    private boolean filtrando;
    private ArrayList<Ficha> filtro;
    private int indexFiltro;

    /**
     * Creates new form Vista
     */
    public Vista() {
        initComponents();
        setNombres();
        crearFicheros();
        rellenaComboMarcas(jComboBoxMarcaEdicion);
        rellenaComboTipos(jComboBoxTipoEdicion);
        rellenaComboMarcas(jComboBoxMarcaFiltro);
        rellenaComboTipos(jComboBoxTipoFiltro);
        setInitialState();
        filtrando = false;
        indexFiltro = 0;
        filtro = new ArrayList();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    private void rellenaComboMarcas(JComboBox combo) {
        combo.removeAllItems();
        if (combo.equals(jComboBoxMarcaFiltro)) {
            combo.addItem(new ComboOpciones("", null));
        }
        combo.addItem(new ComboOpciones("Bandai", BANDAI));
        combo.addItem(new ComboOpciones("Chicco", CHICCO));
        combo.addItem(new ComboOpciones("Diset", DISET));
        combo.addItem(new ComboOpciones("Djeco", DJECO));
        combo.addItem(new ComboOpciones("Lego", LEGO));
        combo.addItem(new ComboOpciones("Playmobil", PLAYMOBIL));
        combo.addItem(new ComboOpciones("Mega Blocks", MEGA_BLOCKS));
        combo.addItem(new ComboOpciones("Janod", JANOD));
        combo.addItem(new ComboOpciones("Mattel", MATTEL));
        combo.addItem(new ComboOpciones("Famosa", FAMOSA));
        combo.addItem(new ComboOpciones("Meccano", MECCANO));
        combo.addItem(new ComboOpciones("Engino", ENGINO));
        combo.addItem(new ComboOpciones("Lado", LADO));
        combo.addItem(new ComboOpciones("Educa", EDUCA));
        combo.addItem(new ComboOpciones("Nimco", NIMCO));
    }

    private void rellenaComboTipos(JComboBox combo) {
        combo.removeAllItems();
        if (combo.equals(jComboBoxTipoFiltro)) {
            combo.addItem(new ComboOpciones("", null));
        }
        combo.addItem(new ComboOpciones("Educativos", EDUCATIVOS));
        combo.addItem(new ComboOpciones("Muñecas", MUNYECAS));
        combo.addItem(new ComboOpciones("Construcción", CONSTRUCCION));
        combo.addItem(new ComboOpciones("Manualidades", MANUALIDADES));
        combo.addItem(new ComboOpciones("Coches", COCHES));
        combo.addItem(new ComboOpciones("Juego de mesa", JUEGO_MESA));
        combo.addItem(new ComboOpciones("Puzzles", PUZZLES));
        combo.addItem(new ComboOpciones("Cocinitas", COCINITAS));
        combo.addItem(new ComboOpciones("Casa de muñecas", CASA_MUNYECAS));
        combo.addItem(new ComboOpciones("Trenes", TRENES));
        combo.addItem(new ComboOpciones("Ciencia", CIENCIA));
        combo.addItem(new ComboOpciones("Libros", LIBROS));
        combo.addItem(new ComboOpciones("Cartas", CARTAS));
        combo.addItem(new ComboOpciones("Juegos Magnéticos", JUEGO_MAGNETICOS));
        combo.addItem(new ComboOpciones("Tecnología", TECNOLOGIA));
        combo.addItem(new ComboOpciones("Material escolar", MATERIAL_ESCOLAR));
        combo.addItem(new ComboOpciones("Peluches", PELUCHES));
        combo.addItem(new ComboOpciones("Deporte", DEPORTE));
        combo.addItem(new ComboOpciones("Aviones", AVIONES));
        combo.addItem(new ComboOpciones("Carritos", CARRITOS));
        combo.addItem(new ComboOpciones("Disfraces", DISFRACES));
    }

    public void setNombres() {
        jButtonSiguienteVista.setName(BOTON_SIGUIENTE_VISTA);
        jButtonAnterirorVista.setName(BOTON_ANTERIOR_VISTA);
        jButtonCancelFilterVista.setName(BOTON_CANCELA_FILTRO_VISTA);
        jLabelMuestraNombre.setName(TEXTVIEW_NOMBRE_VISTA);
        jLabelFotoVista.setName(LABEL_IMAGEN_VISTA);
        jLabelMuestraEdad.setName(TEXTVIEW_EDAD_VISTA);
        jLabelMuestraMarca.setName(TEXTVIEW_MARCA_VISTA);
        jLabelMuestraPrecio.setName(TEXTVIEW_PRECIO_VISTA);
        jLabelMuestraTipo.setName(TEXTVIEW_TIPO_VISTA);
        jLabelMostrandoVista.setName(LABEL_INDEX_VISTA);
        jLabelMaximoCarrouselVista.setName(LABEL_INDEX_MAX_VISTA);
        jButtonAceptarEdicion.setName(BOTON_ACEPTAR_EDICION);
        jButtonCancelarEdicion.setName(BOTON_CANCELAR_EDICION);
        jButtonAgregarFotoEdicion.setName(BOTON_AGREGAR_IMAGEN_EDICION);
        jComboBoxMarcaEdicion.setName(COMBO_MARCA_EDICION);
        jComboBoxTipoEdicion.setName(COMBO_TIPO_EDICION);
        jTextFieldEdadEdicion.setName(EDITEXT_EDAD_EDICION);
        jTextFieldNombreEdicion.setName(EDITEXT_NOMBRE_EDICION);
        jTextFieldPrecioEdicion.setName(EDITEXT_PRECIO_EDICION);
        jLabelRutaImagenEdicion.setName(LABEL_IMAGEN_EDICION);
        jLabelTipoEdicion.setName(LABEL_TIPO_ACCION_EDICION);
        jTextFieldEdadFiltro.setName(EDITEXT_EDAD_FILTRO);
        jTextFieldNombreFiltro.setName(EDITEXT_NOMBRE_FILTRO);
        jTextFieldPrecioFiltro.setName(EDITEXT_PRECIO_FILTRO);
        jComboBoxMarcaFiltro.setName(COMBO_MARCA_FILTRO);
        jComboBoxTipoFiltro.setName(COMBO_TIPO_FILTRO);
        jButtonAceptarFiltro.setName(BOTON_ACEPTAR_FILTRO);
        jButtonCancelarFiltro.setName(BOTON_CANCELAR_FILTRO);
        jMenuArchivo.setName(MENU_ARCHIVO);
        jMenuItemAgregar.setName(MENU_AGREGAR);
        jMenuItemBorrar.setName(MENU_BORRAR);
        jMenuItemCargar.setName(MENU_CARGAR);
        jMenuItemFiltrar.setName(MENU_FILTRAR);
        jMenuItemGuardar.setName(MENU_GUARDAR);
        jMenuItemModificar.setName(MENU_MODIFICAR);
        jMenuItemVista.setName(MENU_VISTA);
        jFileChooserEdicion.setName(FILECHOOSER);
        jPanelVista.setName(PANEL_VISTA);
        jPanelEdicion.setName(PANEL_EDICION);
        jPanelFiltro.setName(PANEL_FILTRO);
    }

    private void crearFicheros() {
        File fich = new File(".\\imagenes");
        if (!fich.exists()) {
            fich.mkdirs();
        }
    }

    public void setInitialState() {
        jPanelVista.setVisible(true);
        jPanelEdicion.setVisible(false);
        jPanelFiltro.setVisible(false);
        setEnabled(new JButton[]{jButtonAnterirorVista, jButtonSiguienteVista}, new JMenuItem[]{jMenuItemVista, jMenuItemGuardar, jMenuItemBorrar, jMenuItemFiltrar, jMenuItemModificar}, false);
        jButtonCancelFilterVista.setVisible(false);
        control = new ControlFichas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooserEdicion = new javax.swing.JFileChooser();
        jPanelVista = new javax.swing.JPanel();
        jLabelNombreVista = new javax.swing.JLabel();
        jLabelMarcaVista = new javax.swing.JLabel();
        jLabelEdadVista = new javax.swing.JLabel();
        jLabelPrecioVista = new javax.swing.JLabel();
        jLabelTipoVista = new javax.swing.JLabel();
        jLabelMuestraNombre = new javax.swing.JLabel();
        jLabelMuestraMarca = new javax.swing.JLabel();
        jLabelMuestraEdad = new javax.swing.JLabel();
        jLabelMuestraPrecio = new javax.swing.JLabel();
        jLabelMuestraTipo = new javax.swing.JLabel();
        jLabelFotoVista = new javax.swing.JLabel();
        jPanelBaseVista = new javax.swing.JPanel();
        jButtonAnterirorVista = new javax.swing.JButton();
        jLabelMostrandoVista = new javax.swing.JLabel();
        jLabelDeVista = new javax.swing.JLabel();
        jLabelMaximoCarrouselVista = new javax.swing.JLabel();
        jButtonSiguienteVista = new javax.swing.JButton();
        jButtonCancelFilterVista = new javax.swing.JButton();
        jPanelEdicion = new javax.swing.JPanel();
        jLabelMuestraAccionEdicion = new javax.swing.JLabel();
        jLabelNombreEdicion = new javax.swing.JLabel();
        jLabelMarcaEdicion = new javax.swing.JLabel();
        jLabelEdadEdicion = new javax.swing.JLabel();
        jLabelPrecioEdicion = new javax.swing.JLabel();
        jLabelTipoEdicion = new javax.swing.JLabel();
        jComboBoxMarcaEdicion = new javax.swing.JComboBox();
        jComboBoxTipoEdicion = new javax.swing.JComboBox();
        jTextFieldNombreEdicion = new javax.swing.JTextField();
        jTextFieldEdadEdicion = new javax.swing.JTextField();
        jTextFieldPrecioEdicion = new javax.swing.JTextField();
        jButtonAgregarFotoEdicion = new javax.swing.JButton();
        jLabelRutaImagenEdicion = new javax.swing.JLabel();
        jButtonAceptarEdicion = new javax.swing.JButton();
        jButtonCancelarEdicion = new javax.swing.JButton();
        jPanelFiltro = new javax.swing.JPanel();
        jLabelNombreFiltro = new javax.swing.JLabel();
        jTextFieldNombreFiltro = new javax.swing.JTextField();
        jLabelMarcaFiltro = new javax.swing.JLabel();
        jComboBoxMarcaFiltro = new javax.swing.JComboBox();
        jLabelEdadFiltro = new javax.swing.JLabel();
        jTextFieldEdadFiltro = new javax.swing.JTextField();
        jLabelPrecioFiltro = new javax.swing.JLabel();
        jTextFieldPrecioFiltro = new javax.swing.JTextField();
        jLabelTipoFiltro = new javax.swing.JLabel();
        jComboBoxTipoFiltro = new javax.swing.JComboBox();
        jButtonAceptarFiltro = new javax.swing.JButton();
        jButtonCancelarFiltro = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuItemAgregar = new javax.swing.JMenuItem();
        jMenuItemModificar = new javax.swing.JMenuItem();
        jMenuItemBorrar = new javax.swing.JMenuItem();
        jMenuItemFiltrar = new javax.swing.JMenuItem();
        jMenuItemVista = new javax.swing.JMenuItem();
        jMenuItemGuardar = new javax.swing.JMenuItem();
        jMenuItemCargar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanelVista.setPreferredSize(new java.awt.Dimension(690, 320));

        jLabelNombreVista.setText("Nombre");

        jLabelMarcaVista.setText("Marca");

        jLabelEdadVista.setText("Edad");

        jLabelPrecioVista.setText("Precio");

        jLabelTipoVista.setText("Tipo");

        jLabelMuestraNombre.setMaximumSize(new java.awt.Dimension(200, 15));
        jLabelMuestraNombre.setMinimumSize(new java.awt.Dimension(200, 15));
        jLabelMuestraNombre.setPreferredSize(new java.awt.Dimension(200, 15));

        jLabelMuestraMarca.setMaximumSize(new java.awt.Dimension(200, 15));
        jLabelMuestraMarca.setMinimumSize(new java.awt.Dimension(200, 15));
        jLabelMuestraMarca.setPreferredSize(new java.awt.Dimension(200, 15));

        jLabelMuestraEdad.setMaximumSize(new java.awt.Dimension(200, 15));
        jLabelMuestraEdad.setMinimumSize(new java.awt.Dimension(200, 15));
        jLabelMuestraEdad.setPreferredSize(new java.awt.Dimension(200, 15));

        jLabelMuestraPrecio.setMaximumSize(new java.awt.Dimension(200, 15));
        jLabelMuestraPrecio.setMinimumSize(new java.awt.Dimension(200, 15));
        jLabelMuestraPrecio.setPreferredSize(new java.awt.Dimension(200, 15));

        jLabelMuestraTipo.setMaximumSize(new java.awt.Dimension(200, 15));
        jLabelMuestraTipo.setMinimumSize(new java.awt.Dimension(200, 15));
        jLabelMuestraTipo.setPreferredSize(new java.awt.Dimension(200, 15));

        jLabelFotoVista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabelFotoVista.setPreferredSize(new java.awt.Dimension(125, 150));
        jLabelFotoVista.setRequestFocusEnabled(false);

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 40, 5);
        flowLayout1.setAlignOnBaseline(true);
        jPanelBaseVista.setLayout(flowLayout1);

        jButtonAnterirorVista.setText("Anterior");
        jButtonAnterirorVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnterirorVistaActionPerformed(evt);
            }
        });
        jPanelBaseVista.add(jButtonAnterirorVista);

        jLabelMostrandoVista.setText("X");
        jPanelBaseVista.add(jLabelMostrandoVista);

        jLabelDeVista.setText(" de ");
        jPanelBaseVista.add(jLabelDeVista);

        jLabelMaximoCarrouselVista.setText("X");
        jPanelBaseVista.add(jLabelMaximoCarrouselVista);

        jButtonSiguienteVista.setText("Siguiente");
        jButtonSiguienteVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteVistaActionPerformed(evt);
            }
        });
        jPanelBaseVista.add(jButtonSiguienteVista);

        jButtonCancelFilterVista.setText("Cancelar Filtro");
        jButtonCancelFilterVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelFilterVistaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelVistaLayout = new javax.swing.GroupLayout(jPanelVista);
        jPanelVista.setLayout(jPanelVistaLayout);
        jPanelVistaLayout.setHorizontalGroup(
            jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVistaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNombreVista)
                    .addComponent(jLabelMarcaVista)
                    .addComponent(jLabelEdadVista)
                    .addComponent(jLabelPrecioVista)
                    .addComponent(jLabelTipoVista))
                .addGap(18, 18, 18)
                .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelMuestraNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMuestraMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMuestraEdad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMuestraPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMuestraTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(jLabelFotoVista, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addComponent(jPanelBaseVista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
            .addGroup(jPanelVistaLayout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jButtonCancelFilterVista)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelVistaLayout.setVerticalGroup(
            jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVistaLayout.createSequentialGroup()
                .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVistaLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombreVista)
                            .addComponent(jLabelMuestraNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMarcaVista)
                            .addComponent(jLabelMuestraMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEdadVista, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMuestraEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPrecioVista)
                            .addComponent(jLabelMuestraPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTipoVista)
                            .addComponent(jLabelMuestraTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVistaLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabelFotoVista, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanelBaseVista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelFilterVista)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelEdicion.setPreferredSize(new java.awt.Dimension(690, 320));

        jLabelMuestraAccionEdicion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelMuestraAccionEdicion.setMaximumSize(new java.awt.Dimension(60, 20));
        jLabelMuestraAccionEdicion.setMinimumSize(new java.awt.Dimension(60, 20));
        jLabelMuestraAccionEdicion.setPreferredSize(new java.awt.Dimension(60, 20));

        jLabelNombreEdicion.setText("Nombre");

        jLabelMarcaEdicion.setText("Marca");

        jLabelEdadEdicion.setText("Edad");

        jLabelPrecioEdicion.setText("Precio");

        jLabelTipoEdicion.setText("Tipo");

        jComboBoxMarcaEdicion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxTipoEdicion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextFieldNombreEdicion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNombreEdicionFocusGained(evt);
            }
        });

        jTextFieldEdadEdicion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldEdadEdicionFocusGained(evt);
            }
        });

        jTextFieldPrecioEdicion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldPrecioEdicionFocusGained(evt);
            }
        });

        jButtonAgregarFotoEdicion.setText("Agregar Foto");
        jButtonAgregarFotoEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarFotoEdicionActionPerformed(evt);
            }
        });

        jLabelRutaImagenEdicion.setMaximumSize(new java.awt.Dimension(441, 15));
        jLabelRutaImagenEdicion.setMinimumSize(new java.awt.Dimension(441, 15));
        jLabelRutaImagenEdicion.setPreferredSize(new java.awt.Dimension(441, 15));

        jButtonAceptarEdicion.setText("Aceptar");
        jButtonAceptarEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarEdicionActionPerformed(evt);
            }
        });

        jButtonCancelarEdicion.setText("Cancelar");
        jButtonCancelarEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarEdicionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEdicionLayout = new javax.swing.GroupLayout(jPanelEdicion);
        jPanelEdicion.setLayout(jPanelEdicionLayout);
        jPanelEdicionLayout.setHorizontalGroup(
            jPanelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEdicionLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEdicionLayout.createSequentialGroup()
                        .addComponent(jLabelMuestraAccionEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(303, 303, 303))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEdicionLayout.createSequentialGroup()
                        .addGroup(jPanelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelEdicionLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMarcaEdicion)
                                    .addComponent(jLabelPrecioEdicion)
                                    .addComponent(jLabelEdadEdicion)
                                    .addComponent(jLabelTipoEdicion)
                                    .addComponent(jLabelNombreEdicion))
                                .addGap(23, 23, 23)
                                .addGroup(jPanelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelEdicionLayout.createSequentialGroup()
                                        .addGroup(jPanelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxTipoEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jComboBoxMarcaEdicion, 0, 200, Short.MAX_VALUE)
                                                .addComponent(jTextFieldNombreEdicion)
                                                .addComponent(jTextFieldEdadEdicion)
                                                .addComponent(jTextFieldPrecioEdicion)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE))
                                    .addGroup(jPanelEdicionLayout.createSequentialGroup()
                                        .addComponent(jButtonAceptarEdicion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonCancelarEdicion))))
                            .addComponent(jLabelRutaImagenEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAgregarFotoEdicion)
                        .addGap(101, 101, 101))))
        );
        jPanelEdicionLayout.setVerticalGroup(
            jPanelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEdicionLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabelMuestraAccionEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregarFotoEdicion)
                    .addComponent(jLabelRutaImagenEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEdicionLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNombreEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombreEdicion))
                        .addGap(59, 59, 59)
                        .addGroup(jPanelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldEdadEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEdadEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelEdicionLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMarcaEdicion)
                            .addComponent(jComboBoxMarcaEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPrecioEdicion)
                    .addComponent(jTextFieldPrecioEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTipoEdicion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEdicionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptarEdicion)
                    .addComponent(jButtonCancelarEdicion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelFiltro.setPreferredSize(new java.awt.Dimension(690, 320));

        jLabelNombreFiltro.setText("Nombre");

        jTextFieldNombreFiltro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNombreFiltroFocusGained(evt);
            }
        });

        jLabelMarcaFiltro.setText("Marca");

        jComboBoxMarcaFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelEdadFiltro.setText("Edad");

        jTextFieldEdadFiltro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldEdadFiltroFocusGained(evt);
            }
        });

        jLabelPrecioFiltro.setText("Precio");

        jTextFieldPrecioFiltro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldPrecioFiltroFocusGained(evt);
            }
        });

        jLabelTipoFiltro.setText("Tipo");

        jComboBoxTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonAceptarFiltro.setText("Filtrar");
        jButtonAceptarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarFiltroActionPerformed(evt);
            }
        });

        jButtonCancelarFiltro.setText("Cancelar");
        jButtonCancelarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarFiltroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFiltroLayout = new javax.swing.GroupLayout(jPanelFiltro);
        jPanelFiltro.setLayout(jPanelFiltroLayout);
        jPanelFiltroLayout.setHorizontalGroup(
            jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
            .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFiltroLayout.createSequentialGroup()
                    .addGap(132, 132, 132)
                    .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelMarcaFiltro)
                        .addComponent(jLabelPrecioFiltro)
                        .addComponent(jLabelEdadFiltro)
                        .addComponent(jLabelTipoFiltro)
                        .addComponent(jLabelNombreFiltro))
                    .addGap(23, 23, 23)
                    .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFiltroLayout.createSequentialGroup()
                            .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBoxTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxMarcaFiltro, 0, 200, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNombreFiltro)
                                    .addComponent(jTextFieldEdadFiltro)
                                    .addComponent(jTextFieldPrecioFiltro)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE))
                        .addGroup(jPanelFiltroLayout.createSequentialGroup()
                            .addComponent(jButtonAceptarFiltro)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCancelarFiltro)))
                    .addGap(132, 132, 132)))
        );
        jPanelFiltroLayout.setVerticalGroup(
            jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
            .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFiltroLayout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelFiltroLayout.createSequentialGroup()
                            .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldNombreFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelNombreFiltro))
                            .addGap(59, 59, 59)
                            .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldEdadFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelEdadFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanelFiltroLayout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelMarcaFiltro)
                                .addComponent(jComboBoxMarcaFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelPrecioFiltro)
                        .addComponent(jTextFieldPrecioFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelTipoFiltro))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAceptarFiltro)
                        .addComponent(jButtonCancelarFiltro))
                    .addContainerGap(60, Short.MAX_VALUE)))
        );

        jMenuArchivo.setText("Archivo");

        jMenuItemAgregar.setText("Agregar");
        jMenuItemAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgregarActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemAgregar);

        jMenuItemModificar.setText("Modificar");
        jMenuItemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemModificar);

        jMenuItemBorrar.setText("Borrar");
        jMenuItemBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBorrarActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemBorrar);

        jMenuItemFiltrar.setText("Filtrar");
        jMenuItemFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFiltrarActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemFiltrar);

        jMenuItemVista.setText("Vista");
        jMenuItemVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVistaActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemVista);

        jMenuItemGuardar.setText("Guardar");
        jMenuItemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardarActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemGuardar);

        jMenuItemCargar.setText("Cargar");
        jMenuItemCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCargarActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemCargar);

        jMenuBar1.add(jMenuArchivo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelEdicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelVista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jPanelEdicion, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanelVista, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addGap(11, 11, 11)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgregarActionPerformed
        setPanelVisible(jPanelEdicion);
        jLabelMuestraAccionEdicion.setText(TITULO_EDICION_AGREGAR);
        setEnabled(null, new JMenuItem[]{jMenuItemBorrar, jMenuItemAgregar, jMenuItemFiltrar, jMenuItemModificar, jMenuItemVista}, false);
    }//GEN-LAST:event_jMenuItemAgregarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JOptionPane.showConfirmDialog(this, "¿Estás seguro que quieres cerrar esta ventana?", "Alerta", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarActionPerformed
        setPanelVisible(jPanelEdicion);
        setEnabled(null, new JMenuItem[]{jMenuItemModificar, jMenuItemAgregar, jMenuItemFiltrar, jMenuItemBorrar}, false);
        if (!filtrando) {
            setEnabled(null, new JMenuItem[]{jMenuItemVista}, true);
        }
        jLabelMuestraAccionEdicion.setText(TITULO_EDICION_MODIFICAR);
        jTextFieldNombreEdicion.setText(control.getCarrouselFichas().get(control.getIndexFichaActual()).getNombre());
        boolean sal = false;
        for (int i = 0; i < jComboBoxMarcaEdicion.getItemCount() && !sal; i++) {
            if (((ComboOpciones) jComboBoxMarcaEdicion.getItemAt(i)).getText().equalsIgnoreCase(control.getCarrouselFichas().get(control.getIndexFichaActual()).getMarca())) {
                jComboBoxMarcaEdicion.setSelectedIndex(i);
                sal = true;
            }
        }
        sal = false;
        for (int i = 0; i < jComboBoxMarcaEdicion.getItemCount() && !sal; i++) {
            if (((ComboOpciones) jComboBoxTipoEdicion.getItemAt(i)).getText().equalsIgnoreCase(control.getCarrouselFichas().get(control.getIndexFichaActual()).getTipo())) {
                jComboBoxTipoEdicion.setSelectedIndex(i);
                sal = true;
            }
        }
        jTextFieldEdadEdicion.setText(control.getCarrouselFichas().get(control.getIndexFichaActual()).getEdad() + "");
        jTextFieldPrecioEdicion.setText(control.getCarrouselFichas().get(control.getIndexFichaActual()).getPrecio() + "");
        jLabelRutaImagenEdicion.setText(control.getCarrouselFichas().get(control.getIndexFichaActual()).getPathImage());
    }//GEN-LAST:event_jMenuItemModificarActionPerformed

    private void jMenuItemBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBorrarActionPerformed
        if (control.getTamanoCarrousel() != 0 && JOptionPane.showConfirmDialog(this, "¿Estás seguro que quieres borrar esta ficha?", "Alerta", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
            control.borraActual();
            if (control.getTamanoCarrousel() != 0) {
                muestraFicha(control.getCarrouselFichas(), control.getIndexFichaActual());
            } else {
                setEnabled(new JButton[]{jButtonAnterirorVista, jButtonSiguienteVista}, new JMenuItem[]{jMenuItemVista, jMenuItemGuardar, jMenuItemBorrar, jMenuItemFiltrar, jMenuItemModificar}, false);
                jButtonCancelFilterVista.setVisible(false);
                jLabelMuestraEdad.setText("");
                jLabelMuestraMarca.setText("");
                jLabelMuestraNombre.setText("");
                jLabelMuestraPrecio.setText("");
                jLabelMuestraTipo.setText("");
                jLabelFotoVista.setIcon(null);
                jLabelMaximoCarrouselVista.setText("X");
                jLabelMostrandoVista.setText("X");
            }
        }
    }//GEN-LAST:event_jMenuItemBorrarActionPerformed

    private void jMenuItemFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFiltrarActionPerformed
        setPanelVisible(jPanelFiltro);
        setEnabled(null, new JMenuItem[]{jMenuItemVista}, true);
        setEnabled(null, new JMenuItem[]{jMenuItemFiltrar, jMenuItemAgregar, jMenuItemBorrar, jMenuItemModificar}, false);
    }//GEN-LAST:event_jMenuItemFiltrarActionPerformed

    private void jMenuItemVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVistaActionPerformed
        setPanelVisible(jPanelVista);
        setEnabled(null, new JMenuItem[]{jMenuItemAgregar, jMenuItemBorrar, jMenuItemFiltrar, jMenuItemModificar}, true);
        setEnabled(null, new JMenuItem[]{jMenuItemVista}, false);
        muestraFicha(control.getCarrouselFichas(), control.getIndexFichaActual());
    }//GEN-LAST:event_jMenuItemVistaActionPerformed

    private void jMenuItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGuardarActionPerformed
        control.guardarEstado();
    }//GEN-LAST:event_jMenuItemGuardarActionPerformed

    private void jMenuItemCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCargarActionPerformed
        control.cargarEstado();
        setPanelVisible(jPanelVista);
        muestraFicha(control.getCarrouselFichas(), control.getIndexFichaActual());
        if (control.getTamanoCarrousel() != 0) {
            setEnabled(new JButton[]{jButtonAnterirorVista, jButtonSiguienteVista}, new JMenuItem[]{jMenuItemGuardar, jMenuItemBorrar, jMenuItemFiltrar, jMenuItemModificar, jMenuItemAgregar}, true);
        }
    }//GEN-LAST:event_jMenuItemCargarActionPerformed

    private void jButtonSiguienteVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteVistaActionPerformed
        if (!filtrando || filtrando && filtro.isEmpty()) {
            control.siguienteFicha();
            muestraFicha(control.getCarrouselFichas(), control.getIndexFichaActual());
        } else {
            indexFiltro++;
            indexFiltro %= filtro.size();
            muestraFicha(filtro, indexFiltro);
        }
    }//GEN-LAST:event_jButtonSiguienteVistaActionPerformed

    private void jButtonAnterirorVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnterirorVistaActionPerformed
        if (!filtrando || filtrando && filtro.isEmpty()) {
            control.anteriorFicha();
            muestraFicha(control.getCarrouselFichas(), control.getIndexFichaActual());
        } else {
            indexFiltro--;
            if (indexFiltro < 0) {
                indexFiltro = filtro.size() - 1;
            }
            muestraFicha(filtro, indexFiltro);
        }
    }//GEN-LAST:event_jButtonAnterirorVistaActionPerformed

    private void jButtonCancelFilterVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelFilterVistaActionPerformed
        jButtonCancelFilterVista.setVisible(false);
        setEnabled(null, new JMenuItem[]{jMenuItemGuardar, jMenuItemAgregar, jMenuItemBorrar, jMenuItemCargar, jMenuItemFiltrar, jMenuItemModificar}, true);
        setEnabled(null, new JMenuItem[]{jMenuItemVista}, false);
        filtrando = false;
        filtro.clear();
        muestraFicha(control.getCarrouselFichas(), control.getIndexFichaActual());
    }//GEN-LAST:event_jButtonCancelFilterVistaActionPerformed

    private void jButtonAceptarEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarEdicionActionPerformed
        String nombre = jTextFieldNombreEdicion.getText();
        String marca = jComboBoxMarcaEdicion.getSelectedItem().toString();
        String tipo = jComboBoxTipoEdicion.getSelectedItem().toString();
        int edad = getIntFromTextField(jTextFieldEdadEdicion);
        double precio = getDoubleFromTextField(jTextFieldPrecioEdicion);
        String pathImage = jLabelRutaImagenEdicion.getText();
        if (!controlFallosInputData(nombre, true, edad, precio)) {
            int antes = control.getTamanoCarrousel();
            if (jLabelMuestraAccionEdicion.getText().equals(TITULO_EDICION_AGREGAR)) {
                control.agregarFicha(nombre, marca, tipo, edad, precio, pathImage);
            } else {
                control.modificaFicha(nombre, marca, tipo, edad, precio, pathImage);
            }
            int despues = control.getTamanoCarrousel();
            if (antes != despues) {
                limpiarPantallaEdicion();
                if (antes == 0) {
                    setEnabled(new JButton[]{jButtonAnterirorVista, jButtonSiguienteVista}, new JMenuItem[]{jMenuItemGuardar}, true);
                }
            }
            int respuesta = 1;
            if (jLabelMuestraAccionEdicion.getText().equals(TITULO_EDICION_AGREGAR)) {
                respuesta = JOptionPane.showOptionDialog(this, "Acción " + jLabelMuestraAccionEdicion.getText() + " completada correctamente.\n¿Desea continuar agregando?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, JOptionPane.YES_OPTION);
            }
            if (respuesta == 1) {
                setPanelVisible(jPanelVista);
                muestraFicha(control.getCarrouselFichas(), control.getIndexFichaActual());
                setEnabled(null, new JMenuItem[]{jMenuItemAgregar, jMenuItemBorrar, jMenuItemFiltrar, jMenuItemModificar}, true);
                setEnabled(null, new JMenuItem[]{jMenuItemVista}, false);
            }
        }
    }//GEN-LAST:event_jButtonAceptarEdicionActionPerformed

    private void jButtonCancelarEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarEdicionActionPerformed
        limpiarPantallaEdicion();
        setPanelVisible(jPanelVista);
        setEnabled(null, new JMenuItem[]{jMenuItemAgregar}, true);
        if (control.getTamanoCarrousel() != 0) {
            setEnabled(null, new JMenuItem[]{jMenuItemBorrar, jMenuItemFiltrar, jMenuItemModificar}, true);
        }
        setEnabled(null, new JMenuItem[]{jMenuItemVista}, false);
        if (control.getCarrouselFichas().size() != 0) {
            muestraFicha(control.getCarrouselFichas(), control.getIndexFichaActual());
        }
    }//GEN-LAST:event_jButtonCancelarEdicionActionPerformed

    private void jTextFieldNombreEdicionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNombreEdicionFocusGained
        jTextFieldNombreEdicion.setBackground(Color.white);
        jTextFieldNombreEdicion.setForeground(Color.black);
    }//GEN-LAST:event_jTextFieldNombreEdicionFocusGained

    private void jTextFieldEdadEdicionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEdadEdicionFocusGained
        jTextFieldEdadEdicion.setBackground(Color.white);
        jTextFieldEdadEdicion.setForeground(Color.black);
    }//GEN-LAST:event_jTextFieldEdadEdicionFocusGained

    private void jTextFieldPrecioEdicionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPrecioEdicionFocusGained
        jTextFieldPrecioEdicion.setBackground(Color.white);
        jTextFieldPrecioEdicion.setForeground(Color.black);
    }//GEN-LAST:event_jTextFieldPrecioEdicionFocusGained

    private void jButtonAgregarFotoEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarFotoEdicionActionPerformed
        int valor = -1;
        valor = jFileChooserEdicion.showOpenDialog(this);
        if (valor == 0) {
            jLabelRutaImagenEdicion.setText(jFileChooserEdicion.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_jButtonAgregarFotoEdicionActionPerformed

    private void jButtonAceptarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarFiltroActionPerformed
        ArrayList<Ficha> borra = new ArrayList();
        String nombre = jTextFieldNombreFiltro.getText();
        String marca = jComboBoxMarcaFiltro.getSelectedItem().toString();
        String tipo = jComboBoxTipoFiltro.getSelectedItem().toString();
        int edad = 0;
        double precio = 0;
        boolean bedad = false, bprecio = false;
        if (!jTextFieldEdadFiltro.getText().equalsIgnoreCase("")) {
            edad = getIntFromTextField(jTextFieldEdadFiltro);
            bedad = true;
        }
        if (!jTextFieldPrecioFiltro.getText().equalsIgnoreCase("")) {
            precio = getDoubleFromTextField(jTextFieldPrecioFiltro);
            bprecio = true;
        }
        filtro.clear();
        if (!controlFallosInputData(null, false, edad, precio)) {
            if (!nombre.equalsIgnoreCase("")) {
                for (Ficha f : control.getCarrouselFichas()) {
                    if (f.getNombre().equalsIgnoreCase(nombre)) {
                        filtro.add(f);
                    }
                }
            }
            if (!marca.equalsIgnoreCase("")) {
                if (nombre.equalsIgnoreCase("")) {
                    for (Ficha f : control.getCarrouselFichas()) {
                        if (f.getMarca().equalsIgnoreCase(marca)) {
                            filtro.add(f);
                        }
                    }
                } else {
                    for (Ficha f : filtro) {
                        if (!f.getMarca().equalsIgnoreCase(marca)) {
                            borra.add(f);
                        }
                    }
                    filtro.removeAll(borra);
                    borra.clear();
                }
            }
            if (!tipo.equalsIgnoreCase("")) {
                if (nombre.equalsIgnoreCase("") && marca.equalsIgnoreCase("")) {
                    for (Ficha f : control.getCarrouselFichas()) {
                        if (f.getTipo().equalsIgnoreCase(tipo)) {
                            filtro.add(f);
                        }
                    }
                } else {
                    for (Ficha f : filtro) {
                        if (!f.getTipo().equalsIgnoreCase(tipo)) {
                            borra.add(f);
                        }
                    }
                    filtro.removeAll(borra);
                    borra.clear();
                }
            }
            if (bedad) {
                if (nombre.equalsIgnoreCase("") && marca.equalsIgnoreCase("") && tipo.equalsIgnoreCase("")) {
                    for (Ficha f : control.getCarrouselFichas()) {
                        if (f.getEdad() == edad) {
                            filtro.add(f);
                        }
                    }
                } else {
                    for (Ficha f : filtro) {
                        if (f.getEdad() != edad) {
                            borra.add(f);
                        }
                    }
                    filtro.removeAll(borra);
                    borra.clear();
                }
            }
            if (bprecio) {
                if (nombre.equalsIgnoreCase("") && marca.equalsIgnoreCase("") && tipo.equalsIgnoreCase("") && !bedad) {
                    for (Ficha f : control.getCarrouselFichas()) {
                        if (f.getPrecio() == precio) {
                            filtro.add(f);
                        }
                    }
                } else {
                    for (Ficha f : filtro) {
                        if (f.getPrecio() != precio) {
                            borra.add(f);
                        }
                    }
                    filtro.removeAll(borra);
                    borra.clear();
                }
            }
            limpiarPantallaFiltro();
            setPanelVisible(jPanelVista);
            if (!filtro.isEmpty()) {
                muestraFicha(filtro, 0);
                filtrando = true;
                jButtonCancelFilterVista.setVisible(true);
                setEnabled(null, new JMenuItem[]{jMenuItemVista, jMenuItemAgregar, jMenuItemBorrar, jMenuItemCargar, jMenuItemFiltrar, jMenuItemGuardar}, false);
            }else{
                JOptionPane.showMessageDialog(this, "Filtro no arroja resultados:", "ERROR", JOptionPane.ERROR_MESSAGE);
                setEnabled(null, new JMenuItem[]{jMenuItemAgregar, jMenuItemBorrar, jMenuItemCargar, jMenuItemFiltrar, jMenuItemGuardar,jMenuItemModificar}, true);
                setEnabled(null, new JMenuItem[]{jMenuItemVista}, false);
            }
        }
    }//GEN-LAST:event_jButtonAceptarFiltroActionPerformed

    private void jButtonCancelarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarFiltroActionPerformed
        limpiarPantallaFiltro();
        setPanelVisible(jPanelVista);
        muestraFicha(control.getCarrouselFichas(), control.getIndexFichaActual());
        setEnabled(null, new JMenuItem[]{jMenuItemAgregar, jMenuItemModificar, jMenuItemBorrar, jMenuItemCargar, jMenuItemFiltrar, jMenuItemGuardar}, true);
        setEnabled(null, new JMenuItem[]{jMenuItemVista}, false);
    }//GEN-LAST:event_jButtonCancelarFiltroActionPerformed

    private void jTextFieldNombreFiltroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNombreFiltroFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreFiltroFocusGained

    private void jTextFieldEdadFiltroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEdadFiltroFocusGained
        jTextFieldEdadFiltro.setBackground(Color.white);
        jTextFieldEdadFiltro.setForeground(Color.black);
    }//GEN-LAST:event_jTextFieldEdadFiltroFocusGained

    private void jTextFieldPrecioFiltroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPrecioFiltroFocusGained
        jTextFieldPrecioFiltro.setBackground(Color.white);
        jTextFieldPrecioFiltro.setForeground(Color.black);
    }//GEN-LAST:event_jTextFieldPrecioFiltroFocusGained

    public void setEnabled(JButton[] buttons, JMenuItem[] items, boolean b) {
        if (buttons != null) {
            for (JButton boton : buttons) {
                boton.setEnabled(b);
            }
        }
        if (items != null) {
            for (JMenuItem i : items) {
                i.setEnabled(b);
            }
        }
    }

    public boolean controlFallosInputData(String nombre, boolean evaluoNombre, int edad, double precio) {
        boolean error1 = false, error2 = false, error;
        StringBuffer cadena = new StringBuffer();
        if (edad < 0 || precio < 0) {
            cadena.append("\nEsto no es un numero o no tiene un formato adecuado.");
            error1 = true;
        }
        if (evaluoNombre && nombre.equals("")) {
            jTextFieldNombreEdicion.setBackground(Color.red);
            jTextFieldNombreEdicion.setForeground(Color.white);
            cadena.append("\nEl campo del nombre ha de tener algún valor");
            error2 = true;
        }
        error = error1 || error2;
        if (error) {
            JOptionPane.showMessageDialog(this, "Se han dado los siguientes errores:" + cadena.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return error;
    }

    public int getIntFromTextField(JTextField t) {
        int value;
        try {
            value = Integer.parseInt(t.getText());
        } catch (NumberFormatException e) {
            t.setBackground(Color.red);
            t.setForeground(Color.white);
            value = -1;
        }
        return value;
    }

    public double getDoubleFromTextField(JTextField t) {
        double value;
        try {
            value = Double.parseDouble(t.getText());
        } catch (NumberFormatException e) {
            try {
                value = (double) Float.parseFloat(t.getText());
            } catch (NumberFormatException f) {
                t.setBackground(Color.red);
                t.setForeground(Color.white);
                value = -1;
            }
        }
        return value;
    }

    public void setPanelVisible(JPanel panel) {
        jPanelEdicion.setVisible(false);
        jPanelVista.setVisible(false);
        jPanelFiltro.setVisible(false);
        panel.setVisible(true);
    }

    public void limpiarPantallaEdicion() {
        jComboBoxMarcaEdicion.setSelectedIndex(0);
        jComboBoxTipoEdicion.setSelectedIndex(0);
        jTextFieldEdadEdicion.setText("");
        jTextFieldNombreEdicion.setText("");
        jTextFieldPrecioEdicion.setText("");
        jLabelRutaImagenEdicion.setText("");
    }

    public void limpiarPantallaFiltro() {
        jComboBoxMarcaFiltro.setSelectedIndex(0);
        jComboBoxTipoFiltro.setSelectedIndex(0);
        jTextFieldEdadFiltro.setText("");
        jTextFieldNombreFiltro.setText("");
        jTextFieldPrecioFiltro.setText("");
    }

    public void muestraFicha(ArrayList<Ficha> fichas, int pos) {
        Ficha muestrame = fichas.get(pos);
        if (muestrame != null) {
            jLabelMuestraNombre.setText(muestrame.getNombre());
            jLabelMuestraEdad.setText(muestrame.getEdad() + "");
            jLabelMuestraMarca.setText(muestrame.getMarca());
            jLabelMuestraTipo.setText(muestrame.getTipo());
            jLabelMuestraPrecio.setText(muestrame.getPrecio() + "");
            jLabelFotoVista.setIcon(control.getImagen(muestrame.getPathImageMostrar()));
            jLabelMostrandoVista.setText((pos + 1) + "");
            jLabelMaximoCarrouselVista.setText("" + fichas.size());
        }
    }
    
    public ControlFichas getControl(){
        return control;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptarEdicion;
    private javax.swing.JButton jButtonAceptarFiltro;
    private javax.swing.JButton jButtonAgregarFotoEdicion;
    private javax.swing.JButton jButtonAnterirorVista;
    private javax.swing.JButton jButtonCancelFilterVista;
    private javax.swing.JButton jButtonCancelarEdicion;
    private javax.swing.JButton jButtonCancelarFiltro;
    private javax.swing.JButton jButtonSiguienteVista;
    private javax.swing.JComboBox jComboBoxMarcaEdicion;
    private javax.swing.JComboBox jComboBoxMarcaFiltro;
    private javax.swing.JComboBox jComboBoxTipoEdicion;
    private javax.swing.JComboBox jComboBoxTipoFiltro;
    private javax.swing.JFileChooser jFileChooserEdicion;
    private javax.swing.JLabel jLabelDeVista;
    private javax.swing.JLabel jLabelEdadEdicion;
    private javax.swing.JLabel jLabelEdadFiltro;
    private javax.swing.JLabel jLabelEdadVista;
    private javax.swing.JLabel jLabelFotoVista;
    private javax.swing.JLabel jLabelMarcaEdicion;
    private javax.swing.JLabel jLabelMarcaFiltro;
    private javax.swing.JLabel jLabelMarcaVista;
    private javax.swing.JLabel jLabelMaximoCarrouselVista;
    private javax.swing.JLabel jLabelMostrandoVista;
    private javax.swing.JLabel jLabelMuestraAccionEdicion;
    private javax.swing.JLabel jLabelMuestraEdad;
    private javax.swing.JLabel jLabelMuestraMarca;
    private javax.swing.JLabel jLabelMuestraNombre;
    private javax.swing.JLabel jLabelMuestraPrecio;
    private javax.swing.JLabel jLabelMuestraTipo;
    private javax.swing.JLabel jLabelNombreEdicion;
    private javax.swing.JLabel jLabelNombreFiltro;
    private javax.swing.JLabel jLabelNombreVista;
    private javax.swing.JLabel jLabelPrecioEdicion;
    private javax.swing.JLabel jLabelPrecioFiltro;
    private javax.swing.JLabel jLabelPrecioVista;
    private javax.swing.JLabel jLabelRutaImagenEdicion;
    private javax.swing.JLabel jLabelTipoEdicion;
    private javax.swing.JLabel jLabelTipoFiltro;
    private javax.swing.JLabel jLabelTipoVista;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAgregar;
    private javax.swing.JMenuItem jMenuItemBorrar;
    private javax.swing.JMenuItem jMenuItemCargar;
    private javax.swing.JMenuItem jMenuItemFiltrar;
    private javax.swing.JMenuItem jMenuItemGuardar;
    private javax.swing.JMenuItem jMenuItemModificar;
    private javax.swing.JMenuItem jMenuItemVista;
    private javax.swing.JPanel jPanelBaseVista;
    private javax.swing.JPanel jPanelEdicion;
    private javax.swing.JPanel jPanelFiltro;
    private javax.swing.JPanel jPanelVista;
    private javax.swing.JTextField jTextFieldEdadEdicion;
    private javax.swing.JTextField jTextFieldEdadFiltro;
    private javax.swing.JTextField jTextFieldNombreEdicion;
    private javax.swing.JTextField jTextFieldNombreFiltro;
    private javax.swing.JTextField jTextFieldPrecioEdicion;
    private javax.swing.JTextField jTextFieldPrecioFiltro;
    // End of variables declaration//GEN-END:variables
}
