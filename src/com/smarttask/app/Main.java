package com.smarttask.app;

public class Main {

	public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();

        // Agregar algunas tareas
        // Usamos Prioridad.ALTA, Prioridad.MEDIA, etc. 
        gestor.agregarTarea("Estudiar Java", Prioridad.ALTA);
        gestor.agregarTarea("Hacer ejercicio", Prioridad.MEDIA);
        gestor.agregarTarea("Leer un libro", Prioridad.BAJA);

        // Listar todas
        gestor.listarTareas();

        // Marcar una como completada
        gestor.marcarComoCompletada(2);

        // Listar de nuevo para ver cambios
        gestor.listarTareas();

        // Eliminar una tarea
        gestor.eliminarTarea(1);

        // Listar final
        gestor.listarTareas();
    }
	
	
	
}
