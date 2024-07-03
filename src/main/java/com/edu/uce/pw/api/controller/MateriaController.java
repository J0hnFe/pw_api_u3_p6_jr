package com.edu.uce.pw.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.IMateriaService;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;


@RestController
@RequestMapping(path = "/materias")
public class MateriaController {
    @Autowired
    private IMateriaService materiaService;

    /*
 {
    "nombre": "Civica",
    "creditos": 3,
    "ced_profesor": "5555",
    "nivel": 3
}
     */
    
    // http://localhost:8080/API/v1.0/Matricula/materias/guardar
    @PostMapping(path = "/guardar")
    public void guardar(@RequestBody Materia mat) {
        this.materiaService.guardar(mat);
    }

    // http://localhost:8080/API/v1.0/Matricula/materias/actualizar
    @PutMapping(path = "/actualizar")
    public void actualizar(@RequestBody Materia mat) {
        this.materiaService.actualizar(mat);
    }

    // http://localhost:8080/API/v1.0/Matricula/materias/actualizarParcial
    @PatchMapping(path = "/actualizarParcial")
    public void actualizaParcial(@RequestBody Materia mat) {
        Materia mat2 = this.materiaService.buscar(mat.getId());
        if (mat.getNombre() != null) {
            mat2.setNombre(mat.getNombre());
        }
        if (mat.getNivel() != null) {
            mat2.setNivel(mat.getNivel());
        }
        if (mat.getCreditos()!= null) {
            mat2.setCreditos(mat.getCreditos());
        }
        this.materiaService.actualizar(mat2);
    }

    // http://localhost:8080/API/v1.0/Matricula/materias/borrar/1
    @DeleteMapping(path = "/borrar/{id}")
    public void eliminar(@PathVariable Integer id) {
        this.materiaService.borrar(1);
    }

    // http://localhost:8080/API/v1.0/Matricula/materias/buscar/1/nuevo
    @GetMapping(path = "/buscar/{id}/nuevo")
    public Materia buscar(@PathVariable Integer id) {
        return this.materiaService.buscar(id);
    }

    // http://localhost:8080/API/v1.0/Matricula/materias/buscarPorNivel/1
    @GetMapping(path = "/buscarPorNivel/{nivel}")
    public List<Materia> buscarPorNivel(@PathVariable Integer nivel) {
        List<Materia> materias = this.materiaService.buscarPorNivel(nivel);
        return materias;
    }
}
