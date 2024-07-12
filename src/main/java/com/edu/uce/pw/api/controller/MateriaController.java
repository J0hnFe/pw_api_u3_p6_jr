package com.edu.uce.pw.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     * {
     * "nombre": "Civica",
     * "creditos": 3,
     * "ced_profesor": "5555",
     * "nivel": 3
     * }
     */

    // http://localhost:8080/API/v1.0/Matricula/materias
    @PostMapping
    public ResponseEntity<String> guardar(@RequestBody Materia mat) {
        this.materiaService.guardar(mat);
        // return ResponseEntity.status(201).body("Materia creada");

        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("mensaje_238", "Cabecera test");
        return new ResponseEntity<>(mat.toString(), cabeceras, 238);
    }

    // http://localhost:8080/API/v1.0/Matricula/materias/1
    @PutMapping(path = "/{id}")
    public ResponseEntity<String> actualizar(@RequestBody Materia mat, @PathVariable Integer id) {
        mat.setId(id);
        this.materiaService.actualizar(mat);
        // return ResponseEntity.status(238).body(mat);

        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("mensaje_238", "Cabecera test");
        return new ResponseEntity<>("Actualizar", cabeceras, 238);

    }

    // http://localhost:8080/API/v1.0/Matricula/materias/1
    @PatchMapping(path = "/{id}")
    public ResponseEntity<String> actualizaParcial(@RequestBody Materia mat, @PathVariable Integer id) {
        mat.setId(id);
        Materia mat2 = this.materiaService.buscar(mat.getId());
        if (mat.getNombre() != null) {
            mat2.setNombre(mat.getNombre());
        }
        if (mat.getNivel() != null) {
            mat2.setNivel(mat.getNivel());
        }
        if (mat.getCreditos() != null) {
            mat2.setCreditos(mat.getCreditos());
        }
        if (mat.getCed_profesor() != null) {
            mat2.setCed_profesor(mat.getCed_profesor());
        }

        this.materiaService.actualizar(mat2);

        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("mensaje_239", "Cabecera test");
        return new ResponseEntity<>("ActualizarParcial", cabeceras, 239);
    }

    // http://localhost:8080/API/v1.0/Matricula/materias/1
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("mensaje_240", "Cabecera Estudiante eliminado");
        return new ResponseEntity<>("eliminado", cabeceras, 240);
    }

    // http://localhost:8080/API/v1.0/Matricula/materias/1
    @GetMapping(path = "/{id}")
    public ResponseEntity<Materia> buscarPorId(@PathVariable Integer id) {
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("mensaje_236", "Cabecera test");
        return new ResponseEntity<>(this.materiaService.buscar(id), cabeceras, 236);
    }

    // http://localhost:8080/API/v1.0/Matricula/materias/nivel?nivel=1
    @GetMapping(path = "/nivel")
    public ResponseEntity<List<Materia>> buscarPorNivel(@RequestParam Integer nivel) {
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.add("mensaje_236", "Cabecera test");
        return new ResponseEntity<>(this.materiaService.buscarPorNivel(nivel), cabeceras, 236);
    }
}
