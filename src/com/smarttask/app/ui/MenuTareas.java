package com.smarttask.app.ui;

import com.smarttask.app.gestor.GestorTareas; // o ServicioTareas si usas la interfaz
import com.smarttask.app.objetos.Prioridad;
import java.util.Scanner;

/**
 * Clase encargada de la interacción con el usuario a través de la consola.
 * Proporciona métodos para cada opción del menú principal, gestionando la entrada
 * de datos y la comunicación con la capa de negocio (GestorTareas).
 * 
 * @author EstebanCML
 * @version 1.0
 */

public class MenuTareas {
	
	private GestorTareas gestor;      // o ServicioTareas
    private Scanner scanner;
    
    /**
     * Constructor de MenuTareas.
     * Inicializa el gestor de tareas y el scanner para la entrada del usuario.
     * 
     * @param gestor Instancia de GestorTareas que maneja la lógica de negocio.
     */
    public MenuTareas(GestorTareas gestor) {
        this.gestor = gestor;
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Gestiona la interacción para agregar una o varias tareas.
     * Solicita el nombre, determina si es urgente, y en caso contrario pide la prioridad.
     * Permite agregar múltiples tareas sin volver al menú principal.
     */
    public void agregarTareaInteractivo() {
        boolean seguirAgregando = true;
        while (seguirAgregando) {
            // Pedir nombre
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║      Nombre de la tarea:     ║");
            System.out.println("╚══════════════════════════════╝");
            String nombre = scanner.nextLine();

            // Preguntar primero si es urgente
            System.out.println("╔═════════════════════════════════╗");
            System.out.println("║  ¿Es una tarea urgente? (s/n):  ║");
            System.out.println("╚═════════════════════════════════╝");
            String esUrgente = scanner.nextLine();
            boolean urgente = esUrgente.equalsIgnoreCase("s");

            Prioridad prioridad;

            if (urgente) {
            	// Si es urgente, la prioridad es ALTA directamente
                prioridad = Prioridad.ALTA;
                System.out.println("╔══════════════════════════════════════════════╗");
                System.out.println("║  Tarea urgente: se asignará prioridad ALTA.  ║");
                System.out.println("╚══════════════════════════════════════════════╝");
            } else {
            	// Si no es urgente, mostrar menú de prioridad
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

                switch (p) {
                    case 1:
                        prioridad = Prioridad.ALTA;
                        break;
                    case 2:
                        prioridad = Prioridad.MEDIA;
                        break;
                    case 3:
                        prioridad = Prioridad.BAJA;
                        break;
                    default:
                        System.out.println("Opción no válida, se usará MEDIA.");
                        prioridad = Prioridad.MEDIA;
                }
            }

            // Llamar al método de GestorTareas
            gestor.agregarTarea(nombre, prioridad, urgente);

            // Preguntar si desea agregar otra
            System.out.println("\n");
            System.out.println("╔═══════════════════════════════════════╗");
            System.out.println("║  ¿Quieres agregar otra tarea? (s/n):  ║");
            System.out.println("╚═══════════════════════════════════════╝");
            System.out.print("¿Quieres agregar otra tarea? (s/n): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                seguirAgregando = false;
            }
        }
    }
    
    /**
     * Gestiona la interacción para listar todas las tareas.
     * Muestra la lista y hace una pausa para que el usuario pueda verla antes de continuar.
     */
 // Métodos para las otras opciones (los moveremos después)
    public void listarTareasInteractivo() {
        gestor.listarTareas();
        pausa();
    }

    /**
     * Gestiona la interacción para marcar una tarea como completada.
     * Solicita el ID, valida su existencia y permite reintentar en caso de error.
     */
    public void marcarCompletadaInteractivo() {
        boolean seguirMarcando = true;
        while (seguirMarcando) {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║ ID de la tarea a completar:  ║");
            System.out.println("╚══════════════════════════════╝");
            int id = scanner.nextInt();
            scanner.nextLine();

            boolean encontrada = gestor.marcarComoCompletada(id);
            if (!encontrada) {
                System.out.print("ID no encontrado. ¿Quieres intentar con otro ID? (s/n): ");
                String respuesta = scanner.nextLine();
                if (!respuesta.equalsIgnoreCase("s")) {
                    seguirMarcando = false;
                }
            } else {
                seguirMarcando = false;
            }
        }
        pausa();
    }

    /**
     * Gestiona la interacción para eliminar una tarea.
     * Solicita el ID, valida su existencia y permite reintentar en caso de error.
     */
    public void eliminarTareaInteractivo() {
        boolean seguirEliminando = true;
        while (seguirEliminando) {
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║  ID de la tarea a eliminar:  ║");
            System.out.println("╚══════════════════════════════╝");
            int id = scanner.nextInt();
            scanner.nextLine();

            boolean encontrada = gestor.eliminarTarea(id);
            if (!encontrada) {
                System.out.print("ID no encontrado. ¿Quieres intentar con otro ID? (s/n): ");
                String respuesta = scanner.nextLine();
                if (!respuesta.equalsIgnoreCase("s")) {
                    seguirEliminando = false;
                }
            } else {
                seguirEliminando = false;
            }
        }
        pausa();
    }

    /**
     * Ejecuta la acción de todas las tareas (polimórficamente) y luego pausa.
     */
    public void ejecutarTodasInteractivo() {
        gestor.ejecutarTodas();
        pausa();
    }

    /**
     * Pausa la ejecución hasta que el usuario presione Enter.
     * Utiliza el scanner de la instancia para esperar la entrada.
     */
    private void pausa() {
        System.out.println("\nPresiona Enter para continuar...");
        scanner.nextLine();
    }
    
    /**
     * Muestra el menú principal con las opciones disponibles.
     * Es un método estático porque no necesita acceder a atributos de instancia.
     */
    public void mostrarMenu() {
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
        System.out.println("║  5.    Salir       ║  6. Ejecutar todas    ║");
        System.out.println("║                    ║                       ║");
        System.out.println("╚════════════════════╩═══════════════════════╝");
    }

    
    
    
}
