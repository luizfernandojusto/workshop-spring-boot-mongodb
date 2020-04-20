package com.informaticaconsutoria.workshopmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.informaticaconsutoria.workshopmongodb.domain.Postagem;

@Repository
public interface PostagemRepository extends MongoRepository<Postagem, String> {

	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
	List<Postagem> buscarTitulo(String texto);

	List<Postagem> findByTituloContainingIgnoreCase(String texto);

}
