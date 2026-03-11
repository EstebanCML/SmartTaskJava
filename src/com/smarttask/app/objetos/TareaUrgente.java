package com.smarttask.app.objetos;

/**
 * Representa una tarea de tipo urgente.
 * Hereda de Tarea y fuerza prioridad ALTA, además de un comportamiento especial.
 * 
 * @author EstebanCML
 * @version 1.0
 */
public class TareaUrgente extends Tarea {

    /**
     * Constructor de TareaUrgente.
     * Asigna automáticamente prioridad ALTA.
     * 
     * @param id        Identificador único.
     * @param nombre    Nombre de la tarea.
     */
    public TareaUrgente(int id, String nombre) {
        super(id, nombre, Prioridad.ALTA); // Fuerza prioridad ALTA
    }

    /**
     * Acción específica para una tarea urgente: además de marcarse como completada,
     * muestra un mensaje especial y podría notificar (simulado).
     */
    @Override
    public void ejecutar() {
        super.ejecutar(); // Marca como completada
        System.out.println("¡TAREA URGENTE!.");
    }
}