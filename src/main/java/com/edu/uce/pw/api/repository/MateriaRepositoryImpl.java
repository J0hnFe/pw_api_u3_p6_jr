package com.edu.uce.pw.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.uce.pw.api.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Materia seleccionar(Integer id) {
        return this.em.find(Materia.class, id);

    }

    @Override
    public void actualizar(Materia mat) {
        this.em.merge(mat);
    }

    @Override
    public void eliminar(Integer id) {
        this.em.remove(this.seleccionar(id));
    }

    @Override
    public void insertar(Materia mat) {
        this.em.persist(mat);
    }

    @Override
    public List<Materia> seleccionarPorNivel(Integer nivel) {
        String jpql = "SELECT m FROM Materia m WHERE m.nivel = :nivel";
        TypedQuery<Materia> myQuery = this.em.createQuery(jpql, Materia.class);
        myQuery.setParameter("nivel", nivel);
        return myQuery.getResultList();
    }
}
