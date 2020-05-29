package com.almeida.feedback.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="TB_CLIENTES") 
public class Clientes implements Serializable{ 
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	private String nome_cliente;
	
	@NotBlank
	private String nome_responsavel;
	
	@Column(unique=true)
	private BigInteger cnpj;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private LocalDate dt_cadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getNome_responsavel() {
		return nome_responsavel;
	}

	public void setNome_responsavel(String nome_responsavel) {
		this.nome_responsavel = nome_responsavel;
	}

	public BigInteger getCnpj() {
		return cnpj;
	}

	public void setCnpj(BigInteger cnpj) {
		this.cnpj = cnpj;
	}

	public LocalDate getDt_cadastro() {
		return dt_cadastro;
	}

	public void setDt_cadastro(LocalDate dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}
	
    
	
	

}
