package com.smarttask.app;

/**
 * Interfaz que define acciones que pueden ejecutar las tareas.
 * Permite aplicar polimorfismo y extender funcionalidades.
 * 
 * @author EstebanCML
 * @version 1.0
 */

public interface Accionable {

	
	/**
     * Ejecuta una acción específica asociada a la tarea.
     * Cada tipo de tarea puede implementar su propio comportamiento.
     */
    void ejecutar();
}
