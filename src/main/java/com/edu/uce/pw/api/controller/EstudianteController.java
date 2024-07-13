package com.edu.uce.pw.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.service.IEstudianteService;
import com.edu.uce.pw.api.service.IMateriaService;
import com.edu.uce.pw.api.service.to.EstudianteTO;
import com.edu.uce.pw.api.service.to.MateriaTO;

@RestController
@RequestMapping(path = "/estudiantes")

public class EstudianteController {

	/*
	 * 
	 * {
	 * "nombre": "Jorge",
	 * "apellido": "Benalcazar",
	 * "fechaNacimiento": "1999-01-01T01:01:01",
	 * "genero": null
	 * }
	 */

	@Autowired
	private IEstudianteService estudianteService;

	@Autowired
	private IMateriaService materiaService;

	// Nivel1: http://localhost:8080/API/v1.0/Matricula/estudiantes
	@PostMapping(produces = "application/json", consumes = "application/xml")
	public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante est) {
		return ResponseEntity.status(HttpStatus.OK).body(est);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	@PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Estudiante> actualizar(@RequestBody Estudiante est, @PathVariable Integer id) {
		est.setId(id);
		this.estudianteService.actualizar(est);
		return ResponseEntity.status(238).body(est);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	@PatchMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Estudiante> actualizarParcial(@RequestBody Estudiante est, @PathVariable Integer id) {
		est.setId(id);
		Estudiante est2 = this.estudianteService.buscar(est.getId());
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

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	@DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> borrar(@PathVariable Integer id) {
		this.estudianteService.borrar(id);
		return ResponseEntity.status(240).body("Estudiante eliminado");
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/1
	@GetMapping(path = "/{id}", produces = "application/xml")
	public ResponseEntity<Estudiante> buscarPorId(@PathVariable("id") Integer id) {
		// this.estudianteService.buscar(id);
		// return ResponseEntity.status(236).body(this.estudianteService.buscar(id));
		// HttpHeaders de spring framework
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("mensaje_236", "Corresponde a la consulta de un recurso");
		cabeceras.add("valor", "estu encontrado");
		return new ResponseEntity<>(this.estudianteService.buscar(id), cabeceras, 236);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/genero?genero=F
	@GetMapping(path = "/genero", produces = "application/xml")
	public List<Estudiante> buscarPorGenero(@RequestParam String genero) {
		List<Estudiante> ls = this.estudianteService.buscarPorGenero(genero);
		return ls;
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/mixto/1
	@GetMapping(path = "/mixto/{id}", produces = "application/xml")
	public Estudiante buscarMixto(@PathVariable Integer id, @RequestParam String prueba) {
		// System.out.println("dato: " + id);
		// System.out.println("dato: " + prueba);
		return this.estudianteService.buscar(id);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/test/1
	@GetMapping(path = "/test/{id}")
	public Estudiante test(@PathVariable Integer id, @RequestBody Estudiante e) {
		System.out.println(e);
		return this.estudianteService.buscar(id);
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/texto/plano
	@GetMapping(path = "/texto/plano")
	public String prueba() {
		String prueba = "texto de prueba";
		return prueba;
	}

	// http://localhost:8080/API/v1.0/Matricula/estudiantes/hateoas/1
	@GetMapping(path = "/hateoas/{id}")
	public EstudianteTO buscarHateoas(@PathVariable("id") Integer id) {
		EstudianteTO estudianteTO = this.estudianteService.buscarPorId(id);
		List<MateriaTO> ls = this.materiaService.buscarPorIdEstudiante(id);
		estudianteTO.setMaterias(ls);
		return estudianteTO;
	}
}
