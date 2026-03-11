package com.smarttask.app.interfaces;

import com.smarttask.app.objetos.Prioridad;

public interface ServicioTareas {
    void agregarTarea(String nombre, Prioridad prioridad, boolean urgente);
    void listarTareas();
    boolean marcarComoCompletada(int id);
    boolean eliminarTarea(int id);
    void ejecutarTodas(); // si existe
}
