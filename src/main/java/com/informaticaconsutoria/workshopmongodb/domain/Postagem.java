package com.informaticaconsutoria.workshopmongodb.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.informaticaconsutoria.workshopmongodb.dto.UsuarioPostagemDTO;

@Document(collection = "postagem")
public class Postagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Date data;
	private String titulo;
	private String corpo;

	private UsuarioPostagemDTO usuarioPostagemDTO;

	public Postagem() {
	}

	public Postagem(String id, Date data, String titulo, String corpo, UsuarioPostagemDTO usuarioPostagemDTO) {
		super();
		this.id = id;
		this.data = data;
		this.titulo = titulo;
		this.corpo = corpo;
		this.usuarioPostagemDTO = usuarioPostagemDTO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public void setUsuario(UsuarioPostagemDTO usuarioPostagemDTO) {
		this.usuarioPostagemDTO = usuarioPostagemDTO;
	}

	public UsuarioPostagemDTO getUsuario() {
		return usuarioPostagemDTO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Postagem other = (Postagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
