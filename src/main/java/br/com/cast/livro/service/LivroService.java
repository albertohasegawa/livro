package br.com.cast.livro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.livro.dto.AutorDTO;
import br.com.cast.livro.dto.CategoriaDTO;
import br.com.cast.livro.dto.LivroDTO;
import br.com.cast.livro.entidade.Autor;
import br.com.cast.livro.entidade.Categoria;
import br.com.cast.livro.entidade.Livro;
import br.com.cast.livro.repository.AutorRepository;
import br.com.cast.livro.repository.CategoriaRepository;
import br.com.cast.livro.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository lr;
	@Autowired
	private AutorRepository ar;
	@Autowired
	private CategoriaRepository cr;
	
	
	public List<LivroDTO> buscarTodos() {
		List<Livro> livros = lr.buscarTodos();
		List<LivroDTO> ldtos = new ArrayList<>();
		for (Livro livro : livros) {
			LivroDTO ldto = new LivroDTO();
			ldto.setId(livro.getId());
			ldto.setTitulo(livro.getTitulo());
			ldto.setDataPublicacao(livro.getDataPublicacao());
			Autor autor = ar.buscarPorId(livro.getAutor().getId());
			AutorDTO  adto = new AutorDTO();
			adto.setId(autor.getId());
			adto.setNome(autor.getNome());
			adto.setPseudonimo(autor.getPseudonimo());
			Categoria cat = cr.buscarPorId(livro.getCategoria().getId());
			CategoriaDTO cdto = new CategoriaDTO();
			cdto.setId(cat.getId());
			cdto.setDescricao(cat.getDescricao());
			ldto.setAutor(adto);
			ldto.setCategoria(cdto);
			ldtos.add(ldto);
		}
		return ldtos;
	}
	
	public LivroDTO buscarPorId(Integer id) {
		Livro livro = lr.buscarPorId(id);
		if (livro == null)
			return null;
		LivroDTO ldto = new LivroDTO();
		ldto.setId(livro.getId());
		ldto.setTitulo(livro.getTitulo());
		ldto.setDataPublicacao(livro.getDataPublicacao());
		Autor autor = ar.buscarPorId(livro.getAutor().getId());
		AutorDTO  adto = new AutorDTO();
		adto.setId(autor.getId());
		adto.setNome(autor.getNome());
		adto.setPseudonimo(autor.getPseudonimo());
		Categoria cat = cr.buscarPorId(livro.getCategoria().getId());
		CategoriaDTO cdto = new CategoriaDTO();
		cdto.setId(cat.getId());
		cdto.setDescricao(cat.getDescricao());
		ldto.setAutor(adto);
		ldto.setCategoria(cdto);
		return ldto;
	}
	
	public void inserir(LivroDTO ldto) {
		Livro livro = new Livro();
		livro.setTitulo(ldto.getTitulo());
		livro.setDataPublicacao(ldto.getDataPublicacao());
		Autor autor = ar.buscarPorId(ldto.getAutor().getId());
		Categoria cat = cr.buscarPorId(ldto.getCategoria().getId());
		livro.setAutor(autor);
		livro.setCategoria(cat);
		System.out.println("Passou pelo inserir " + autor + cat);
		lr.inserir(livro);
	}
	public void remover(Integer id) {
		lr.remover(id);
	}
	public void alterar(LivroDTO ldto) {
		Livro livro = new Livro();
		livro.setTitulo(ldto.getTitulo());
		livro.setDataPublicacao(ldto.getDataPublicacao());
		Autor autor = ar.buscarPorId(ldto.getAutor().getId());
		Categoria cat = cr.buscarPorId(ldto.getCategoria().getId());
		livro.setAutor(autor);
		livro.setCategoria(cat);
		lr.alterar(livro);
	}
	
	public LivroDTO buscarPorTitulo(String titulo) {
		Livro livro = lr.buscarPorTitulo(titulo);
		return null;
		//TODO
	}
	
}
