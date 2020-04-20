package com.informaticaconsutoria.workshopmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.informaticaconsutoria.workshopmongodb.domain.Postagem;
import com.informaticaconsutoria.workshopmongodb.resources.util.URL;
import com.informaticaconsutoria.workshopmongodb.services.PostagemService;

@RestController
@RequestMapping(value = "/postagens")
public class PostagemResource {

	@Autowired
	private PostagemService postagemService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Postagem> listarId(@PathVariable String id) {
		Postagem postagem = postagemService.listarId(id);
		return ResponseEntity.ok().body(postagem);
	}

	@GetMapping(value = "/pesquisartitulo")
	public ResponseEntity<List<Postagem>> pesquisarTitulo(
			@RequestParam(value = "text", defaultValue = "") String texto) {		
		texto = URL.codigoParamentro(texto);		
		List<Postagem> list = postagemService.listaIdTitulo(texto);	
		return ResponseEntity.ok().body(list);
	}

}
