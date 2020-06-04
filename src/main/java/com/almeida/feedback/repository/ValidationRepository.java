package com.almeida.feedback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.almeida.feedback.model.ValidationModel;

@Repository
public interface ValidationRepository extends JpaRepository<ValidationModel, Long>{
		
	List<ValidationModel> findByCodValidationAndSituacao (String codValidation, String situacao) throws Exception;
	
	
}
