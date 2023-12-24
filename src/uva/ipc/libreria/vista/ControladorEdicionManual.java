/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uva.ipc.libreria.vista;


import uva.ipc.libreria.Main;
import uva.ipc.libreria.modelo.Libreria;
import uva.ipc.libreria.modelo.Libro;

/**
 * Esta es la clase controlador Edicion Manual de la aplicación. Se encarga de gestionar la vista Menu Incial junto al modelo.
 * IMPORTANTE: En cuanto a errores en los campos, el controlador captura las excepciones que lanza el modelo
 * e informa a la vista para mostrar un mensaje de error.
 * @author juagonz0
 * @author alemina
 */
public class ControladorEdicionManual {
    private final VistaEdicionManual vista;
    private final Libreria modelo;
    private Libro libroEditado;
    
    /**
     * Constructor del controlador, conecta con la vista y el modelo.
     * @param v Vista asociada al controlador.
     */
    public ControladorEdicionManual(VistaEdicionManual v){
        vista = v;
        modelo = Main.getRegistro();
        libroEditado = null;
        vista.actualizarRegistro(modelo.getRegistro());
    }
    
    /**
     * Gestiona el evento guardar, tanto en el caso
     * de estar en modo edición como en el caso de un libro nuevo.
     * Actualiza el modelo y la vista.
     */
    public void procesaEventoGuardar(){
        try{
            if (libroEditado != null){
                //Estamos editando
                libroEditado.setTitulo(vista.getTitulo());
                libroEditado.setDescripcion(vista.getDescr());
                libroEditado.setEstado(vista.getEstado());
                libroEditado.setPrecio(vista.getPrecio());
                libroEditado.setLeido(vista.isLeido());

                vista.mostrarMensaje("Libro editado con éxito",false);
                //Actualizamos la vista
                vista.limpiarCampos();
                vista.actualizarRegistro(modelo.getRegistro());
                libroEditado = null; //Esto es correcto?
            }else{
                Libro libro = new Libro(vista.getTitulo(), vista.getDescr(), vista.getISBN(), vista.getEstado(), vista.getPrecio(), vista.isLeido());
                modelo.anadirRegistro(libro);
                vista.mostrarMensaje("Libro añadido con éxito",false);
                //Actualizamos la vista
                vista.limpiarCampos();
                vista.actualizarRegistro(modelo.getRegistro());
            }
        }catch (IllegalArgumentException e){
            //Ha ocurrido algún error en un campo
            vista.mostrarMensaje(e.getMessage(), true);
        }
    }
    
    
    /**
     * Gestiona el evento editar libro
     * ordenando a la vista pasar a modo edición.
     * @param isbn String con el isbn
     */
    public void procesaEventoEditar(String isbn){
        if (isbn != null){
            libroEditado = modelo.getLibro(isbn);
            if (libroEditado != null){
                vista.editarRegistro(libroEditado);
            } else{
                vista.mostrarMensaje("No existe ese libro en el registro", true);
            }
        }else{
            vista.mostrarMensaje("Selecciona un libro para editar",true);
        }
    }
    
    /**
     * Gestiona el evento borrar, actualizando
     * tanto el modelo como la vista.
     */
    public void procesaEventoBorrar(){
        String isbn = vista.getLibroSeleccionado();
        if (isbn != null){
            modelo.eliminarRegistro(isbn);
            vista.actualizarRegistro(modelo.getRegistro());
            vista.mostrarMensaje("Libro borrado con éxito",false);
        }else{
            vista.mostrarMensaje("Selecciona un libro para borrar",true);
        }
    }   
    
    /**
     * Gestiona el evento doble click sobre la lista 
     * @param clicks Numero de clicks
     */
    public void procesaEventoDobleClick(int clicks){
        if (clicks == 2){
            procesaEventoEditar(vista.getLibroSeleccionado());
        }
    }

    /**
     * Gestiona el evento busqueda
     * Mostrando la vista busqueda
     */
    public void procesaEventoBusqueda() {
        Main.getGestorVistas().mostrarVistaBusqueda();
    }

    /**
     * Gestiona el evento  menu inicial
     * Mostrando la vista Menu Inicial
     */
    public void procesaEventoMenuInicial() {
        Main.getGestorVistas().mostrarVistaMenuInicial();
    }
    
    /**
     * Analiza la descripción para avisar si se estan introduciendo datos incorrectos
     * La descripcion no puede contener ;
     * Ademas cambia el foco si se introduce un \t
     */
    public void analizaDescr() {
        String desc= vista.getDescr();
           if (desc.lastIndexOf('\t') != -1){
                    String newDesc = desc.substring(0, desc.length() - 1);
                    vista.cambiaFocoAISBN();
                    vista.setDesc(newDesc);
            }else if(desc.lastIndexOf(';')!=-1){
                vista.descrFondo(false);
            }else{
                vista.descrFondo(true);
            }
    }
    
    /**
     * Analiza el titulo para avisar  si se estan introduciendo datos incorrectos
     * El titulo no puede contener ; y ademas su longitud no debe de ser mayor de 20 ni menor que 1
     */
    public void analizaTitulo() {
        String tit = vista.getTitulo();
        if(tit.contains(";") || tit.length()<1 || tit.length()>20){
            vista.tituloFondo(false);
        }else{
            vista.tituloFondo(true);
        }
    }
    /**
     * Analizar el ISBN para avisar si se estan introduciendo datos incorrectos 
     * El ISBN tiene que ser numerico o con guiones y el total de numeros no puede ser mayor que 13 y menor que 1
     */
    public void analizaISBN() {
        String isbn = vista.getISBN();
        vista.ISBNFondo(true);
        int cont = 0;
        for (int i = 0; isbn.length()>i; i++){
            char caracter = isbn.charAt(i);
            if (Character.isDigit(caracter)){
              cont++;
            } else if (caracter != '-'){
                vista.ISBNFondo(false);
            }        
        }
        if(cont < 1 || cont > 13){
            vista.ISBNFondo(false);
        }
    }

}