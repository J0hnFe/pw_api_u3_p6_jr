package com.edu.uce.pw.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edu.uce.pw.api.repository.modelo.Estudiante;
import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.EstudianteServiceImpl;
import com.edu.uce.pw.api.service.MateriaServiceImpl;
import java.time.LocalDateTime;

@SpringBootApplication
public class PwApiU3P6JrApplication implements CommandLineRunner {

	@Autowired
	private MateriaServiceImpl materiaService;

	@Autowired
	private EstudianteServiceImpl estudianteService;

	public static void main(String[] args) {
		SpringApplication.run(PwApiU3P6JrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Materia mat1 = Materia.builder().nombre("Matematicas").creditos(10).build();
		Materia mat2 = Materia.builder().nombre("Fisica").creditos(8).build();
		Materia mat3 = Materia.builder().nombre("Quimica").creditos(6).build();
		Materia mat4 = Materia.builder().nombre("Biologia").creditos(4).build();

		Estudiante est1 = Estudiante.builder()
				.nombre("Juan")
				.apellido("Perez")
				.fechaNacimiento(LocalDateTime.now())
				.genero("M").build();

		Estudiante est2 = Estudiante.builder()
				.nombre("Maria")
				.apellido("Gomez")
				.fechaNacimiento(LocalDateTime.now())
				.genero("F").build();

		Estudiante est3 = Estudiante.builder()
				.nombre("Pedro")
				.apellido("Garcia")
				.fechaNacimiento(LocalDateTime.now())
				.genero("M").build();

		Estudiante est4 = Estudiante.builder()
				.nombre("Ana")
				.apellido("Lopez")
				.fechaNacimiento(LocalDateTime.now())
				.genero("F").build();

		// materiaService.guardar(mat1);
		// materiaService.guardar(mat2);
		// materiaService.guardar(mat3);
		// materiaService.guardar(mat4);

		// estudianteService.guardar(est1);
		// estudianteService.guardar(est2);
		// estudianteService.guardar(est3);
		// estudianteService.guardar(est4);
	}
}
