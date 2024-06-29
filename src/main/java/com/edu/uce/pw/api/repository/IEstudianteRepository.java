package com.edu.uce.pw.api.repository;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    // CRUD
    Estudiante seleccionar(Integer id);
    void actualizar(Estudiante estu);
    void eliminar(Integer id);
    void insertar(Estudiante estu);
    List<Estudiante> seleccionarPorGenero(String genero);
}
