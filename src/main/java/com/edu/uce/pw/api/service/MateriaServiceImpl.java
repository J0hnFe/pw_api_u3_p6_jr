package com.edu.uce.pw.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IMateriaRepository;
import com.edu.uce.pw.api.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService{

    @Autowired
    private IMateriaRepository materiaRepository;

    @Override
    public Materia buscar(Integer id) {
        return this.materiaRepository.seleccionar(id);
    }

    @Override
    public void actualizar(Materia materia) {
        this.materiaRepository.actualizar(materia);
    }

    @Override
    public void borrar(Integer id) {
        this.materiaRepository.eliminar(id);
    }

    @Override
    public void guardar(Materia materia) {
        this.materiaRepository.insertar(materia);
    }

    @Override
    public List<Materia> buscarPorNivel(Integer nivel) {
        return this.materiaRepository.seleccionarPorNivel(nivel);
    }
    
}
