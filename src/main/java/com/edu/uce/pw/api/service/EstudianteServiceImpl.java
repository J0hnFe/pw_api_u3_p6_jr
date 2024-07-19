package com.edu.uce.pw.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IEstudianteRepository;
import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private IEstudianteRepository estudianteRepository;

    @Override
    public Estudiante buscar(String cedula) {
        return this.estudianteRepository.seleccionar(cedula);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.estudianteRepository.actualizar(estudiante);
    }

    @Override
    public void borrar(String cedula) {
        this.estudianteRepository.eliminar(cedula);
    }

    @Override
    public void guardar(Estudiante estudiante) {
        this.estudianteRepository.insertar(estudiante);
    }

    @Override
    public List<Estudiante> buscarPorGenero(String genero) {
        return this.estudianteRepository.seleccionarPorGenero(genero);
    }

    public EstudianteTO convertir(Estudiante e) {
        EstudianteTO estudianteTO = new EstudianteTO();
        estudianteTO.setId(e.getId());
        estudianteTO.setNombre(e.getNombre());
        estudianteTO.setApellido(e.getApellido());
        estudianteTO.setFechaNacimiento(e.getFechaNacimiento());
        estudianteTO.setGenero(e.getGenero());
        return estudianteTO;
    }

    @Override
    public EstudianteTO buscarPorCedula(String cedula) {
        Estudiante e = this.estudianteRepository.seleccionar(cedula);
        return this.convertir(e);
    }

    @Override
    public List<EstudianteTO> buscarTodos() {
        List<Estudiante> estudiantes = this.estudianteRepository.seleccionarTodos();
        List<EstudianteTO> estudiantesTO = new ArrayList<>();
        for (Estudiante e : estudiantes) {
            estudiantesTO.add(this.convertir(e));
        }
        return estudiantesTO;        
    }

    

}
