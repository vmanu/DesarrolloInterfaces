/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import static constantes.Constantes.*;
import static constantes.ComboItems.*;
import control.ControlCoches;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.Coche;
import model.ComboOpciones;

/**
 *
 * @author oscar
 */
public class JFrameCoches extends javax.swing.JFrame {

    private ControlCoches controlCoches;
    private boolean filtrando;
    private ArrayList<Coche> filtro;
    private int indexFiltro;

    /**
     * Creates new form JFrameCoches
     */
    public JFrameCoches() {
        initComponents();
        controlCoches = new ControlCoches();
        controlCoches.cargar();
        jPanelAdd.setVisible(false);
        jPanelBuscar.setVisible(false);
        jPanelVista.setVisible(false);
        setNombres();
        jRadioButtonV1.setEnabled(false);
        jRadioButtonV2.setEnabled(false);
        jRadioButtonV3.setEnabled(false);
        jRadioButtonV4.setEnabled(false);
        jRadioButtonV5.setEnabled(false);
        filtro = new ArrayList();
        filtrando = false;
        indexFiltro = 0;
        rellenaCombo(jComboBoxAMarcas);
        rellenaCombo(jComboBoxBMarcas);
    }

    public void setNombres() {
        jMenu1.setName(MENU_ARCHIVO);
        jMenuItemAdd.setName(MENU_AGREGAR);
        jMenuItemVer.setName(MENU_VISTA);
        jMenuItemCargar.setName(MENU_CARGAR);
        jMenuBuscar.setName(MENU_FILTRAR);
        jComboBoxAMarcas.setName(COMBO_A);
        jComboBoxBMarcas.setName(COMBO_B);
        jRadioButton1.setName(RADIOBUTTON_A_1);
        jRadioButton2.setName(RADIOBUTTON_A_2);
        jRadioButton3.setName(RADIOBUTTON_A_3);
        jRadioButton4.setName(RADIOBUTTON_A_4);
        jRadioButton5.setName(RADIOBUTTON_A_5);
        jRadioButtonB1.setName(RADIOBUTTON_B_1);
        jRadioButtonB2.setName(RADIOBUTTON_B_2);
        jRadioButtonB3.setName(RADIOBUTTON_B_3);
        jRadioButtonB4.setName(RADIOBUTTON_B_4);
        jRadioButtonB5.setName(RADIOBUTTON_B_5);
        jRadioButtonV1.setName(RADIOBUTTON_C_1);
        jRadioButtonV2.setName(RADIOBUTTON_C_2);
        jRadioButtonV3.setName(RADIOBUTTON_C_3);
        jRadioButtonV4.setName(RADIOBUTTON_C_4);
        jRadioButtonV5.setName(RADIOBUTTON_C_5);
        jRadioButton1.setActionCommand(RADIOBUTTON_A_1);
        jRadioButton2.setActionCommand(RADIOBUTTON_A_2);
        jRadioButton3.setActionCommand(RADIOBUTTON_A_3);
        jRadioButton4.setActionCommand(RADIOBUTTON_A_4);
        jRadioButton5.setActionCommand(RADIOBUTTON_A_5);
        jRadioButtonB1.setActionCommand(RADIOBUTTON_A_1);
        jRadioButtonB2.setActionCommand(RADIOBUTTON_A_2);
        jRadioButtonB3.setActionCommand(RADIOBUTTON_A_3);
        jRadioButtonB4.setActionCommand(RADIOBUTTON_A_4);
        jRadioButtonB5.setActionCommand(RADIOBUTTON_A_5);
        jRadioButtonV1.setActionCommand(RADIOBUTTON_A_1);
        jRadioButtonV2.setActionCommand(RADIOBUTTON_A_2);
        jRadioButtonV3.setActionCommand(RADIOBUTTON_A_3);
        jRadioButtonV4.setActionCommand(RADIOBUTTON_A_4);
        jRadioButtonV5.setActionCommand(RADIOBUTTON_A_5);
        jButtonAnterior.setName(BOTON_ANTERIOR_VISTA);
        jButtonSiguiente.setName(BOTON_SIGUIENTE_VISTA);
        jButtonAdd.setName(BOTON_ACEPTAR_AGREGA);
        jButtonBuscar.setName(BOTON_ACEPTAR_FILTRO);
        jPanelVista.setName(PANEL_VISTA);
        jPanelBuscar.setName(PANEL_BUSCAR);
        jPanelAdd.setName(PANEL_ADD);
        jTextFieldAModelo.setName(EDITEXT_MODELO_AGREGA);
        jTextFieldAPrecio.setName(EDITEXT_PRECIO_AGREGA);
        jTextFieldBModelo.setName(EDITEXT_MODELO_FILTRO);
        jTextFieldBPrecio.setName(EDITEXT_PRECIO_FILTRO);
        jLabelMarca.setName(LABEL_MARCA);
        jLabelModelo.setName(LABEL_MODELO);
        jLabelPrecio.setName(LABEL_PRECIO);
    }

    private void rellenaCombo(JComboBox combo) {
        combo.removeAllItems();
        if (combo.equals(jComboBoxBMarcas)) {
            combo.addItem(new ComboOpciones("", null));
        }
        combo.addItem(new ComboOpciones("Opel", OPEL));
        combo.addItem(new ComboOpciones("Muñecas", HONDA));
        combo.addItem(new ComboOpciones("Construcción", SUZUKI));
        combo.addItem(new ComboOpciones("Manualidades", FORD));
        combo.addItem(new ComboOpciones("Coches", SEAT));
        combo.addItem(new ComboOpciones("Juego de mesa", AUDI));
        combo.addItem(new ComboOpciones("Puzzles", MERCEDES));
        combo.addItem(new ComboOpciones("Cocinitas", FERRARI));
        combo.addItem(new ComboOpciones("Casa de muñecas", RENAULT));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupA = new javax.swing.ButtonGroup();
        buttonGroupB = new javax.swing.ButtonGroup();
        buttonGroupV = new javax.swing.ButtonGroup();
        jPanelVista = new javax.swing.JPanel();
        jRadioButtonV1 = new javax.swing.JRadioButton();
        jRadioButtonV2 = new javax.swing.JRadioButton();
        jRadioButtonV3 = new javax.swing.JRadioButton();
        jRadioButtonV4 = new javax.swing.JRadioButton();
        jRadioButtonV5 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabelMarca = new javax.swing.JLabel();
        jLabelModelo = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jButtonAnterior = new javax.swing.JButton();
        jButtonSiguiente = new javax.swing.JButton();
        jPanelBuscar = new javax.swing.JPanel();
        jRadioButtonB1 = new javax.swing.JRadioButton();
        jRadioButtonB2 = new javax.swing.JRadioButton();
        jRadioButtonB3 = new javax.swing.JRadioButton();
        jRadioButtonB4 = new javax.swing.JRadioButton();
        jRadioButtonB5 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxBMarcas = new javax.swing.JComboBox<String>();
        jTextFieldBModelo = new javax.swing.JTextField();
        jTextFieldBPrecio = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jPanelAdd = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jComboBoxAMarcas = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldAModelo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldAPrecio = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemAdd = new javax.swing.JMenuItem();
        jMenuItemVer = new javax.swing.JMenuItem();
        jMenuBuscar = new javax.swing.JMenuItem();
        jMenuItemCargar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));

        jPanelVista.setPreferredSize(new java.awt.Dimension(400, 400));
        jPanelVista.setRequestFocusEnabled(false);

        buttonGroupV.add(jRadioButtonV1);
        jRadioButtonV1.setText("1");

        buttonGroupV.add(jRadioButtonV2);
        jRadioButtonV2.setText("2");

        buttonGroupV.add(jRadioButtonV3);
        jRadioButtonV3.setText("3");

        buttonGroupV.add(jRadioButtonV4);
        jRadioButtonV4.setText("4");

        buttonGroupV.add(jRadioButtonV5);
        jRadioButtonV5.setText("5");

        jLabel9.setText("marca");

        jLabel10.setText("modelo");

        jLabel11.setText("asientos");

        jLabel12.setText("precio");

        jLabelMarca.setText("-------");

        jLabelModelo.setText("-------");

        jLabelPrecio.setText("-------");

        jButtonAnterior.setText("anterior");
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });

        jButtonSiguiente.setText("siguiente");
        jButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelVistaLayout = new javax.swing.GroupLayout(jPanelVista);
        jPanelVista.setLayout(jPanelVistaLayout);
        jPanelVistaLayout.setHorizontalGroup(
            jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVistaLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelVistaLayout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelPrecio))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVistaLayout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelModelo))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVistaLayout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelMarca))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVistaLayout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jRadioButtonV1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jRadioButtonV2)))
                    .addGroup(jPanelVistaLayout.createSequentialGroup()
                        .addComponent(jButtonAnterior)
                        .addGap(81, 81, 81)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonV3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVistaLayout.createSequentialGroup()
                        .addComponent(jRadioButtonV4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonV5))
                    .addComponent(jButtonSiguiente))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanelVistaLayout.setVerticalGroup(
            jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVistaLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabelMarca))
                .addGap(18, 18, 18)
                .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabelModelo))
                .addGap(35, 35, 35)
                .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButtonV1)
                        .addComponent(jRadioButtonV5)
                        .addComponent(jRadioButtonV3)
                        .addComponent(jRadioButtonV2)
                        .addComponent(jRadioButtonV4)))
                .addGap(27, 27, 27)
                .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabelPrecio))
                .addGap(46, 46, 46)
                .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnterior)
                    .addComponent(jButtonSiguiente))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        buttonGroupB.add(jRadioButtonB1);
        jRadioButtonB1.setText("1");

        buttonGroupB.add(jRadioButtonB2);
        jRadioButtonB2.setText("2");

        buttonGroupB.add(jRadioButtonB3);
        jRadioButtonB3.setText("3");

        buttonGroupB.add(jRadioButtonB4);
        jRadioButtonB4.setText("4");

        buttonGroupB.add(jRadioButtonB5);
        jRadioButtonB5.setText("5");

        jLabel5.setText("marca");

        jLabel6.setText("modelo");

        jLabel7.setText("asientos");

        jLabel8.setText("precio");

        jComboBoxBMarcas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextFieldBPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBPrecioActionPerformed(evt);
            }
        });

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBuscarLayout = new javax.swing.GroupLayout(jPanelBuscar);
        jPanelBuscar.setLayout(jPanelBuscarLayout);
        jPanelBuscarLayout.setHorizontalGroup(
            jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(26, 26, 26)
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBuscar)
                    .addComponent(jTextFieldBPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxBMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelBuscarLayout.createSequentialGroup()
                        .addComponent(jRadioButtonB1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonB2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButtonB3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonB4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonB5)))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanelBuscarLayout.setVerticalGroup(
            jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarLayout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxBMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonB1)
                    .addComponent(jRadioButtonB2)
                    .addComponent(jRadioButtonB3)
                    .addComponent(jRadioButtonB5)
                    .addComponent(jRadioButtonB4)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldBPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jButtonBuscar)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        jPanelAdd.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanelAdd.setPreferredSize(new java.awt.Dimension(400, 400));

        jButtonAdd.setText("Añadir");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jComboBoxAMarcas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("marca");

        jLabel2.setText("modelo");

        jTextFieldAModelo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldAModeloFocusGained(evt);
            }
        });

        jLabel3.setText("asientos");

        buttonGroupA.add(jRadioButton1);
        jRadioButton1.setText("1");

        buttonGroupA.add(jRadioButton2);
        jRadioButton2.setText("2");

        buttonGroupA.add(jRadioButton3);
        jRadioButton3.setText("3");

        buttonGroupA.add(jRadioButton4);
        jRadioButton4.setText("4");

        buttonGroupA.add(jRadioButton5);
        jRadioButton5.setText("5");

        jLabel4.setText("precio");

        jTextFieldAPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldAPrecioFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanelAddLayout = new javax.swing.GroupLayout(jPanelAdd);
        jPanelAdd.setLayout(jPanelAddLayout);
        jPanelAddLayout.setHorizontalGroup(
            jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(43, 43, 43)
                .addGroup(jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldAModelo)
                        .addComponent(jComboBoxAMarcas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTextFieldAPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelAddLayout.createSequentialGroup()
                        .addGroup(jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelAddLayout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton5)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanelAddLayout.setVerticalGroup(
            jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAddLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxAMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addGroup(jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldAModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5))
                .addGap(29, 29, 29)
                .addGroup(jPanelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldAPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jButtonAdd)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jMenu1.setText("Coches");

        jMenuItemAdd.setText("Añadir");
        jMenuItemAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAdd);

        jMenuItemVer.setText("Ver");
        jMenuItemVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemVer);

        jMenuBuscar.setText("Buscar");
        jMenuBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuBuscarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuBuscar);

        jMenuItemCargar.setText("Cargar");
        jMenuItemCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCargarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCargar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelVista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 107, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jPanelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(jPanelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(54, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelVista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jPanelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(jPanelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(49, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCargarActionPerformed
        controlCoches.cargar();
        setPanelVisible(jPanelVista);
        filtrando = false;
        pintarDatos(controlCoches.getTodosCoches());
    }//GEN-LAST:event_jMenuItemCargarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        ArrayList<Coche> borra = new ArrayList();
        String modelo = jTextFieldBModelo.getText();
        String marca = jComboBoxBMarcas.getSelectedItem().toString();
        int asientos = 0;
        if (buttonGroupB.getSelection() != null) {
            switch (buttonGroupB.getSelection().getActionCommand()) {
                case RADIOBUTTON_A_1:
                    asientos = 1;
                    break;
                case RADIOBUTTON_A_2:
                    asientos = 2;
                    break;
                case RADIOBUTTON_A_3:
                    asientos = 3;
                    break;
                case RADIOBUTTON_A_4:
                    asientos = 4;
                    break;
                case RADIOBUTTON_A_5:
                    asientos = 5;
                    break;
            }
        }
        double precio = 0;
        boolean bprecio = false;
        if (!jTextFieldBPrecio.getText().equalsIgnoreCase("")) {
            precio = getDoubleFromTextField(jTextFieldBPrecio);
            bprecio = true;
        }
        filtro.clear();
        if (!controlFallosInputData(null, false, precio, null)) {
            if (!marca.equalsIgnoreCase("")) {
                for (Coche f : controlCoches.getTodosCoches()) {
                    if (f.getMarca().equalsIgnoreCase(marca)) {
                        filtro.add(f);
                    }
                }
            }
            if (!modelo.equalsIgnoreCase("")) {
                if (modelo.equalsIgnoreCase("")) {
                    for (Coche f : controlCoches.getTodosCoches()) {
                        if (f.getModelo().equalsIgnoreCase(modelo)) {
                            filtro.add(f);
                        }
                    }
                } else {
                    for (Coche f : filtro) {
                        if (!f.getModelo().equalsIgnoreCase(modelo)) {
                            borra.add(f);
                        }
                    }
                    filtro.removeAll(borra);
                    borra.clear();
                }
            }
            if (asientos != 0) {
                if (modelo.equalsIgnoreCase("") && marca.equalsIgnoreCase("")) {
                    for (Coche f : controlCoches.getTodosCoches()) {
                        if (f.getNumeroAsientos() == asientos) {
                            filtro.add(f);
                        }
                    }
                } else {
                    for (Coche f : filtro) {
                        if (f.getNumeroAsientos() != asientos) {
                            borra.add(f);
                        }
                    }
                    filtro.removeAll(borra);
                    borra.clear();
                }
            }
            if (bprecio) {
                if (modelo.equalsIgnoreCase("") && marca.equalsIgnoreCase("") && asientos != 0) {
                    for (Coche f : controlCoches.getTodosCoches()) {
                        if (f.getPrecio() == precio) {
                            filtro.add(f);
                        }
                    }
                } else {
                    for (Coche f : filtro) {
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
                indexFiltro = 0;
                filtrando = true;
                pintarDatos(filtro);
            } else {
                JOptionPane.showMessageDialog(this, "Filtro no arroja resultados", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jMenuItemAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddActionPerformed
        setPanelVisible(jPanelAdd);
        filtrando = false;
        buttonGroupA.clearSelection();
        jRadioButton1.setSelected(true);
    }//GEN-LAST:event_jMenuItemAddActionPerformed

    private void jMenuItemVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerActionPerformed
        setPanelVisible(jPanelVista);
        filtrando = false;
        pintarDatos(controlCoches.getTodosCoches());
    }//GEN-LAST:event_jMenuItemVerActionPerformed

    private void jMenuBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuBuscarActionPerformed
        setPanelVisible(jPanelBuscar);
    }//GEN-LAST:event_jMenuBuscarActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        String marca = jComboBoxAMarcas.getSelectedItem().toString();
        String modelo = jTextFieldAModelo.getText();
        int asientos = 0;
        
        switch (buttonGroupA.getSelection().getActionCommand()) {
            case RADIOBUTTON_A_1:
                asientos = 1;
                break;
            case RADIOBUTTON_A_2:
                asientos = 2;
                break;
            case RADIOBUTTON_A_3:
                asientos = 3;
                break;
            case RADIOBUTTON_A_4:
                asientos = 4;
                break;
            case RADIOBUTTON_A_5:
                asientos = 5;
                break;
        }
        double precio = getDoubleFromTextField(jTextFieldAPrecio);
        if (!controlFallosInputData(modelo, true, precio, jTextFieldAModelo)&&asientos!=0) {
            controlCoches.agregarCoche(marca, modelo, asientos, precio);
            setPanelVisible(jPanelVista);
            pintarDatos(controlCoches.getTodosCoches());
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteActionPerformed
        if (!filtrando) {
            controlCoches.siguiente();
        } else {
            indexFiltro++;
            indexFiltro%=filtro.size();
        }
        pintarDatos(filtrando ? filtro : controlCoches.getTodosCoches());
    }//GEN-LAST:event_jButtonSiguienteActionPerformed

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        if (!filtrando) {
            controlCoches.anterior();
        } else {
            indexFiltro--;
            if(indexFiltro<0){
                indexFiltro=filtro.size()-1;
            }
        }
        pintarDatos(filtrando ? filtro : controlCoches.getTodosCoches());
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jTextFieldAModeloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAModeloFocusGained
        jTextFieldAModelo.setBackground(Color.white);
        jTextFieldAModelo.setForeground(Color.black);
    }//GEN-LAST:event_jTextFieldAModeloFocusGained

    private void jTextFieldAPrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAPrecioFocusGained
        jTextFieldAPrecio.setBackground(Color.white);
        jTextFieldAPrecio.setForeground(Color.black);
    }//GEN-LAST:event_jTextFieldAPrecioFocusGained

    private void jTextFieldBPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBPrecioActionPerformed
        jTextFieldBPrecio.setBackground(Color.white);
        jTextFieldBPrecio.setForeground(Color.black);
    }//GEN-LAST:event_jTextFieldBPrecioActionPerformed

    public void limpiarPantallaFiltro() {
        jTextFieldBModelo.setText("");
        jTextFieldBPrecio.setText("");
        jComboBoxBMarcas.setSelectedIndex(0);
        buttonGroupB.clearSelection();
    }

    public double getDoubleFromTextField(JTextField t) {
        double value;
        try {
            value = Double.parseDouble(t.getText());
        } catch (NumberFormatException e) {
            t.setBackground(Color.red);
            t.setForeground(Color.white);
            value = -1;
        }
        return value;
    }

    public boolean controlFallosInputData(String modelo, boolean evaluoModelo, double precio, JTextField textField) {
        boolean error1 = false, error2 = false, error;
        StringBuffer cadena = new StringBuffer();
        if (precio < 0) {
            cadena.append("\nEsto no es un numero o no tiene un formato adecuado.");
            error1 = true;
        }
        if (evaluoModelo && modelo.equals("")) {
            textField.setBackground(Color.red);
            textField.setForeground(Color.white);
            cadena.append("\nEl campo del modelo ha de tener algún valor");
            error2 = true;
        }
        error = error1 || error2;
        if (error) {
            JOptionPane.showMessageDialog(this, "Se han dado los siguientes errores:" + cadena.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return error;
    }

    public void pintarDatos(ArrayList<Coche> lista) {
        int index = filtrando ? indexFiltro : controlCoches.getIndex();
        if (lista.size() != 0) {
            jLabelMarca.setText(lista.get(index).getMarca());
            jLabelModelo.setText(lista.get(index).getModelo());
            buttonGroupV.clearSelection();
            switch (lista.get(index).getNumeroAsientos()) {
                case 1:
                    jRadioButtonV1.setSelected(true);
                    break;
                case 2:
                    jRadioButtonV2.setSelected(true);
                    break;
                case 3:
                    jRadioButtonV3.setSelected(true);
                    break;
                case 4:
                    jRadioButtonV4.setSelected(true);
                    break;
                case 5:
                    jRadioButtonV5.setSelected(true);
                    break;
            }
            jLabelPrecio.setText(lista.get(index).getPrecio() + "");
        }
    }

    public void setPanelVisible(JPanel panel) {
        jPanelAdd.setVisible(false);
        jPanelVista.setVisible(false);
        jPanelBuscar.setVisible(false);
        panel.setVisible(true);
    }

    public ControlCoches getControl() {
        return controlCoches;
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
            java.util.logging.Logger.getLogger(JFrameCoches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameCoches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameCoches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameCoches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameCoches().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupA;
    private javax.swing.ButtonGroup buttonGroupB;
    private javax.swing.ButtonGroup buttonGroupV;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonSiguiente;
    private javax.swing.JComboBox<String> jComboBoxAMarcas;
    private javax.swing.JComboBox<String> jComboBoxBMarcas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuBuscar;
    private javax.swing.JMenuItem jMenuItemAdd;
    private javax.swing.JMenuItem jMenuItemCargar;
    private javax.swing.JMenuItem jMenuItemVer;
    private javax.swing.JPanel jPanelAdd;
    private javax.swing.JPanel jPanelBuscar;
    private javax.swing.JPanel jPanelVista;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButtonB1;
    private javax.swing.JRadioButton jRadioButtonB2;
    private javax.swing.JRadioButton jRadioButtonB3;
    private javax.swing.JRadioButton jRadioButtonB4;
    private javax.swing.JRadioButton jRadioButtonB5;
    private javax.swing.JRadioButton jRadioButtonV1;
    private javax.swing.JRadioButton jRadioButtonV2;
    private javax.swing.JRadioButton jRadioButtonV3;
    private javax.swing.JRadioButton jRadioButtonV4;
    private javax.swing.JRadioButton jRadioButtonV5;
    private javax.swing.JTextField jTextFieldAModelo;
    private javax.swing.JTextField jTextFieldAPrecio;
    private javax.swing.JTextField jTextFieldBModelo;
    private javax.swing.JTextField jTextFieldBPrecio;
    // End of variables declaration//GEN-END:variables

}
