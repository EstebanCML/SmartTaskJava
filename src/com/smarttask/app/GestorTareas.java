package com.smarttask.app;

import java.util.ArrayList;
import java.util.List;


public class GestorTareas {
	
	 private List<Tarea> tareas;
	    private int nextId; // Para asignar IDs automáticos
	    
    public GestorTareas() {
        tareas = new ArrayList<>();
        nextId = 1;
    }
	    
	    
	    

    public void agregarTarea(String nombre, Prioridad prioridad) {  // <-- CAMBIO
        Tarea nueva = new Tarea(nextId++, nombre, prioridad);
        tareas.add(nueva);
        System.out.println("Tarea agregada: " + nueva);
    }
    
    public void listarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas.");
            return;
        }
        System.out.println("=== LISTA DE TAREAS ===");
        for (Tarea t : tareas) {
            System.out.println(t);
        }
    }
    
    public void marcarComoCompletada(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                t.marcarCompletada();
                System.out.println("Tarea " + id + " marcada como completada.");
                return;
            }
        }
        System.out.println("No se encontró tarea con ID: " + id);
    }
    
    public void eliminarTarea(int id) {
        Tarea aEliminar = null;
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                aEliminar = t;
                break;
            }
        }
        if (aEliminar != null) {
            tareas.remove(aEliminar);
            System.out.println("Tarea " + id + " eliminada.");
        } else {
            System.out.println("No se encontró tarea con ID: " + id);
        }
    }

}
