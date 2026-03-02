package com.smarttask.app;

import java.util.Scanner;

public class Main {

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
            System.out.println("\n=== SMART TASK ===");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la tarea: ");
                    String nombre = scanner.nextLine();
                    
                    // Menú para prioridad
                    System.out.println("Prioridad:");
                    System.out.println("1. ALTA");
                    System.out.println("2. MEDIA");
                    System.out.println("3. BAJA");
                    System.out.print("Elige: ");
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
                    break;
                    
                case 2:
                    gestor.listarTareas();
                    break;
                    
                case 3:
                    System.out.print("ID de la tarea a completar: ");
                    int idCompletar = scanner.nextInt();
                    scanner.nextLine();
                    gestor.marcarComoCompletada(idCompletar);
                    break;
                    
                case 4:
                    System.out.print("ID de la tarea a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine();
                    gestor.eliminarTarea(idEliminar);
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
