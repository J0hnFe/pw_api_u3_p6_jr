package com.edu.uce.pw.api.repository;
import java.util.List;

import com.edu.uce.pw.api.repository.modelo.Materia;

public interface IMateriaRepository {
    Materia seleccionar(Integer id);
    void actualizar(Materia mat);
    void eliminar(Integer id);
    void insertar(Materia mat);
    List<Materia> seleccionarPorNivel(Integer nivel);
}
