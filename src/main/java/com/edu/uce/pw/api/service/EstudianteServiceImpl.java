package com.edu.uce.pw.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IEstudianteRepository;
import com.edu.uce.pw.api.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private IEstudianteRepository estudianteRepository;

    @Override
    public Estudiante buscar(Integer id) {
        // TODO Auto-generated method stub
        return this.estudianteRepository.seleccionar(id);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.estudianteRepository.actualizar(estudiante);
    }

    @Override
    public void borrar(Integer id) {
        // TODO Auto-generated method stub
        this.estudianteRepository.eliminar(id);
    }

    @Override
    public void guardar(Estudiante estudiante) {
        // TODO Auto-generated method stub
        this.estudianteRepository.insertar(estudiante);
    }

}
