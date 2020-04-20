package com.informaticaconsutoria.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.informaticaconsutoria.workshopmongodb.domain.Postagem;

@Repository
public interface PostagemRepository extends MongoRepository<Postagem, String> {
	
	
	

}