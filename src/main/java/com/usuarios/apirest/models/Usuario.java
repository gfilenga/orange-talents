package com.usuarios.apirest.models;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;



@Entity
@Table(name = "Usuarios")
public class Usuario {
	
	public Usuario() {}
	
	public Usuario(String nome, String email, String cpf, String senha) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "nome", nullable = false)
	@Length(min = 2, max = 50)
	private String nome;
	
	@Column(name = "email", nullable = false, unique=true)
	@Email
	private String email;
	
	@Column(name = "cpf", nullable = false, unique=true)
	@CPF
	private String cpf;
	
	@Column(name = "senha", nullable = false)
	@Length(min = 6, max = 20)
	private String senha;

	// Relacionamento
    @OneToMany(mappedBy="usuario", cascade = CascadeType.REMOVE)
	private List<Endereco> enderecos;
	

	
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {	
		this.email = email;
	}

	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
	
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}
