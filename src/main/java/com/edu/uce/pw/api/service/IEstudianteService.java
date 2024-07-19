package com.edu.uce.pw.api.service;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.to.EstudianteTO;

public interface IEstudianteService {
    public Estudiante buscar(String cedula);
    public EstudianteTO buscarPorCedula(String cedula);
    public void actualizar(Estudiante estudiante);
    public void borrar(String cedula);
    public void guardar(Estudiante estudiante);
    public List<Estudiante> buscarPorGenero(String genero);

    public List<EstudianteTO> buscarTodos();
}
