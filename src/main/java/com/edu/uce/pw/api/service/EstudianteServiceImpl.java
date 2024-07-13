package com.edu.uce.pw.api.service;

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
    public Estudiante buscar(Integer id) {
        return this.estudianteRepository.seleccionar(id);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.estudianteRepository.actualizar(estudiante);
    }

    @Override
    public void borrar(Integer id) {
        this.estudianteRepository.eliminar(id);
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
    public EstudianteTO buscarPorId(Integer id) {
        Estudiante e = this.estudianteRepository.seleccionar(id);
        return this.convertir(e);
    }

}