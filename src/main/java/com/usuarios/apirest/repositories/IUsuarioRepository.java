package com.usuarios.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usuarios.apirest.models.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{

}
