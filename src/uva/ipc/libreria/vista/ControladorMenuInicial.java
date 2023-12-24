/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.libreria.vista;

import uva.ipc.libreria.Main;
import uva.ipc.libreria.modelo.Libreria;

/**
  *Esta es la clase controlador Menu Inicial de la aplicación.
 * Se encarga de gestionar la vista Menu Inicial junto al modelo.
 * @author alemina
 * @author juagonz0
 */
public class ControladorMenuInicial {
    
    private final VistaMenuInicial vista;
    private final Libreria libreria ;
    
    /**
     * Constructor del controlador, conecta con la vista y el modelo.
     * Muestra los datos del modelo, actualizandose cada vez que se muestra la vista
     * @param vista asociada al controlador  
     */
    public ControladorMenuInicial (VistaMenuInicial vista) {
        this.vista = vista;
        libreria = Main.getRegistro();
        vista.mostrarNumeroLibros(libreria.getNumeroLibros());
        vista.mostrarNumeroLeidos(libreria.getNumeroLibrosLeidos());
        vista.mostrarNumeroNoLeidos(libreria.getNumeroLibrosNoLeidos());
        vista.mostrarPrecioMedio(libreria.getPrecioMedioLibros());
    }
    
    /**
     * Gestiona el evento busqueda
     * Mostrando la vista busqueda
     */
    public void procesaEventoBusqueda() {
        Main.getGestorVistas().mostrarVistaBusqueda();
    }

    /**
     * Gestiona el evento Edicion Manual
     * Mostrando la vista Edicion Manual
     */
    public void procesaEventoEdicionManual() {
        Main.getGestorVistas().mostrarVistaEdicionManual();
    }
    
}
