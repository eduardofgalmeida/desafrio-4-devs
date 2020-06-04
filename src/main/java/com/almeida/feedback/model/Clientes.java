package com.almeida.feedback.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
	@Column(name = "ID")
	private Long id;
	
	@NotBlank
	@Column(name = "NOME")
	private String nome;
	
	@NotBlank
	@Column(name = "NOME_RESPONSAVEL")
	private String nomeResponsavel;
	
	@Column(name = "CNPJ", unique=true)
	private BigInteger cnpj;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	@Column(name = "DT_CADASTRO")
	private LocalDate dtCadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public BigInteger getCnpj() {
		return cnpj;
	}

	public void setCnpj(BigInteger cnpj) {
		this.cnpj = cnpj;
	}

	public LocalDate getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(LocalDate dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	


}
