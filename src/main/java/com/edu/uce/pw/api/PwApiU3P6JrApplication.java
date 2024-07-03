package com.edu.uce.pw.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edu.uce.pw.api.repository.modelo.Materia;
import com.edu.uce.pw.api.service.MateriaServiceImpl;

@SpringBootApplication
public class PwApiU3P6JrApplication implements CommandLineRunner{

	
	@Autowired
	private MateriaServiceImpl materiaService;

	public static void main(String[] args) {
		SpringApplication.run(PwApiU3P6JrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Materia mat1 = new Materia();
		mat1.setNombre("Matematicas");
		mat1.setNivel(1);
		mat1.setCreditos(10);
		mat1.setCed_profesor("111");

		Materia mat2 = new Materia();
		mat2.setNombre("Fisica");
		mat2.setNivel(1);
		mat2.setCreditos(5);
		mat2.setCed_profesor("222");

		Materia mat3 = new Materia();
		mat3.setNombre("Quimica");
		mat3.setNivel(3);
		mat3.setCreditos(8);
		mat3.setCed_profesor("333");

		Materia mat4 = new Materia();
		mat4.setNombre("Biologia");
		mat4.setNivel(4);
		mat4.setCreditos(15);
		mat4.setCed_profesor("444");
	
		// materiaService.guardar(mat1);
		// materiaService.guardar(mat2);
		// materiaService.guardar(mat3);
		// materiaService.guardar(mat4);
	}
}
