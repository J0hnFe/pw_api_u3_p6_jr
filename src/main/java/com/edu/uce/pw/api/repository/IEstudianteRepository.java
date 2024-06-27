package com.edu.uce.pw.api.repository;

import com.edu.uce.pw.api.repository.modelo.Estudiante;

public interface IEstudianteRepository {
    // CRUD
    public Estudiante seleccionar(Integer id);
    public void actualizar(Estudiante estu);
    public void eliminar(Integer id);
    public void insertar(Estudiante estu);

}
