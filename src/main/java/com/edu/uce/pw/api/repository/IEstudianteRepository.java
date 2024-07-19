package com.edu.uce.pw.api.repository;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    // CRUD
    // Estudiante seleccionar(Integer id);
    Estudiante seleccionar(String cedula);
    void actualizar(Estudiante estu);
    // void eliminar(Integer id);
    void eliminar(String cedula);
    void insertar(Estudiante estu);
    List<Estudiante> seleccionarPorGenero(String genero);

    List<Estudiante> seleccionarTodos();
}
