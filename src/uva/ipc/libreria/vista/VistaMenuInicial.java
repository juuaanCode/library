/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uva.ipc.libreria.vista;


import java.text.DecimalFormat;


/**
 * Esta es la clase vista Menu Inicial de la aplicación.
 * @author juagonz0
 * @author alemina
 */
public class VistaMenuInicial extends javax.swing.JFrame {
    
    private final ControladorMenuInicial controlador;
    
    /**
     * Constructor de la vista. Se encarga de conectar la vista a un controlador Menu Inicial.
     */
    public VistaMenuInicial() {
        initComponents();
        controlador=new ControladorMenuInicial(this);
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabelBienvenido = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelLibrosTotal = new javax.swing.JLabel();
        jLabelLibrosLeidos = new javax.swing.JLabel();
        jLabelLibrosNoLeidos = new javax.swing.JLabel();
        jLabelPrecioMedio = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonBusqueda = new javax.swing.JButton();
        jButtonInserccionManual = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca | Menú Inicial");
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabelBienvenido.setFont(new java.awt.Font("SimSun-ExtB", 1, 24)); // NOI18N
        jLabelBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBienvenido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uva/ipc/libreria/vista/imagenes/biblioteca.png"))); // NOI18N
        jLabelBienvenido.setText("Bienvenido a la Biblioteca");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.5;
        getContentPane().add(jLabelBienvenido, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridLayout(4, 2));

        jLabelLibrosTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLibrosTotal.setText("Número total de libros en la biblioteca: 420");
        jPanel1.add(jLabelLibrosTotal);

        jLabelLibrosLeidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLibrosLeidos.setText("Número total de libros leídos: 69");
        jPanel1.add(jLabelLibrosLeidos);

        jLabelLibrosNoLeidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLibrosNoLeidos.setText("Número total de libros no leídos: 351");
        jPanel1.add(jLabelLibrosNoLeidos);

        jLabelPrecioMedio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrecioMedio.setText("Precio medio de los libros en la biblioteca: 33 €");
        jPanel1.add(jLabelPrecioMedio);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setPreferredSize(new java.awt.Dimension(300, 60));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButtonBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uva/ipc/libreria/vista/imagenes/lupa.png"))); // NOI18N
        jButtonBusqueda.setText("Busqueda de Libros");
        jButtonBusqueda.setToolTipText("");
        jButtonBusqueda.setFocusPainted(false);
        jButtonBusqueda.setMaximumSize(new java.awt.Dimension(200, 40));
        jButtonBusqueda.setMinimumSize(new java.awt.Dimension(200, 40));
        jButtonBusqueda.setPreferredSize(new java.awt.Dimension(200, 40));
        jButtonBusqueda.setRequestFocusEnabled(false);
        jButtonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBusquedaActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonBusqueda, new java.awt.GridBagConstraints());

        jButtonInserccionManual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uva/ipc/libreria/vista/imagenes/libro.png"))); // NOI18N
        jButtonInserccionManual.setText("Edición manual");
        jButtonInserccionManual.setFocusPainted(false);
        jButtonInserccionManual.setMaximumSize(new java.awt.Dimension(200, 40));
        jButtonInserccionManual.setMinimumSize(new java.awt.Dimension(200, 40));
        jButtonInserccionManual.setPreferredSize(new java.awt.Dimension(200, 40));
        jButtonInserccionManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserccionManualActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonInserccionManual, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        getContentPane().add(jPanel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBusquedaActionPerformed
        controlador.procesaEventoBusqueda();
    }//GEN-LAST:event_jButtonBusquedaActionPerformed

    private void jButtonInserccionManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserccionManualActionPerformed
        controlador.procesaEventoEdicionManual();
    }//GEN-LAST:event_jButtonInserccionManualActionPerformed
    
    /**
     * Permite mostrar el número de libros totales
     * @param numero int con el numero de libros a mostrar
     */
    public void mostrarNumeroLibros(int numero){
        jLabelLibrosTotal.setText("Número total de libros en la biblioteca: "+numero);
    }
    
    /**
     * Permite mostrar el número de libros no leidos totales
     * @param numero int con el numero de libros a mostrar
     */
    public void mostrarNumeroNoLeidos(int numero){
        jLabelLibrosNoLeidos.setText("Número total de libros no leídos: "+numero);
    }
    
    /**
     * Permite mostrar el número de libros leidos totales
     * @param numero int con el numero de libros a mostrar
     */
    public void mostrarNumeroLeidos(int numero){
        jLabelLibrosLeidos.setText("Número total de libros leídos: "+numero);
    }
    
    /**
     * Permite mostrar el precio (Dos decimales) de libros totales
     * @param numero double con el precio
     */
    public void mostrarPrecioMedio(double numero){
        DecimalFormat df = new DecimalFormat("#.00");
        jLabelPrecioMedio.setText("Precio medio de los libros en la biblioteca: "+df.format(numero)+"€");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBusqueda;
    private javax.swing.JButton jButtonInserccionManual;
    private javax.swing.JLabel jLabelBienvenido;
    private javax.swing.JLabel jLabelLibrosLeidos;
    private javax.swing.JLabel jLabelLibrosNoLeidos;
    private javax.swing.JLabel jLabelLibrosTotal;
    private javax.swing.JLabel jLabelPrecioMedio;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
