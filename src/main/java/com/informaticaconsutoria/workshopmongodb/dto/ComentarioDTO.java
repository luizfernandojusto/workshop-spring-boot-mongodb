package com.informaticaconsutoria.workshopmongodb.dto;

import java.io.Serializable;
import java.util.Date;

public class ComentarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String texto;
	private Date data;

	private UsuarioDTO usuarioDTO;

	public ComentarioDTO() {

	}

	public ComentarioDTO(String texto, Date data, UsuarioDTO usuarioDTO) {
		super();
		this.texto = texto;
		this.data = data;
		this.usuarioDTO = usuarioDTO;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

}
