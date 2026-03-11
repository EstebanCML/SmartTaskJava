package com.smarttask.app.interfaces;

/**
 * Interfaz que define acciones que pueden ejecutar las tareas.
 * Permite aplicar polimorfismo y extender funcionalidades.
 * 
 * @author EstebanCML
 * @version 1.0
 */

public interface TareaEjecutable {

	
	/**
     * Ejecuta una acción específica asociada a la tarea.
     * Cada tipo de tarea puede implementar su propio comportamiento.
     * En este caso, es para TareaNormal, TareaUrgente Y TareaCompletada
     */
    void ejecutar();
}
