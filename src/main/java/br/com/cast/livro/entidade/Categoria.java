package br.com.cast.livro.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="livroestudo", name="categoria")
public class Categoria {

	@Id
	@SequenceGenerator(name="cat_generator", sequenceName="livroestudo.categoria_id_seq", allocationSize=1)
	@GeneratedValue(generator="cat_generator")
	private Integer id;
	private String descricao;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
