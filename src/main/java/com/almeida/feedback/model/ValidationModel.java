package com.almeida.feedback.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="TB_VALIDATION")
public class ValidationModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "ID_VALIDATION")
	private Long idValidation;
	
	@NotBlank
	@Column(name = "COD_VALIDATION")
	private String codValidation;
	
	@NotBlank
	@Column(name = "SITUACAO")
	private String situacao;

	public Long getIdValidation() {
		return idValidation;
	}

	public void setIdValidation(Long idValidation) {
		this.idValidation = idValidation;
	}

	public String getCodValidation() {
		return codValidation;
	}

	public void setCodValidation(String codValidation) {
		this.codValidation = codValidation;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}


}
