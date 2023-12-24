/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.libreria.modelo;

/**
 * Clase que almacena toda la información relativa a un libro.
 * @author juagonz0
 * @author alemina
 */
public class Libro {
    private String titulo;
    private String descripcion;
    private String isbn;
    private int estado;
    private int precio;
    private boolean leido;
    
    
    /**
     * Inicializa un libro 
     * @param titulo - String con el titulo de llibro
     * @param descripcion - String con la descripcion del libro
     * @param isbn - String con el ISBN del libro
     * @param estado - int con el estado del libro, puede ser 0, 1 o 2
     * @param precio - int con el precio del libro
     * @param leido - boolean que indica si se ha leido el libro o no
     * @throws IllegalArgumentException si el título es incorrecto
     * @throws IllegalArgumentException si el ISBN no es correcto
     * @throws IllegalArgumentException el precio es negativo
     * @throws IllegalArgumentException el estado es incorrecto
     */
    public Libro(String titulo, String descripcion, String isbn, int estado, int precio, boolean leido) throws IllegalArgumentException{
        if (!isTitulo(titulo)){
            throw new IllegalArgumentException("El título no es correcto");
        }
        if (!isDescripcion(descripcion)){
            throw new IllegalArgumentException("La descripción no puede contener el carácter ;");
        }
        if (!isISBN(isbn)){
            throw new IllegalArgumentException("El ISBN es incorrecto");
        }
        if (precio < 0){
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        if (estado < 0 || estado > 2){
            throw new IllegalArgumentException("El estado no es correcto");
        }
        
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.isbn = isbn;
        this.estado = estado;
        this.precio = precio;
        this.leido = leido;
    }
    
    /**
     * Constructor pero con estado en String
     * @param titulo string con el titulo
     * @param descripcion string con la descripcion
     * @param isbn string con el isbn
     * @param estado string con el estado
     * @param precio int con el precio
     * @param leido boolean si se ha leido
     * @throws IllegalArgumentException si algun campo no es correcto
     */
    public Libro(String titulo, String descripcion, String isbn, String estado, int precio, boolean leido) throws IllegalArgumentException{
        if (!isTitulo(titulo)){
            throw new IllegalArgumentException("El título no es correcto");
        }
        if (!isDescripcion(descripcion)){
            throw new IllegalArgumentException("La descripción no puede contener el carácter ;");
        }
        
        if (!isISBN(isbn)){
            throw new IllegalArgumentException("El ISBN es incorrecto");
        }
        if (precio < 0){
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        int estadoInt = parseEstado(estado);
        if (estadoInt < 0 || estadoInt > 2){
            throw new IllegalArgumentException("El estado no es correcto");
        }
        
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.isbn = isbn;
        this.estado = estadoInt;
        this.precio = precio;
        this.leido = leido;
    }
    
    /**
     * Devuelve el título del libro
     * @return String con el título
     */
    public String getTitulo(){
        return titulo;
    }
    
    /**
     * Permite cambiar el título del libro
     * @param titulo - String con el título
     * @throws IllegalArgumentException si el título es incorrecto
     */
    public void setTitulo(String titulo) throws IllegalArgumentException{
        if (!isTitulo(titulo)){
            throw new IllegalArgumentException("El título no es correcto");
        }
        this.titulo = titulo;
    }

    /**
     * Devuelve la descripción de un libro
     * @return String con la descripción del libro
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Permite cambiar la descripción del libro
     * @param descripcion - String con la descripción del libro
     */
    public void setDescripcion(String descripcion){
        if (!isDescripcion(descripcion)){
            throw new IllegalArgumentException("La descripción no puede contener el carácter ;");
        }
        this.descripcion = descripcion;
    }

    /**
     * Devuelve es ISBN del libro
     * @return String con el ISBN del libro
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Devuelve el estado del libro en formato int
     * @return int con el estado de libro
     */
    public int getEstado() {
        return estado;
    }
    
    /**
     * Devuelve el estado del libro en formato string
     * @return String con el estado
     */
    public String getEstadoStr(){
        switch (estado) {
            case 0:
                return "Bueno";
            case 1:
                return "Regular";
            default:
                return "Malo";
        }
    }
    
    /**
     * Permite cambiar el estado del libro
     * @param estado del libro, un int que puede ser 0, 1 o 2.
     * @throws IllegalArgumentException el estado es incorrecto
     */
    public void setEstado(int estado) throws IllegalArgumentException{
        if (estado < 0 || estado > 2){
            throw new IllegalArgumentException("El estado no es correcto");
        }
        this.estado = estado;
    }
    
    /**
     * Permite cambiar el estado del libro con el String
     * @param estado del libro, un String con el nuevo estado
     * @throws IllegalArgumentException el estado es incorrecto
     */
    public void setEstado(String estado) throws IllegalArgumentException{
        int estadoInt = parseEstado(estado);
        setEstado(estadoInt);
    }

    /**
     * Comprueba que el estado es corecto y corresponde con un numero
     * @param estado String con el estado
     * @return int con el numero correspondiente al estado
     */
    private int parseEstado(String estado){
        int resultado = -1;
        switch (estado) {
            case "Bueno":
                resultado = 0;
                break;
            case "Regular":
                resultado = 1;
                break;
            case "Malo":
                resultado = 2;
        }
        return resultado;
    }
    
    /**
     * Devuelve el precio del libro
     * @return unt con el precio del libro
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Permite cambiar el precio del libro
     * @param precio - Int con el precio
     * @throws IllegalArgumentException el precio es negativo
     */
    public void setPrecio(int precio) throws IllegalArgumentException{
        if(precio<0){
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }

    /**
     * Devuelve si se ha leido o no el libro
     * @return boolean indicando si se ha leido o no 
     */
    public boolean isLeido() {
        return leido;
    }
    
    /**
     * Devuelve si se ha leido o no el libro
     * @return String indicando si se ha leido o no
     */
    public String isLeidoStr(){
        if (isLeido()){
            return "Sí";
        }else{
            return "No";
        }
    }

    /**
     * Permite cambiar si se ha leido o no el libro
     * @param leido - boolean indicando si se ha leido o no
     */
    public void setLeido(boolean leido) {
        this.leido = leido;
    }
        
    /**
     * Comprueba que el título es correcto
     * @param titulo - String a comprobar
     * @return boolean indicando si es un título correcto o no
     */
    private boolean isTitulo(String titulo){
        return !(titulo.contains(";") || titulo.length()<1 || titulo.length()>20);
    }
    
    /**
     * Comprueba si el ISBN es correcto
     * @param ISBN - String con el texto a comprobar
     * @return boolean indicando si es correcto o no
     */
    private boolean isISBN(String isbn){
        if (isbn.contains(";")){
            return false;
        }
        
        int cont = 0;
        for (int i = 0; isbn.length()>i; i++){
            char caracter = isbn.charAt(i);
            if (Character.isDigit(caracter)){
              cont++;
            } else if (caracter != '-'){
                return false;
            }           
        }
        return !(cont < 1 || cont > 13);
    }
    
    /**
     * Comprueba si la descripcion es correcta 
     * La descripcion es correcta si no lleva ;
     * @param descr string con el texto a analizar
     * @return boolean si es correcta o no
     */
    private boolean isDescripcion(String descr){
        return !descr.contains(";");
    }
}