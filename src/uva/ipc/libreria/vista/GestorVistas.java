/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.libreria.vista;

import javax.swing.JFrame;

/**
 * Esta es la clase GestorVistas que se encarga de gestionar las diferentes vistas
 * @author alemina
 * @author juagonz0
 */
public class GestorVistas {
    private JFrame vistaActual;
    
    /**
     * Muestra la vista Menu Inicial, dejando no visble la vista actual
     */
    public void mostrarVistaMenuInicial(){
        if(vistaActual != null){
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaMenuInicial();
        vistaActual.setVisible(true);
    }
    
    
    /**
     * Muestra la vista Edicion Manual, dejando no visible la vista actual
     */
    public void mostrarVistaEdicionManual(){
        if(vistaActual != null){
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaEdicionManual();
        vistaActual.setVisible(true);
    }
    
    /**
     * Muestra la vista Edicion Manual, dejando no visible la vista actual
     * Pasando el isbn
     * @param isbn string con el isbn
     */
    public void mostrarVistaEdicionManual(String isbn){
        if(vistaActual != null){
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaEdicionManual(isbn);
        vistaActual.setVisible(true);
    }
    
    /**
     * Muestra la vista Busqueda, dejando no visible la vista actual
     */
    public void mostrarVistaBusqueda(){
        if(vistaActual != null){
            vistaActual.setVisible(false);
            vistaActual.dispose();
        }
        vistaActual = new VistaBusqueda();
        vistaActual.setVisible(true);
    }
}
