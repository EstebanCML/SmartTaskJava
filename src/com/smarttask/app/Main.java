package com.smarttask.app;

import com.smarttask.app.gestor.GestorTareas;
import com.smarttask.app.ui.MenuTareas;
import java.util.Scanner;
/**
 * Clase principal de la aplicación SmartTask.
 * Contiene el método main que inicia el programa y muestra un menú interactivo
 * al usuario para gestionar tareas (agregar, listar, marcar como completadas, eliminar).
 * 
 * @author EstebanCML
 * @version 1.1
 */

public class Main {
	/**
     * Punto de entrada de la aplicación.
     * Inicializa el gestor de tareas y el scanner, y ejecuta un bucle con el menú
     * hasta que el usuario elige salir.
     * 
     * @param args Argumentos de línea de comandos (no se utilizan en esta versión).
     */

	public static void main(String[] args) {
        
        // === NUEVO MENÚ INTERACTIVO ===
        
        GestorTareas gestor = new GestorTareas();
        MenuTareas menu = new MenuTareas(gestor);
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
        	menu.mostrarMenu(); // <-- Método que imprime el menú
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    menu.agregarTareaInteractivo();
                    break;
                case 2:
                    menu.listarTareasInteractivo();
                    break;
                case 3:
                    menu.marcarCompletadaInteractivo();
                    break;
                case 4:
                    menu.eliminarTareaInteractivo();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                case 6:
                    menu.ejecutarTodasInteractivo();
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 5);
        
        scanner.close();
    }
	
	// === CÓDIGO DE PRUEBA (Lo comentamos para no perderlo) ===
    /*
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
*/
	
}
