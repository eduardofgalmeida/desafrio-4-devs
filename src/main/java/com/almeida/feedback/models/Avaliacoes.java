package com.almeida.feedback.models;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name="TB_AVALIACOES")
public class Avaliacoes {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate mes_ano;
	
	@NotBlank
	private String clientes_avaliacao;
	
	@NotBlank
	private Integer avaliacao;
	
	@NotNull
	@Lob
	private String mot_avaliacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getMes_ano() {
		return mes_ano;
	}

	public void setMes_ano(LocalDate mes_ano) {
		this.mes_ano = mes_ano;
	}

	public String getClientes_avaliacao() {
		return clientes_avaliacao;
	}

	public void setClientes_avaliacao(String clientes_avaliacao) {
		this.clientes_avaliacao = clientes_avaliacao;
	}

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getMot_avaliacao() {
		return mot_avaliacao;
	}

	public void setMot_avaliacao(String mot_avaliacao) {
		this.mot_avaliacao = mot_avaliacao;
	}
	
	
}