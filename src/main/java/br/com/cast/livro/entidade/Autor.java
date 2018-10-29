package br.com.cast.livro.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="livroestudo", name="autor")
public class Autor {

	@Id
	@SequenceGenerator(name="autor_generator", sequenceName="livroestudo.autor_id_seq", allocationSize=1)
	@GeneratedValue(generator="autor_generator")
	private Integer id;
	private String nome;
	private String pseudonimo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPseudonimo() {
		return pseudonimo;
	}
	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}
	
}
