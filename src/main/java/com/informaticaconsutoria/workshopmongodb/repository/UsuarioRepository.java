package com.informaticaconsutoria.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.informaticaconsutoria.workshopmongodb.domain.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
	
	

}
