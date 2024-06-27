package com.edu.uce.pw.api.repository;
 
import org.springframework.stereotype.Repository;
 
import com.edu.uce.pw.api.repository.modelo.Estudiante;
 
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Repository
@Transactional
 
public class EstudianteRepositoryImpl implements IEstudianteRepository{
 
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public Estudiante seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}
 
	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.merge(estudiante);
		
	}
 
	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
		this.entityManager.remove(this.seleccionar(id));
	}
 
	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.entityManager.persist(estudiante);
		
	}
	
 
}
