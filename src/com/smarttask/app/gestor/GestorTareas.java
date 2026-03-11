package com.smarttask.app.gestor;

import java.util.ArrayList;
import java.util.List;

import com.smarttask.app.objetos.Tarea;
import com.smarttask.app.objetos.TareaNormal;
import com.smarttask.app.objetos.TareaUrgente;
import com.smarttask.app.objetos.Prioridad;
import  com.smarttask.app.interfaces.ServicioTareas;

/**
 * Gestiona una lista de tareas y proporciona operaciones para agregar,
 * listar, marcar como completadas y eliminar tareas.
 * 
 * @author EstebanCML
 * @version 1.0
 */

public class GestorTareas implements ServicioTareas {
	
	 private List<Tarea> tareas;
	    private int nextId; // Para asignar IDs automáticos
	    
	    /** Constructor que inicializa la lista de tareas y el contador de IDs. */
	// contructor
    public GestorTareas() {
        tareas = new ArrayList<>();
        nextId = 1;
    }
	    
    
   
    /**
     * Agrega una nueva tarea a la lista, permitiendo especificar si es urgente.
     * 
     * @param nombre    El nombre de la tarea.
     * @param prioridad La prioridad (solo se usa si no es urgente).
     * @param urgente   true para crear una tarea urgente, false para normal.
     */
    public void agregarTarea(String nombre, Prioridad prioridad, boolean urgente) {
        Tarea nueva;
        if (urgente) {
            nueva = new TareaUrgente(nextId++, nombre);
        } else {
            nueva = new TareaNormal(nextId++, nombre, prioridad);
        }
        tareas.add(nueva);
        System.out.println("Tarea agregada: " + nueva);
    }
    
    /**
     * Muestra por consola todas las tareas registradas.
     * Si no hay tareas, muestra un mensaje indicándolo.
     */
    // metodo listar tareas, que primero consulta si tengo tareas en lista y lueo lista las tareas registrada si exiten    
    public void listarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas.");
            return;
        }
        System.out.println("╔═══════════════════════════╗");
        System.out.println("║  === LISTA DE TAREAS ===  ║");
        System.out.println("╚═══════════════════════════╝");
        for (Tarea t : tareas) {
            System.out.println(t);
        }
    }
    
    /**
     * Marca una tarea como completada, buscándola por su ID.
     * 
     * @param id El identificador único de la tarea a completar.
     * @return true si la tarea fue encontrada y marcada, false en caso contrario.
     */
    
    // metodo para marcar completada la tarea, busca el ID y si encuentra la tarea, llama al metodo y cambia a true     
    public boolean marcarComoCompletada(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                t.marcarCompletada();
                System.out.println("Tarea " + id + " marcada como completada.");
                return true; // indica que se encontró y se marcó
            }
        }
        System.out.println("No se encontró tarea con ID: " + id);
        return false; // no se encontró
    }
    
    /**
     * Elimina una tarea de la lista, buscándola por su ID.
     * 
     * @param id El identificador único de la tarea a eliminar.
     * @return true si la tarea fue encontrada y eliminada, false en caso contrario.
     */
    
    // metodo para eliminar tarea, funcina similar al metodo marcarcomo completoada, la diferecia es que este elimina al final    
    public boolean eliminarTarea(int id) {
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
            return true; // eliminada con éxito
        } else {
            System.out.println("No se encontró tarea con ID: " + id);
            return false; // no encontrada
        }
    }

    
    /**
     * Ejecuta la acción de todas las tareas (polimórficamente).
     * Cada tarea se comportará según su tipo real.
     */
    public void ejecutarTodas() {
        System.out.println("\n=== Ejecutando acciones de todas las tareas ===");
        for (Tarea t : tareas) {
            t.ejecutar();
        }
    }
    
    /**
     * Obtiene la lista interna de tareas.
     * Método creado exclusivamente para pruebas unitarias.
     * @return lista de tareas.
     */
    public List<Tarea> getTareas() {
        return tareas;
    }
}
