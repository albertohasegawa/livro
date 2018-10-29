package br.com.cast.livro.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.livro.dto.AutorDTO;
import br.com.cast.livro.dto.CategoriaDTO;
import br.com.cast.livro.dto.LivroDTO;
import br.com.cast.livro.service.AutorService;
import br.com.cast.livro.service.CategoriaService;
import br.com.cast.livro.service.LivroService;

@RestController
@RequestMapping("/")
public class LivroController {

	
	@Autowired
	private AutorService as;
	@Autowired
	private LivroService ls;
	@Autowired
	private CategoriaService cs;
	
	
	@RequestMapping(path="livro", method=RequestMethod.GET)
	public List<LivroDTO> buscarLivros(){
		return ls.buscarTodos();
	}
	
	@RequestMapping(path="livro/{id}", method=RequestMethod.GET)
	public LivroDTO buscarPorId(@PathVariable(value="id") Integer id) {
		return ls.buscarPorId(id);
	}
	
	@RequestMapping(path="livro", method=RequestMethod.POST)
	public void inserirLivro(@RequestBody LivroDTO ldto) {
		ls.inserir(ldto);
	}
	
	@RequestMapping(path="livro/{id}", method=RequestMethod.DELETE)
	public void removerLivro(@PathVariable(value="id") Integer id) {
		ls.remover(id);
	}
	
	@RequestMapping(path="livro/{id}", method=RequestMethod.PUT)
	public void alterarLivro(@PathVariable(value="id") Integer id, @RequestBody LivroDTO ldto) {
		ls.alterar(ldto);
	}
	
	@RequestMapping(path="autor", method=RequestMethod.GET) 
	public List<AutorDTO> buscarAutores() {
		return as.buscarTodos();
	}
	
	@RequestMapping(path="autor/{id}", method=RequestMethod.GET)
	public AutorDTO buscarAutor(@PathVariable(value="id") Integer id) {
		return as.buscarPorId(id);
	}
	
	@RequestMapping(path="autor", method=RequestMethod.POST)
	public void inserirAutor(@RequestBody AutorDTO adto) {
		as.inserir(adto);
	}
	
	@RequestMapping(path="autor/{id}", method=RequestMethod.DELETE)
	public void removerAutor(@PathVariable(value="id") Integer id) {
		as.remover(id);
	}
	
	@RequestMapping(path="autor/{id}", method=RequestMethod.PUT)
	public void alterarAutor(@PathVariable(value="id") Integer id, @RequestBody AutorDTO adto) {
		as.alterar(adto);
	}
	
	@RequestMapping(path="categoria", method=RequestMethod.GET)
	public List<CategoriaDTO> buscarCategorias() {
		return cs.buscarTodos();
	}
	@RequestMapping(path="categoria/{id}", method=RequestMethod.GET)
	public CategoriaDTO buscarCategoria(@PathVariable(value="id") Integer id) {
		return cs.buscarPorId(id);
	}
	
	@RequestMapping(path="categoria", method=RequestMethod.POST)
	public void inserirCategoria(@RequestBody CategoriaDTO cdto) {
		cs.inserir(cdto);
	}
	@RequestMapping(path="categoria/{id}", method=RequestMethod.DELETE)
	public void removerCategoria(@PathVariable(value="id") Integer id) {
		cs.remover(id);
	}
	@RequestMapping(path="categoria/{id}", method=RequestMethod.PUT)
	public void alterarCategoria(@PathVariable(value="id") Integer id, @RequestBody CategoriaDTO cdto) {
		cs.alterar(cdto);
	}
	
	
}
