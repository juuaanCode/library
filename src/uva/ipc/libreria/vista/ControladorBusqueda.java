/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.libreria.vista;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import uva.ipc.libreria.Main;
import uva.ipc.libreria.modelo.Libreria;
import uva.ipc.libreria.modelo.Libro;

/**
 * Esta es la clase controlador Busqueda de la aplicación.
 * Se encarga de gestionar la vista Busqueda junto al modelo.
 * @author alemina
 * @author juagonz0
 */
public class ControladorBusqueda {
    
    private final VistaBusqueda vista;
    private final Libreria libreria ;
    ArrayList<Libro> datosFiltrados;
    
    /**
     * Constructor del controlador, conecta con la vista y el modelo.
     * @param vista asociada al controlador 
     */
    public ControladorBusqueda (VistaBusqueda vista) {
        this.vista = vista;
        libreria = Main.getRegistro();
        vista.actualizarLista(libreria.getRegistro());
        datosFiltrados = libreria.getRegistro();
    }
    
    /**
     * Gestiona el evento ir al Menu Inicial
     * Mostrando la vista Menu Inicial
     */
    public void procesaEventoMenuInicial() {
        Main.getGestorVistas().mostrarVistaMenuInicial();
    }

    /**
     * Gestiona el evento ir a Inserccion
     * Mostrando la vista Inserccion
     */
    public void procesaEventoInsercion() {
        Main.getGestorVistas().mostrarVistaEdicionManual();
    }
    
    /**
     * Gestiona el evento guardar
     * Permite guardar todos los libros que se dispongan actualmente 
     * en la libreria y los guarda en un fichero .txt
     * Se puede selecionar la ruta y carpeta donde guardar el fichero
     * 
     * Muestra varios mensajes por pantalla en funcion de los errores que 
     * se produzcan
     */
    public void procesaEventoGuardar(){
        try{
            JFileChooser selector = new JFileChooser();
            selector.setFileFilter(new FileNameExtensionFilter("Text files","txt"));
            if (selector.showSaveDialog(selector) == JFileChooser.APPROVE_OPTION){
                String archivo= selector.getSelectedFile().getAbsolutePath();
                if (!archivo.endsWith(".txt")) {
                    archivo = archivo.concat(".txt");
                }
                libreria.guardarRegistro(archivo);
                JOptionPane.showMessageDialog(vista, "Libros guardados correctamente.", "Información", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(vista, "Error al escribir el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Gestiona el evento abrir
     * Permite abrir un fichero en formato .txt en el que estan los libros a 
     * introducir en la libreria
     * 
     * Muestra varios mensajes por pantalla en función de los errores que se 
     * produzcan, en el caso de que alguno de los libros no se pueda añadir, 
     * se muestra el numero (orden) en el que ese libro esta en el .txt
     */
    public void procesaEventoAbrir(){
        try{
            JFileChooser selector = new JFileChooser();
            selector.setFileFilter(new FileNameExtensionFilter("Text files","txt"));
            if (selector.showOpenDialog(selector) == JFileChooser.APPROVE_OPTION){
                ArrayList <Integer> libroMal;
                libroMal=libreria.abrirRegistro(selector.getSelectedFile().getAbsolutePath(),vista.getMantenerLista());
                procesaEventoFiltro();
                if(libroMal.isEmpty()){
                    JOptionPane.showMessageDialog(vista, "Libros cargados correctamente.", "Información", JOptionPane.PLAIN_MESSAGE);     
                }else{
                    JOptionPane.showMessageDialog(vista, "No se han podido cargar todos los libros. \n Los siguientes libros dieron problemas \n" + libroMal, "Información", JOptionPane.PLAIN_MESSAGE);  
            
                }
            }
        } catch(IllegalArgumentException e){
            JOptionPane.showMessageDialog(vista, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e){
            JOptionPane.showMessageDialog(vista, "No se ha podido abrir el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }

    /**
     * Gestiona el evento cargar libro
     * Si se ha dado doble click sobre una de las filas, se mueve a la vista Inserccion manual con el libro
     * Si se ha dado solo un clik sobre alguna de las filas, se muestra el libro en la informacion de la derecha
     * @param clicks int con el numero de clicks que se han dado
     */
    public void procesaEventoCargarLibro(int clicks){
        if (clicks == 2){
            procesaEventoEditarLibro();
        }else{
            int fila = vista.getFilaSeleccionada();
            if (fila != -1){
                Libro libro = datosFiltrados.get(fila);
                vista.mostrarLibro(libro);
            }
        }
    }
    
    /**
     * Gestiona el evento de editar un libro
     * PErmite moverse a la vista Inserccion manual con el libro selecionado
     * Para poder editar este libro posteriormente
     */
    public void procesaEventoEditarLibro(){
        int fila = vista.getFilaSeleccionada();
        if (fila != -1){
            Libro libro = datosFiltrados.get(fila);
            Main.getGestorVistas().mostrarVistaEdicionManual(libro.getIsbn());
        }
    }
    
    /**
     * GEstiona el evento del filto
     * Permite mostrar en la tabla, solo los libros que coincidan con el filtro
     * Se puede filtrar tanto por titulo como por isbn
     */
    public void procesaEventoFiltro(){
        int columnaFiltro = vista.getColumnaFiltrada();
        datosFiltrados = new ArrayList<>();
        for (Libro l : libreria.getRegistro()){
            if (columnaFiltro == 0){
                //TITULO
                if (l.getTitulo().lastIndexOf(vista.getTextoFiltro()) != -1){
                    datosFiltrados.add(l);
                }
            } else {
                //ISBN
                if (l.getIsbn().lastIndexOf(vista.getTextoFiltro()) != -1){
                    datosFiltrados.add(l);
                }
            }
        }		
        vista.actualizarLista(datosFiltrados);
    }
}
