/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uva.ipc.libreria.vista;

import java.awt.Color;
import java.util.ArrayList;
import uva.ipc.libreria.modelo.Libro;

/**
 * Esta es la clase vista Edición Manual de la aplicación.
 * IMPORTANTE: Al editar un registro, además de cargar los campos que sean necesarios,
 * se bloquean todos los elementos con los que no se debería poder interactuar. 
 * @author juagonz0
 * @author alemina
 */
public class VistaEdicionManual extends javax.swing.JFrame {

    private final ControladorEdicionManual controladorLibreria;
    
    /**
     * Constructor de la vista. Se encarga de conectar la vista a un controlador de la edicion manual.
     */
    public VistaEdicionManual() {
        initComponents();
        this.controladorLibreria = new ControladorEdicionManual(this);
    }

    /**
     * Constructor de la vista. Se encarga de conectar la vista a un controlador.
     * Precarga un libro para su edición directamente.
     * @param isbn String con el isbn
     */
    public VistaEdicionManual(String isbn) {
        initComponents();
        this.controladorLibreria = new ControladorEdicionManual(this);
        controladorLibreria.procesaEventoEditar(isbn);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelMenu = new javax.swing.JPanel();
        jButtonMenuInicial = new javax.swing.JButton();
        jButtonBusqueda = new javax.swing.JButton();
        jPanelIzq = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jLabelDescr = new javax.swing.JLabel();
        jScrollPaneDescr = new javax.swing.JScrollPane();
        jTextAreaDescr = new javax.swing.JTextArea();
        jLabelISBN = new javax.swing.JLabel();
        jTextFieldISBN = new javax.swing.JTextField();
        jLabelEstado = new javax.swing.JLabel();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        jLabelPrecio = new javax.swing.JLabel();
        jSpinnerPrecio = new javax.swing.JSpinner();
        jCheckBoxLeido = new javax.swing.JCheckBox();
        jScrollPaneRegistro = new javax.swing.JScrollPane();
        jListRegistro = new javax.swing.JList<>();
        jButtonGuardar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jPanelAba = new javax.swing.JPanel();
        jLabelMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edición Manual");
        setMinimumSize(new java.awt.Dimension(700, 400));
        setPreferredSize(new java.awt.Dimension(700, 400));

        jPanelMenu.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButtonMenuInicial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uva/ipc/libreria/vista/imagenes/Gnome-go-home.png"))); // NOI18N
        jButtonMenuInicial.setToolTipText("Menu Inicial");
        jButtonMenuInicial.setFocusable(false);
        jButtonMenuInicial.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonMenuInicial.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonMenuInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuInicialActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonMenuInicial);

        jButtonBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uva/ipc/libreria/vista/imagenes/lupa.png"))); // NOI18N
        jButtonBusqueda.setToolTipText("Busqueda de libro");
        jButtonBusqueda.setFocusable(false);
        jButtonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBusquedaActionPerformed(evt);
            }
        });
        jPanelMenu.add(jButtonBusqueda);

        getContentPane().add(jPanelMenu, java.awt.BorderLayout.PAGE_START);

        jPanelIzq.setLayout(new java.awt.GridBagLayout());

        jLabelTitulo.setText("Título");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        jPanelIzq.add(jLabelTitulo, gridBagConstraints);

        jTextFieldTitulo.setToolTipText("Título entre 1 y 20 caracteres. \nNo pude contener el carácter ;");
        jTextFieldTitulo.setNextFocusableComponent(jTextAreaDescr);
        jTextFieldTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldTituloKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanelIzq.add(jTextFieldTitulo, gridBagConstraints);

        jLabelDescr.setText("Descripción");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanelIzq.add(jLabelDescr, gridBagConstraints);

        jTextAreaDescr.setColumns(20);
        jTextAreaDescr.setLineWrap(true);
        jTextAreaDescr.setRows(5);
        jTextAreaDescr.setToolTipText("La descripción no puede contener el carácter ;");
        jTextAreaDescr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextAreaDescrKeyReleased(evt);
            }
        });
        jScrollPaneDescr.setViewportView(jTextAreaDescr);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanelIzq.add(jScrollPaneDescr, gridBagConstraints);

        jLabelISBN.setText("ISBN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanelIzq.add(jLabelISBN, gridBagConstraints);

        jTextFieldISBN.setToolTipText("ISBN entre 1 y 13 números, con guiones o sin ellos.");
        jTextFieldISBN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldISBNKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanelIzq.add(jTextFieldISBN, gridBagConstraints);

        jLabelEstado.setText("Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanelIzq.add(jLabelEstado, gridBagConstraints);

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bueno", "Regular", "Malo" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanelIzq.add(jComboBoxEstado, gridBagConstraints);

        jLabelPrecio.setText("Precio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanelIzq.add(jLabelPrecio, gridBagConstraints);

        jSpinnerPrecio.setModel(new javax.swing.SpinnerNumberModel());
        jSpinnerPrecio.setToolTipText("Precio es un número positivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanelIzq.add(jSpinnerPrecio, gridBagConstraints);

        jCheckBoxLeido.setText("Ya lo he leído");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanelIzq.add(jCheckBoxLeido, gridBagConstraints);

        jListRegistro.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListRegistroMouseClicked(evt);
            }
        });
        jScrollPaneRegistro.setViewportView(jListRegistro);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        jPanelIzq.add(jScrollPaneRegistro, gridBagConstraints);

        jButtonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uva/ipc/libreria/vista/imagenes/Gnome-media-floppy.png"))); // NOI18N
        jButtonGuardar.setToolTipText("Guardar");
        jButtonGuardar.setFocusable(false);
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanelIzq.add(jButtonGuardar, gridBagConstraints);

        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uva/ipc/libreria/vista/imagenes/Gnome-accessories-text-editor.png"))); // NOI18N
        jButtonEditar.setToolTipText("Editar");
        jButtonEditar.setFocusable(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanelIzq.add(jButtonEditar, gridBagConstraints);

        jButtonBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uva/ipc/libreria/vista/imagenes/Gnome-edit-delete.png"))); // NOI18N
        jButtonBorrar.setToolTipText("Borrar");
        jButtonBorrar.setFocusable(false);
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanelIzq.add(jButtonBorrar, gridBagConstraints);

        getContentPane().add(jPanelIzq, java.awt.BorderLayout.CENTER);

        jPanelAba.setLayout(new javax.swing.BoxLayout(jPanelAba, javax.swing.BoxLayout.LINE_AXIS));

        jLabelMensaje.setText("Introduzca, edita, o borra un libro");
        jPanelAba.add(jLabelMensaje);

        getContentPane().add(jPanelAba, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        controladorLibreria.procesaEventoGuardar();
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        controladorLibreria.procesaEventoBorrar();
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        controladorLibreria.procesaEventoEditar(getLibroSeleccionado());
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jListRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListRegistroMouseClicked
        controladorLibreria.procesaEventoDobleClick(evt.getClickCount());
    }//GEN-LAST:event_jListRegistroMouseClicked

    private void jButtonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBusquedaActionPerformed
        controladorLibreria.procesaEventoBusqueda();
    }//GEN-LAST:event_jButtonBusquedaActionPerformed

    private void jButtonMenuInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuInicialActionPerformed
        controladorLibreria.procesaEventoMenuInicial();
    }//GEN-LAST:event_jButtonMenuInicialActionPerformed

    private void jTextAreaDescrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaDescrKeyReleased
        controladorLibreria.analizaDescr();
    }//GEN-LAST:event_jTextAreaDescrKeyReleased

    private void jTextFieldTituloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTituloKeyReleased
        controladorLibreria.analizaTitulo();
    }//GEN-LAST:event_jTextFieldTituloKeyReleased

    private void jTextFieldISBNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldISBNKeyReleased
        controladorLibreria.analizaISBN();
    }//GEN-LAST:event_jTextFieldISBNKeyReleased

    /**
     * Devuelve el texto introducido en el campo Titulo
     * @return String con el nombre del título
     */
    public String getTitulo(){
        return jTextFieldTitulo.getText();
    }
    
    /**
     * Devuelve el texto introducido en el campo Descripción
     * @return String con la descripción del libro
     */
    public String getDescr(){
        return jTextAreaDescr.getText();
    }
    
    /**
     * Devuelve el texto introducido en el campo ISBN
     * @return String con el ISBN del libro
     */
    public String getISBN(){
        return jTextFieldISBN.getText();
    }
    
    /**
     * Devuelve el estado introducido
     * @return int representando cada estado (0,1,2)
     */
    public int getEstado(){
        return jComboBoxEstado.getSelectedIndex();
    }
    
    /**
     * Devuelve el precio introducido
     * @return int con el precio
     */
    public int getPrecio(){
        return (Integer) jSpinnerPrecio.getValue();
    }
    
    /**
     * Devuelve si se ha leido o no
     * @return boolean, si el libro está leído o no
     */
    public boolean isLeido(){
        return jCheckBoxLeido.isSelected();
    }
    
    /**
     * Devuelve el libro seleccionado de la lista
     * @return isbn con el libro de la lista, null si no hay ninguno
     */
    public String getLibroSeleccionado(){
        String linea = jListRegistro.getSelectedValue();
        if (linea == null){
            return null;
        }else{
            return linea.substring(linea.lastIndexOf(" ")+1);
        }
    }
    
    /**
     * Permite cambiar el mensaje 
     * @param mensaje - String con el mensaje
     * @param isError - Boolean para determinar el color
     */
    public void mostrarMensaje(String mensaje, boolean isError){
        if (isError){
            jLabelMensaje.setForeground(new java.awt.Color(255, 0, 0));
        }else{
            jLabelMensaje.setForeground(new java.awt.Color(20, 165, 100));
        }
        jLabelMensaje.setText(mensaje);
    }
    
    /**
     * Cambia todos los campos a sus valores por defecto y desbloquea todos los 
     * botones
     */
    public void limpiarCampos(){
       jTextFieldTitulo.setText("");
       jTextAreaDescr.setText("");
       jTextFieldISBN.setText("");
       jTextFieldISBN.setEnabled(true);
       jButtonBorrar.setEnabled(true);
       jButtonEditar.setEnabled(true);
       jListRegistro.setEnabled(true);
       jSpinnerPrecio.setValue(0);
       jComboBoxEstado.setSelectedIndex(0);
       jCheckBoxLeido.setSelected(false);
    }
    
    /**
     * Cambia los campos a los valores de un libro, bloquea el campo ISBN, los 
     * botones guardar y editar y el registro de libros.
     * @param libro - libro que se debe cargar
     */
    public void editarRegistro(Libro libro){
        jTextFieldISBN.setEnabled(false);
        jButtonBorrar.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jListRegistro.setEnabled(false);
        jTextFieldTitulo.setText(libro.getTitulo());
        jTextAreaDescr.setText(libro.getDescripcion());
        jTextFieldISBN.setText(libro.getIsbn());
        jSpinnerPrecio.setValue(libro.getPrecio());
        jComboBoxEstado.setSelectedIndex(libro.getEstado());
        jCheckBoxLeido.setSelected(libro.isLeido());
    }
    
    /**
     * Permite actualizar la lista 
     * @param registro - ArrayList con los libros del registro
     */
    public void actualizarRegistro(ArrayList<Libro> registro){
        String lista[] = new String[registro.size()];
        for (int i = 0; i<registro.size(); i++){
            Libro libro = registro.get(i);
            lista[i] = "Título: " + libro.getTitulo() + " ISBN: " + libro.getIsbn();
        }
        jListRegistro.setListData(lista);
    }
    /**
     * Cambia el foco al ISBN
     */
    public void cambiaFocoAISBN() {
        jTextFieldISBN.requestFocus();
    }
    /**
     * Cambia la Descripción
     * @param Desc String con la nueva Descripción
     */
    public void setDesc(String Desc){
        jTextAreaDescr.setText(Desc);
    }
    /**
     * Cambia el color de fondo del titulo en funcion de si esta bien o mal
     * 1 si esta bien (blanco), 0 si esta mal (rojo)
     * @param b boolean si esta bien o mal
     */
    public void tituloFondo(boolean b) {
        if(b){
            jTextFieldTitulo.setBackground(Color.white);
        }else{
            jTextFieldTitulo.setBackground(Color.red);
        }
        
    }
    /**
     * Cambia el color de fondo de la descripción en funcion de si esta bien o mal
     * 1 si esta bien (blanco), 0 si esta mal (rojo)
     * @param b boolean si esta bien o mal
     */
    public void descrFondo(boolean b) {
       if(b){
            jTextAreaDescr.setBackground(Color.white);
        }else{
            jTextAreaDescr.setBackground(Color.red);
        } 
    }
    /**
     * Cambia el color de fondo del ISBN en funcion de si esta bien o mal
     * 1 si esta bien (blanco), 0 si esta mal (rojo)
     * @param b boolean si esta bien o mal
     */
    public void ISBNFondo(boolean b) {
        if(b){
            jTextFieldISBN.setBackground(Color.white);
        }else{
            jTextFieldISBN.setBackground(Color.red);
        } 
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonBusqueda;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonMenuInicial;
    private javax.swing.JCheckBox jCheckBoxLeido;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JLabel jLabelDescr;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelISBN;
    private javax.swing.JLabel jLabelMensaje;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JList<String> jListRegistro;
    private javax.swing.JPanel jPanelAba;
    private javax.swing.JPanel jPanelIzq;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JScrollPane jScrollPaneDescr;
    private javax.swing.JScrollPane jScrollPaneRegistro;
    private javax.swing.JSpinner jSpinnerPrecio;
    private javax.swing.JTextArea jTextAreaDescr;
    private javax.swing.JTextField jTextFieldISBN;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables

}