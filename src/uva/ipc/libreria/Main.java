/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.libreria;

import uva.ipc.libreria.modelo.Libreria;
import uva.ipc.libreria.vista.GestorVistas;
/**
 * Esta es la clase main
 * @author juagonz0
 * @author alemina
 */
public class Main {
    
    private static GestorVistas gestor;
    private static Libreria libreria;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        gestor = new GestorVistas();
        libreria = new Libreria();
        gestor.mostrarVistaMenuInicial();
    }
    
    /**
     * Gestor de vistas
     * @return gestor
     */
    public static GestorVistas getGestorVistas() {
        return gestor;
    }

    /**
     * Modelo Libreria
     * @return libreria 
     */
    public static Libreria getRegistro() {
        return libreria;
    }
}
