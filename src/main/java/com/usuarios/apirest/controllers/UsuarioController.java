package com.usuarios.apirest.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuarios.apirest.models.Usuario;
import com.usuarios.apirest.repositories.IUsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/api/v1/usuarios")
@Api(value = "Usuario")
public class UsuarioController {

	@Autowired
    private IUsuarioRepository usuarioRepository;

	@PostMapping()
	@ApiOperation(value = "Cadastra um usuário")
    public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) {
		var user = new Usuario(usuario.getNome(), 
							   usuario.getEmail(), 
							   usuario.getCpf(), 
							   usuario.getSenha());
		
		usuarioRepository.save(user);
		
		user.setSenha(null);
		
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
    }
	
	@GetMapping("{id}")
	@ApiOperation(value = "Busca um usuário e seus endereços")
	public ResponseEntity<Optional<Usuario>> buscaUsuario(@PathVariable (value = "id") long id) {
		
		var user = usuarioRepository.findById(id);
		
		if (user.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
		return new ResponseEntity<Optional<Usuario>>(user, HttpStatus.OK);
	}
}








