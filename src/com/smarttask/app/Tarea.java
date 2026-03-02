package com.smarttask.app;


/**
 * Representa una tarea dentro del sistema SmartTask.
 * Cada tarea tiene un identificador único, un nombre, una prioridad
 * y un estado que indica si está completada o no.
 * 
 * @author EstebanCML
 * @version 1.0
 */


public class Tarea {
	 
	// Atributos (encapsulamiento)
	/** Identificador único de la tarea. */
    private int id;
    /** Nombre descriptivo de la tarea. */
    private String nombre;
    /** Prioridad de la tarea (ALTA, MEDIA, BAJA). */
    private Prioridad prioridad;  // <-- CAMBIO A enum
    /** Estado de la tarea: true si está completada, false en caso contrario. */
    private boolean completada;

    /**
     * Constructor de la clase Tarea.
     * Crea una nueva tarea con los datos proporcionados.
     * Por defecto, la tarea se crea como no completada.
     * 
     * @param id        Identificador único de la tarea.
     * @param nombre    Nombre descriptivo de la tarea.
     * @param prioridad Prioridad de la tarea (ALTA, MEDIA, BAJA).
     */
    
    // Constructor
    public Tarea(int id, String nombre, Prioridad prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.completada = false; // Por defecto, no completada
    }

    
    /**
     * Obtiene el identificador de la tarea.
     * @return id de la tarea.
     */
    // Getters y Setters
    public int getId() {
        return id;
    }
    
    /**
     * Obtiene el nombre de la tarea.
     * @return nombre de la tarea.
     */
    public String getNombre() {
        return nombre;
    }

    
    /**
     * Establece un nuevo nombre para la tarea.
     * @param nombre el nuevo nombre de la tarea.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la prioridad de la tarea.
     * @return la prioridad de la tarea (ALTA, MEDIA, BAJA).
     */
    public Prioridad getPrioridad() {
        return prioridad;
    }

    /**
     * Establece una nueva prioridad para la tarea.
     * @param prioridad la nueva prioridad (ALTA, MEDIA, BAJA).
     */

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * Indica si la tarea está completada.
     * @return true si la tarea está completada, false en caso contrario.
     */
    public boolean isCompletada() {
        return completada;
    }

    /**
     * Establece el estado de completado de la tarea.
     * @param completada true para marcar como completada, false para pendiente.
     */
    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    /**
     * Marca la tarea como completada.
     * Este método cambia el estado a true.
     */
    // Método para marcar como completada (alternativa al setter)
    public void marcarCompletada() {
        this.completada = true;
    }

    /**
     * Devuelve una representación en cadena de la tarea.
     * El formato es: "ID: [id] |nombre de la tarea [nombre], Prioridad es  [[prioridad]] [Estado: COMPLETADA] || [Estado: PENDIENTE]
     * 
     * @return una cadena con los datos de la tarea.
     */
    // Para mostrar la tarea fácilmente
    @Override
    public String toString() {
        return "ID: [" + id + "] |nombre de la tarea [" + nombre + "], Prioridad es [" + prioridad + "] " + 
               (completada ? "[Estado: COMPLETADA]" : "[Estado: PENDIENTE]");
    }

}
