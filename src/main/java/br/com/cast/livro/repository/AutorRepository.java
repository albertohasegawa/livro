package br.com.cast.livro.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.livro.entidade.Autor;

@Repository
public class AutorRepository {

	@PersistenceContext
	private EntityManager em;
	
	
	public List<Autor> buscarTodos() {
		return em.createQuery("FROM " + Autor.class.getName()).getResultList();
	}
	
	public Autor buscarPorId(Integer id) {
		return em.find(Autor.class, id);
	}
	@Transactional
	public void inserir(Autor autor) {
		em.persist(autor);
	}
	@Transactional
	public void remover(Integer id) {
		em.remove(buscarPorId(id));
	}
	@Transactional
	public void alterar(Autor autor) {
		em.merge(autor);
	}
	
}
