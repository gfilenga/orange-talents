package com.usuarios.apirest.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuarios.apirest.models.Endereco;
import com.usuarios.apirest.repositories.IEnderecoRepository;
import com.usuarios.apirest.repositories.IUsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1/enderecos")
@Api(value = "Endereço")
public class EnderecoController {

	@Autowired
    private IEnderecoRepository enderecoRepository;
	
	@Autowired
    private IUsuarioRepository usuarioRepository;
	
	@PostMapping("/usuario/{user_id}")
	@ApiOperation(value = "Cadastra o endereço de determinado usuário")
	public ResponseEntity<Endereco> cadastraEnderec(@Valid @RequestBody Endereco endRequest, 
									 @PathVariable (value = "user_id") long user_id)
	{	
		var endereco = new Endereco(endRequest.getLogradouro(),
									endRequest.getNumero(),
									endRequest.getComplemento(),
									endRequest.getBairro(),
									endRequest.getCidade(),
									endRequest.getEstado(),
									endRequest.getCep());
		
		usuarioRepository.findById(user_id).map(usuario -> {
			endRequest.setUsuario(usuario);
			return enderecoRepository.save(endRequest);
		}).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		
		return new ResponseEntity<Endereco>(endereco, HttpStatus.CREATED);
	}
}






