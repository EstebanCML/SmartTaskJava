package com.smarttask.app;

/**
 * Representa los niveles de prioridad que puede tener una tarea.
 * <p>
 * Estas prioridades se utilizan al crear una tarea y permiten ordenar
 * o filtrar las tareas según su importancia.
 * </p>
 * 
 * @author EstebanCML
 * @version 1.0
 */

public enum Prioridad {
    
    /** Prioridad alta: tareas urgentes o muy importantes. */
    ALTA,
    
    /** Prioridad media: tareas de importancia normal. */
    MEDIA,
    
    /** Prioridad baja: tareas que pueden esperar o son opcionales. */
    BAJA
}