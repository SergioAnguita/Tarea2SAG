package com.example.tarea2sag;

import java.util.List;

/**
 * La clase representa un personaje en la aplicación.
 *
 * Cada objeto de esta clase contiene información sobre un personaje,
 * incluyendo su imagen, nombre, descripción y habilidad.
 *
 * @author Sergio Anguita
 */
public class Person {

    /**
     * Imagen del personaje
     */
    private final int imagen;
    /**
     * Nombre del personaje
     */
    private final String nombre;
    /**
     * Descripción del personaje
     */
    private final String descripcion;
    /**
     * Habilidad del personaje
     */
    private final String habilidad;

    /**
     * Constructor de la clase.
     *
     * @param imagen       Imagen asociada al personaje.
     * @param nombre       Nombre del personaje.
     * @param descripcion  Descripción del personaje.
     * @param habilidad    Habilidad del personaje.
     */
    public Person(int imagen, String nombre, String descripcion, String habilidad) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.habilidad = habilidad;
    }

    /**
     * Lista de objetos que representa un conjunto de personajes.
     *
     * Este atributo es utilizado para almacenar y gestionar la información
     * de varios personajes dentro de la aplicación.
     */
    private List<Person> persons;

    /**
     * Devuelve el recurso de imagen del personaje.
     *
     * @return Identificador de imagen.
     */
    public int getImagen() {
        return imagen;
    }

    /**
     * Devuelve la descripción  del personaje.
     *
     * @return Descripción del personaje.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Devuelve el nombre del personaje.
     *
     * @return Nombre del personaje.
     */
    public String getNombre() {
        return nombre;
    }


    /**
     * Devuelve la habilidad del personaje.
     *
     * @return Habilidad del personaje.
     */
    public String getHabilidad() {
        return habilidad;
    }
}
