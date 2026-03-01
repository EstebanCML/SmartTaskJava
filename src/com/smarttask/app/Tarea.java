package com.smarttask.app;

public class Tarea {
	 
	// Atributos (encapsulamiento)
    private int id;
    private String nombre;
    private Prioridad prioridad;  // <-- CAMBIO A enum
    private boolean completada;

    // Constructor
    public Tarea(int id, String nombre, Prioridad prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.completada = false; // Por defecto, no completada
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    // Método para marcar como completada (alternativa al setter)
    public void marcarCompletada() {
        this.completada = true;
    }

    // Para mostrar la tarea fácilmente
    @Override
    public String toString() {
        return "ID: " + id + " | " + nombre + " [" + prioridad + "] " + 
               (completada ? "[COMPLETADA]" : "[PENDIENTE]");
    }

}
