package com.edu.uce.pw.api.repository;
 
import java.util.List;

import org.springframework.stereotype.Repository;
 
import com.edu.uce.pw.api.repository.modelo.Estudiante;
 
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
 
public class EstudianteRepositoryImpl implements IEstudianteRepository{
 
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public Estudiante seleccionar(Integer id) {
		return this.entityManager.find(Estudiante.class, id);
	}
 
	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);
		
	}
 
	@Override
	public void eliminar(Integer id) {		
		this.entityManager.remove(this.seleccionar(id));
	}
 
	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
		
	}

	@Override
	public List<Estudiante> seleccionarPorGenero(String genero) {
		String jpql = "SELECT e FROM Estudiante e WHERE e.genero =: genero";
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery(jpql, Estudiante.class);
		myQuery.setParameter("genero", genero);
		return myQuery.getResultList();
	}
}
