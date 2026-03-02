package com.smarttask.app;

import java.util.Scanner;

/**
 * Clase principal de la aplicación SmartTask.
 * Contiene el método main que inicia el programa y muestra un menú interactivo
 * al usuario para gestionar tareas (agregar, listar, marcar como completadas, eliminar).
 * 
 * @author EstebanCML
 * @version 1.0
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
        
        // === NUEVO MENÚ INTERACTIVO ===
        GestorTareas gestor = new GestorTareas();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
        	System.out.println("\n");
        	System.out.println("╔════════════════════════════════════════════╗");
    		System.out.println("║            === SMART TASK ===              ║");
            System.out.println("╠════════════════════╦═══════════════════════╣");
    		System.out.println("║  1.   Agregar      ║  2.     Listar        ║");
            System.out.println("║        Tarea       ║         Tareas        ║");
            System.out.println("╠════════════════════╬═══════════════════════╣");
            System.out.println("║  3. Marcar tarea   ║  4.    Eliminar       ║");
            System.out.println("║   como completada  ║         Tarea         ║");
            System.out.println("╠════════════════════╬═══════════════════════╣");
            System.out.println("║  5 .   Salir       ║                       ║");
            System.out.println("║                    ║                       ║");
            System.out.println("╚════════════════════╩═══════════════════════╝");
            
           
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
            
            case 1:
                boolean seguirAgregando = true;
                while (seguirAgregando) {
                    // Pedir nombre
                	System.out.println("╔══════════════════════════════╗");
            		System.out.println("║      Nombre de la tarea:     ║");
            		System.out.println("╚══════════════════════════════╝");
                    String nombre = scanner.nextLine();
                    
                    // Menú para prioridad
                    
                	System.out.println("╔══════════════════════════════╗");
            		System.out.println("║      === Prioridad ===       ║");
                    System.out.println("╠══════════════╦═══════════════╣");
            		System.out.println("║  1.  ALTA    ║  2.  MEDIA    ║");
                    System.out.println("╠══════════════╬═══════════════╣");
                    System.out.println("║  3.  BAJA    ║               ║");
                    System.out.println("╠══════════════╩═══════════════╣");
                    System.out.println("║            Elige:            ║");
                    System.out.println("╚══════════════════════════════╝");
                    
                    int p = scanner.nextInt();
                    scanner.nextLine();
                    
                    Prioridad prioridad;
                    switch (p) {
                        case 1: prioridad = Prioridad.ALTA; break;
                        case 2: prioridad = Prioridad.MEDIA; break;
                        case 3: prioridad = Prioridad.BAJA; break;
                        default:
                            System.out.println("Opción no válida, se usará MEDIA.");
                            prioridad = Prioridad.MEDIA;
                    }
                    
                    gestor.agregarTarea(nombre, prioridad);
                 // Preguntar si desea agregar otra
                    System.out.println("\n");
                    System.out.print("¿Quieres agregar otra tarea? (s/n): ");
                    String respuesta = scanner.nextLine();
                    if (!respuesta.equalsIgnoreCase("s")) {
                        seguirAgregando = false; // Salir del bucle
                    }
                }
                	break; // Volver al menú principal
                    
                case 2:
                    gestor.listarTareas();
                    break;
                    
                case 3: // Marcar tarea como completada
                    boolean seguirMarcando = true;
                    while (seguirMarcando) {
                        System.out.println("╔══════════════════════════════╗");
                    	System.out.println("║ ID de la tarea a completar:  ║");
                    	System.out.println("╚══════════════════════════════╝");
                        int idCompletar = scanner.nextInt();
                        scanner.nextLine(); // limpiar buffer

                        boolean encontrada = gestor.marcarComoCompletada(idCompletar);

                        if (!encontrada) {
                            // Preguntar si quiere intentar con otro ID
                            System.out.print("ID no encontrado. ¿Quieres intentar con otro ID? (s/n): ");
                            String respuesta = scanner.nextLine();
                            if (!respuesta.equalsIgnoreCase("s")) {
                                seguirMarcando = false; // sale del bucle y vuelve al menú
                            }
                            // Si responde "s", el bucle se repite
                        } else {
                            // Si se encontró, salimos del bucle (ya se marcó)
                            seguirMarcando = false;
                        }
                    }
                    break;
                    
                case 4: // Eliminar tarea
                    boolean seguirEliminando = true;
                    while (seguirEliminando) {
                    	System.out.println("╔══════════════════════════════╗");
                    	System.out.println("║  ID de la tarea a eliminar:  ║");
                    	System.out.println("╚══════════════════════════════╝");
                        int idEliminar = scanner.nextInt();
                        scanner.nextLine(); // limpiar buffer

                        boolean encontrada = gestor.eliminarTarea(idEliminar);

                        if (!encontrada) {
                            // Preguntar si quiere intentar con otro ID
                            System.out.print("ID no encontrado. ¿Quieres intentar con otro ID? (s/n): ");
                            String respuesta = scanner.nextLine();
                            if (!respuesta.equalsIgnoreCase("s")) {
                                seguirEliminando = false; // sale del bucle y vuelve al menú
                            }
                            // Si responde "s", el bucle se repite
                        } else {
                            // Si se encontró y eliminó, salimos del bucle
                            seguirEliminando = false;
                        }
                    }
                    break;
                    
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                    
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 5);
        
        scanner.close();
    }
	
	
	
}
