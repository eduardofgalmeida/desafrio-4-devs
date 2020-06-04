package com.almeida.feedback.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name="TB_AVALIACOES")
public class Avaliacoes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	@Column(name = "MES_ANO")
	private LocalDate mesAno;
	

	@Column(name = "CLIENTES_AVALIACAO")
	private String clientesAvaliacao;
	
	@Column(name = "avaliacao")
	private Integer avaliacao;
	
	@NotNull
	@Lob
	@Column(name = "MOT_AVALIACAO")
	private String motAvaliacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getMesAno() {
		return mesAno;
	}

	public void setMesAno(LocalDate mesAno) {
		this.mesAno = mesAno;
	}

	public String getClientesAvaliacao() {
		return clientesAvaliacao;
	}

	public void setClientesAvaliacao(String clientesAvaliacao) {
		this.clientesAvaliacao = clientesAvaliacao;
	}

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getMotAvaliacao() {
		return motAvaliacao;
	}

	public void setMotAvaliacao(String motAvaliacao) {
		this.motAvaliacao = motAvaliacao;
	}

}