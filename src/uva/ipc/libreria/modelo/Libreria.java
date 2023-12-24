/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.libreria.modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Esta es la clase modelo de la aplicación. Se encarga de gestionar los datos.
 * @author juagonz0
 * @author alemina
 */
public class Libreria {
    private ArrayList<Libro> registroLibros;
    
    /**
     * Constuctor del modelo. Inicializa el registro de libros.
     */
    public Libreria(){
        registroLibros = new ArrayList<>();
    }
    
    /**
     * Devuelve el registro entero de libros en forma de ArrayList.
     * @return ArrayList con todos los libros de la librería.
     */
    public ArrayList<Libro> getRegistro(){
        return registroLibros;
    }
    
    /**
     * Permite añadir un libro a la lista de libros. Debe ser único en cuanto a ISBN.
     * @param libroNuevo - Libro que se añade
     * @throws IllegalArgumentException - Si el ISBN ya existe en otro libro
     */
    public void anadirRegistro(Libro libroNuevo) throws IllegalArgumentException{
        for (Libro libro : registroLibros){
            if (libro.getIsbn().equals(libroNuevo.getIsbn())){
                throw new IllegalArgumentException("Libro ya existe");
            }
        }
        registroLibros.add(libroNuevo);
    }
    
    /**
     * Permite elimnar un libro del registro. 
     * @param isbn - String con el ISBN del libro en el registro.
     * @throws IllegalArgumentException - Si el ISBN no existe.
     */
    public void eliminarRegistro(String isbn)throws IllegalArgumentException{
        Libro l = getLibro(isbn);
        if (l == null) throw new IllegalArgumentException("Libro no existe");
        registroLibros.remove(l);
    }
    
    /**
     * Devuelve el libro indicado del registro.
     * @param isbn - String con el ISBN del libro en el registro.
     * @return libro del registro, null si no existe.
     */
    public Libro getLibro(String isbn){
        for (Libro l : registroLibros){
            if (l.getIsbn().equals(isbn)){
                return l;
            }
        }
        return null;
    }
    
    /**
     * Almacena todos los libros de la biblioteca en un archivo txt, con el formato: 
     * titulo;descripcion;ISBN;estado;Precio;Leido; \n 
     * @param path ruta del archivo donde se guardaran los libros
     * @throws FileNotFoundException si la ruta genera problema
     */
    public void guardarRegistro(String path) throws FileNotFoundException{
        try (PrintWriter out = new PrintWriter(path)) {
            for (Libro l : registroLibros){
                out.println(l.getTitulo() + ";" + l.getDescripcion() + ";" + l.getIsbn() + ";" + l.getEstadoStr() + ";" + l.getPrecio() + ";" + l.isLeido() + ";");
            }
        }
    }
    
    /**
     * 
     * @param path es la direccion del fichero
     * @param mantener Si hay que manteener los libros anteriores o no 
     * @return  ArrayList con los libros (el orden en el fichero del que provienen) que no se han podido introducir en la biblioteca
     * @throws IOException si no existe el fichero
     * @throws IllegalArgumentException si el formato de campos es incorrecto
     */
    public ArrayList abrirRegistro(String path, boolean mantener) throws IOException, IllegalArgumentException{
        if (!mantener){ 
            registroLibros = new ArrayList<>();// Reset
        }
        String linea;
        ArrayList <Integer> libroMal = new ArrayList<>();
        int cont=0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            
            while((linea = br.readLine()) != null){
                cont++;
                try{
                
                    String[] datos = linea.split(";");
                    //Comprobar numero de campos
                    if (datos.length != 6) throw new IllegalArgumentException("Formato de campos incorrecto.");
                
                    //Comprobar precio correcto
                    int precio = Integer.parseInt(datos[4]);
                
                    //Comprobar leido correcto
                    boolean leido = Boolean.parseBoolean(datos[5]);
                
                    Libro libro = new Libro(datos[0], datos[1], datos[2], datos[3], precio, leido);
                    anadirRegistro(libro);
                    
                }catch(IllegalArgumentException IAE){
                    libroMal.add(cont);
                }
                
            }
        }
        return libroMal;
    }
    
    /**
     * Devuelve el numero total de libros que hay en la biblioteca
     * @return int con el numero total de libros
     */
    public int getNumeroLibros(){
        return registroLibros.size();
    }
    
    /**
     * Devuelve el número de de los libros leidos que conforman la biblioteca 
     * @return int con el numero de libros leidos
     */
    public int getNumeroLibrosLeidos(){
        int cont = 0;
        for (Libro l: registroLibros){
            if(l.isLeido()){
                cont++;
            }
        }
        return cont;
    }
    
    /**
     * Devuelve el numero de los libros no leidos que conforman la biblioteca 
     * @return int con el numero de libros no leidos
     */
    public int getNumeroLibrosNoLeidos(){
        return (getNumeroLibros() - getNumeroLibrosLeidos());
    }
    
    /**
     * Devuelve el precio medio de los libros que conforman la libreria
     * @return double con el precio medio
     */
    public double getPrecioMedioLibros(){
        if (getNumeroLibros() == 0){
            return 0;
        }
        double precio = 0;
        for (Libro l: registroLibros){
            precio += l.getPrecio();
        }  
        return precio/getNumeroLibros();
    }
}