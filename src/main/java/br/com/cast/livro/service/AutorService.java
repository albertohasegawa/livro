package br.com.cast.livro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.livro.dto.AutorDTO;
import br.com.cast.livro.entidade.Autor;
import br.com.cast.livro.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository ar;
	
	public List<AutorDTO> buscarTodos() {
		List<Autor> autores = ar.buscarTodos();
		List<AutorDTO> adtos = new ArrayList<>();
		for (Autor autor : autores) {
			AutorDTO adto = new AutorDTO();
			adto.setId(autor.getId());
			adto.setNome(autor.getNome());
			adto.setPseudonimo(autor.getPseudonimo());
			adtos.add(adto);
		}
		return adtos;
	}
	public AutorDTO buscarPorId(Integer id) {
		Autor autor = ar.buscarPorId(id);
		AutorDTO adto = new AutorDTO();
		adto.setId(autor.getId());
		adto.setNome(autor.getNome());
		adto.setPseudonimo(autor.getPseudonimo());
		return adto;
	}
  	
	public void inserir(AutorDTO adto) {
		Autor autor = new Autor();
		autor.setNome(adto.getNome());
		autor.setPseudonimo(adto.getPseudonimo());
		ar.inserir(autor);
	}
	public void remover(Integer id) {
		ar.remover(id);
	}
	
	public void alterar(AutorDTO adto) {
		Autor autor = new Autor();
		autor.setNome(adto.getNome());
		autor.setPseudonimo(adto.getPseudonimo());
		ar.alterar(autor);
	}
	
	
}
