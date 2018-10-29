package br.com.cast.livro.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.livro.entidade.Categoria;

@Repository
public class CategoriaRepository {

	@PersistenceContext
	private EntityManager em;
	
	public List<Categoria> buscarTodos() {
		return em.createQuery("FROM " + Categoria.class.getName()).getResultList();
	}
	public Categoria buscarPorId(Integer id) {
		return em.find(Categoria.class, id);
	}
	@Transactional
	public void inserir(Categoria cat) {
		em.persist(cat);
	}
	@Transactional
	public void remover(Integer id) {
		em.remove(buscarPorId(id));
	}
	@Transactional
	public void alterar(Categoria cat) {
		em.merge(cat);
	}
	
}
