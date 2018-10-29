package br.com.cast.livro.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.livro.entidade.Livro;

@Repository
public class LivroRepository {

	
	@PersistenceContext
	private EntityManager em;
	
	public List<Livro> buscarTodos() {
		return em.createQuery("FROM " + Livro.class.getName()).getResultList();
	}
	public Livro buscarPorId(Integer id) {
		try {
			return em.find(Livro.class, id);
		} catch (Exception e) {
			return null;
		}
	}
	
	public Livro buscarPorTitulo(String titulo) {
		Query query = em.createQuery("FROM " + Livro.class.getName() + " WHERE titulo like :titulo");
		query.setParameter("titulo", "%" + titulo + "%");
		try {
			Livro livro = (Livro) query.getSingleResult();
			return livro;
		} catch (Exception e) {
			return null;
		}

	}
	
	@Transactional
	public void inserir(Livro livro) {
		em.persist(livro);
	}
	@Transactional
	public void remover(Integer id) {
		em.remove(buscarPorId(id));
	}
	
	@Transactional
	public void alterar(Livro livro) {
		em.merge(livro);
	}
} 
