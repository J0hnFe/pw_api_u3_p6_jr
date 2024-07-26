package com.edu.uce.pw.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.IEstudianteService;
import com.edu.uce.pw.api.service.IMateriaService;

@RestController
@CrossOrigin(value = "http://localhost:8081") // Vue está en ese puerto, so le permito a este proyecto que se conecte
@RequestMapping(path = "/estudiantes")

public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IMateriaService materiaService;

	// Nivel1: http://localhost:8080/API/v1.0/Matricula/estudiantes
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante est) {
		this.estudianteService.guardar(est);
		return ResponseEntity.status(HttpStatus.OK).body(est);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1111
	@PutMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estudiante> actualizar(@RequestBody Estudiante est, @PathVariable String cedula) {
		est.setCedula(cedula);
		this.estudianteService.actualizar(est);
		return ResponseEntity.status(238).body(est);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1111
	@PatchMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estudiante> actualizarParcial(@RequestBody Estudiante est, @PathVariable String cedula) {
		est.setCedula(cedula);
		Estudiante est2 = this.estudianteService.buscar(est.getCedula());
		if (est.getNombre() != null) {
			est2.setNombre(est.getNombre());
		}
		if (est.getApellido() != null) {
			est2.setApellido(est.getApellido());
		}
		if (est.getFechaNacimiento() != null) {
			est2.setFechaNacimiento(est.getFechaNacimiento());
		}
		this.estudianteService.actualizar(est2);
		return ResponseEntity.status(239).body(est2);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1111
	@DeleteMapping(path = "/{cedula}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> borrar(@PathVariable String cedula) {
		this.estudianteService.borrar(cedula);
		return ResponseEntity.status(240).body("Estudiante eliminado");
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1111
	@GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estudiante> buscarPorCedula(@PathVariable("cedula") String cedula) {
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_236", "Corresponde a la consulta de un recurso");
		cabeceras.add("valor", "estu encontrado");
		return new ResponseEntity<>(this.estudianteService.buscar(cedula), cabeceras, 236);
	}
}
