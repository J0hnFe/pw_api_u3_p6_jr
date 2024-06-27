package com.edu.uce.pw.api.service;

import com.edu.uce.pw.api.repository.modelo.Estudiante;

public interface IEstudianteService {
    public Estudiante buscar(Integer id);

    public void actualizar(Estudiante estudiante);

    public void borrar(Integer id);

    public void guardar(Estudiante estudiante);
}
