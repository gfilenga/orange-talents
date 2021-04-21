package com.usuarios.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usuarios.apirest.models.Endereco;

@Repository
public interface IEnderecoRepository extends JpaRepository<Endereco, Long>{
}
