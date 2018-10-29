package br.com.cast.livro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.livro.dto.CategoriaDTO;
import br.com.cast.livro.entidade.Categoria;
import br.com.cast.livro.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository cr;
	
	public List<CategoriaDTO> buscarTodos() {
		List<Categoria> cats = cr.buscarTodos();
		List<CategoriaDTO> catsdto = new ArrayList<>();
		for (Categoria categoria : cats) {
			CategoriaDTO catdto = new CategoriaDTO();
			catdto.setId(categoria.getId());
			catdto.setDescricao(categoria.getDescricao());
			catsdto.add(catdto);
		}
		return catsdto;
	}
	
	public CategoriaDTO buscarPorId(Integer id) {
		Categoria cat = cr.buscarPorId(id);
		CategoriaDTO catdto = new CategoriaDTO();
		catdto.setId(cat.getId());
		catdto.setDescricao(cat.getDescricao());
		return catdto;
	}
	
	public void inserir(CategoriaDTO catdto) {
		Categoria cat = new Categoria();
		cat.setDescricao(catdto.getDescricao());
		cr.inserir(cat);
	}
	public void remover(Integer id) {
		cr.remover(id);
	}
	public void alterar(CategoriaDTO catdto) {
		Categoria cat = new Categoria();
		cat.setDescricao(catdto.getDescricao());
		cr.alterar(cat);
	}
} 
