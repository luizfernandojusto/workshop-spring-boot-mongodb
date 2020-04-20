package com.informaticaconsutoria.workshopmongodb.dto;

import java.io.Serializable;

import com.informaticaconsutoria.workshopmongodb.domain.Usuario;

public class UsuarioPostagemDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;

	public UsuarioPostagemDTO() {
	}

	public UsuarioPostagemDTO(Usuario usuario) {
		id = usuario.getId();
		nome = usuario.getNome();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
