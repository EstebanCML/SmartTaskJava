package com.smarttask.app;

/**
 * Representa una tarea de tipo normal.
 * Hereda de Tarea y puede tener comportamientos específicos.
 * 
 * @author EstebanCML
 * @version 1.0
 */
public class TareaNormal extends Tarea {

    /**
     * Constructor de TareaNormal.
     * 
     * @param id        Identificador único.
     * @param nombre    Nombre de la tarea.
     * @param prioridad Prioridad (ALTA, MEDIA, BAJA).
     */
    public TareaNormal(int id, String nombre, Prioridad prioridad) {
        super(id, nombre, prioridad);
    }

    /**
     * Acción específica para una tarea normal: se marca como completada
     * y se muestra un mensaje estándar.
     */
    @Override
    public void ejecutar() {
        super.ejecutar(); // Llama al método de Tarea (marcarCompletada)
        System.out.println("(Tarea normal procesada)");
    }
}