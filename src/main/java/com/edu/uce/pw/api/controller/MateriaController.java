package com.edu.uce.pw.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.IMateriaService;
import com.edu.uce.pw.api.service.to.MateriaTO;

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
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Materia> guardar(@RequestBody Materia mat) {
        this.materiaService.guardar(mat);
        return ResponseEntity.status(HttpStatus.OK).body(mat);
    }

    // http://localhost:8080/API/v1.0/Matricula/materias/1
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Materia> actualizar(@RequestBody Materia mat, @PathVariable Integer id) {
        mat.setId(id);
        this.materiaService.actualizar(mat);
        return ResponseEntity.status(HttpStatus.OK).body(mat);
    }

    // http://localhost:8080/API/v1.0/Matricula/materias/1
    @PatchMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Materia> actualizaParcial(@RequestBody Materia mat, @PathVariable Integer id) {
        mat.setId(id);
        Materia mat2 = this.materiaService.buscar(mat.getId());
        if (mat.getNombre() != null) {
            mat2.setNombre(mat.getNombre());
        }
        if (mat.getCreditos() != null) {
            mat2.setCreditos(mat.getCreditos());
        }

        this.materiaService.actualizar(mat2);
        return ResponseEntity.status(HttpStatus.OK).body(mat2);
    }

    // http://localhost:8080/API/v1.0/Matricula/materias/1
    @DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        this.materiaService.borrar(id);
        return ResponseEntity.status(HttpStatus.OK).body("Registro eliminado");
    }

    // http://localhost:8080/API/v1.0/Matricula/materias/1
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Materia> buscarPorId(@PathVariable Integer id) {
        this.materiaService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.buscar(id));
    }

    	// GET: http://localhost:8080/API/v1.0/Matricula/materias/2/materias 
	@GetMapping(path = "/{id}/materias", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MateriaTO> buscarMateriasPorEstudiante(@PathVariable("id") Integer id) {
		return this.materiaService.buscarPorIdEstudiante(id);
	}

}
