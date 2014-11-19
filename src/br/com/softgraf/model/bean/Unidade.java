package br.com.softgraf.model.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name="unidade")
public class Unidade {
	private Integer codigo;
	private String descricao;
	private List<Produto> produtos;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@OneToMany(fetch=FetchType.LAZY, mappedBy="unidade")
	@Fetch(value=FetchMode.SELECT)
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	@Transient
	public boolean isValido() {
		if(descricao != null && descricao.length() > 0)
			return true;
		return false;
	}
}
