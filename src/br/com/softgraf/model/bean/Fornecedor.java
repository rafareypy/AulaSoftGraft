package br.com.softgraf.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name="fornecedor")
public class Fornecedor 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	
	private String nome ;
	
	private String endereco ;
	
	private String email ;
	
	private String bairro ;
	
	private String auditoria ;

	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(String auditoria) {
		this.auditoria = auditoria;
	}	
	
	

	public Boolean isValid()	
	{
	
		Boolean result = true ;
		
		if( "".equals(nome) || nome == null ){
			result = false ;
		}else if( "".equals(endereco) || endereco == null ){
			result = false ;
		}else if( "".equals(email) || email == null ){
			result = false ;
		}else if( "".equals(bairro) || bairro == null ){
			result = false ;
		}

		return result ;
		
	}
	
	public String toString()
	{
		return " Nome =" +nome + " - Emial=  " + email 
				+ " -Bairro " + bairro  + " - Auditoria" + auditoria  ;

	}
	
}
