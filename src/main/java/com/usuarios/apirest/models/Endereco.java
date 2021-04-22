package com.usuarios.apirest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Enderecos")
public class Endereco {
	public Endereco() { }
	public Endereco(String logradouro, int numero, String complemento, String bairro, String cidade, String localidade,String cep) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.localidade = localidade;
		this.cep = cep;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "logradouro", nullable = false)
	private String logradouro;
	@Column(name = "numero", nullable = false)
	private int numero;
	@Column(name = "complemento", nullable = true)
	private String complemento;
	@Column(name = "bairro", nullable = false)
	private String bairro;
	@Column(name = "cidade", nullable = false)
	private String cidade;
	@Column(name = "estado", nullable = false)
	@Length(min = 2, max = 20)
	private String localidade;
	@Column(name = "cep", nullable = false)
	@Pattern(regexp = "[0-9]{5}-[0-9]{3}")
	private String cep;
	
	@ManyToOne
    @JoinColumn(name="usuario_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
    private Usuario usuario;
	
	
	@Override
    public String toString() {
        return "Endereco{" +
        		"id='" + id + '\'' +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", estado='" + localidade + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	public String getLocalidade() {
		return localidade;
	}
	public void setEstado(String localidade) {
		this.localidade = localidade;
	}
	
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}	
}
