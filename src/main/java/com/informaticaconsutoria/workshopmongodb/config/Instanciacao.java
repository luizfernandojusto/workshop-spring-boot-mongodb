package com.informaticaconsutoria.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.informaticaconsutoria.workshopmongodb.domain.Postagem;
import com.informaticaconsutoria.workshopmongodb.domain.Usuario;
import com.informaticaconsutoria.workshopmongodb.dto.ComentarioDTO;
import com.informaticaconsutoria.workshopmongodb.dto.UsuarioDTO;
import com.informaticaconsutoria.workshopmongodb.dto.UsuarioPostagemDTO;
import com.informaticaconsutoria.workshopmongodb.repository.PostagemRepository;
import com.informaticaconsutoria.workshopmongodb.repository.UsuarioRepository;

@Configuration
public class Instanciacao implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PostagemRepository postagemRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		usuarioRepository.deleteAll();
		postagemRepository.deleteAll();

		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");

		usuarioRepository.saveAll(Arrays.asList(maria, alex, bob));

		Postagem p1 = new Postagem(null, sdf.parse("21/03/2018"), "Partiu viagem",
				"Vou viajar para São Paulo. Abraços!", new UsuarioPostagemDTO(maria));

		Postagem p2 = new Postagem(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!",
				new UsuarioPostagemDTO(maria));

		ComentarioDTO c1 = new ComentarioDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new UsuarioDTO(alex));
		ComentarioDTO c2 = new ComentarioDTO("Aproveite!", sdf.parse("22/03/2018"), new UsuarioDTO(bob));
		ComentarioDTO c3 = new ComentarioDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new UsuarioDTO(alex));

		p1.getComentarios().addAll(Arrays.asList(c1, c2));
		p2.getComentarios().addAll(Arrays.asList(c3));

		postagemRepository.saveAll(Arrays.asList(p1, p2));

		maria.getPostagens().addAll(Arrays.asList(p1, p2));
		usuarioRepository.save(maria);

	}

}
