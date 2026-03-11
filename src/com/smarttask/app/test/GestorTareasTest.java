package com.smarttask.app.test;

import com.smarttask.app.gestor.GestorTareas;

import com.smarttask.app.objetos.Prioridad;
import com.smarttask.app.objetos.Tarea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas para GestorTareas")
public class GestorTareasTest {

	private GestorTareas gestor;

    @BeforeEach
    void setUp() {
        // Se ejecuta antes de cada prueba: crea un gestor nuevo y limpio
        gestor = new GestorTareas();
    }

    @Test
    @DisplayName("Agregar tarea normal y verificar que se añade correctamente")
    void testAgregarTareaNormal() {
        // 1. ARRANGE: preparar los datos
        String nombre = "Estudiar Java";
        Prioridad prioridad = Prioridad.MEDIA;
        boolean urgente = false;

        // 2. ACT: ejecutar el método a probar
        gestor.agregarTarea(nombre, prioridad, urgente);

        // 3. ASSERT: verificar resultados
        assertEquals(1, gestor.getTareas().size(), "La lista debería tener 1 tarea");
        
        Tarea tarea = gestor.getTareas().get(0);
        assertEquals(nombre, tarea.getNombre());
        assertEquals(prioridad, tarea.getPrioridad());
        assertFalse(tarea.isCompletada(), "La tarea nueva no debe estar completada");
    }
    @Test
    @DisplayName("Agregar tarea urgente (debe tener prioridad ALTA)")
    void testAgregarTareaUrgente() {
        gestor.agregarTarea("Urgente", Prioridad.BAJA, true); // La prioridad se ignora
        assertEquals(1, gestor.getTareas().size());
        assertEquals(Prioridad.ALTA, gestor.getTareas().get(0).getPrioridad());
    }
    @Test
    @DisplayName("Marcar tarea como completada - ID existe")
    void testMarcarComoCompletada_Existe() {
        gestor.agregarTarea("Tarea", Prioridad.MEDIA, false);
        int id = gestor.getTareas().get(0).getId();

        boolean resultado = gestor.marcarComoCompletada(id);

        assertTrue(resultado);
        assertTrue(gestor.getTareas().get(0).isCompletada());
    }
    @Test
    @DisplayName("Marcar tarea como completada - ID no existe")
    void testMarcarComoCompletada_NoExiste() {
        boolean resultado = gestor.marcarComoCompletada(999);
        assertFalse(resultado);
    }
    @Test
    @DisplayName("Eliminar tarea - ID existe")
    void testEliminarTarea_Existe() {
        gestor.agregarTarea("Tarea", Prioridad.BAJA, false);
        int id = gestor.getTareas().get(0).getId();
        int tamañoInicial = gestor.getTareas().size();

        boolean resultado = gestor.eliminarTarea(id);

        assertTrue(resultado);
        assertEquals(tamañoInicial - 1, gestor.getTareas().size());
    }

    @Test
    @DisplayName("Eliminar tarea - ID no existe")
    void testEliminarTarea_NoExiste() {
        int tamañoInicial = gestor.getTareas().size();
        boolean resultado = gestor.eliminarTarea(999);
        assertFalse(resultado);
        assertEquals(tamañoInicial, gestor.getTareas().size());
    }
    
//TEST para el Listado de Tarea, Version Basica
    
    @Test
    @DisplayName("Listar tareas cuando no hay tareas (debe mostrar mensaje)")
    void testListarTareas_CuandoNoHayTareas() {
        // No agregamos ninguna tarea, la lista está vacía
        gestor.listarTareas();
        // Si llega hasta aquí sin lanzar excepción, la prueba pasa
        assertTrue(true); // aserción trivial para que JUnit no se queje
    }

    @Test
    @DisplayName("Listar tareas cuando hay tareas (debe mostrar la lista)")
    void testListarTareas_CuandoHayTareas() {
        // Agregamos algunas tareas
        gestor.agregarTarea("Tarea 1", Prioridad.ALTA, false);
        gestor.agregarTarea("Tarea 2", Prioridad.MEDIA, true); // urgente
        gestor.listarTareas();
        // Si llega hasta aquí sin lanzar excepción, la prueba pasa
        assertTrue(true);
    }
	
	
}
