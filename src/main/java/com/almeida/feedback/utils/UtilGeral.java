package com.almeida.feedback.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.almeida.feedback.model.ValidationModel;
import com.almeida.feedback.repository.ValidationRepository;

@Component
public class UtilGeral {
	
	@Autowired
	private ValidationRepository validationRepository;
	
	public Boolean CheckValidation(String codValidation) {
		
		Boolean v = false;
		try {
			List<ValidationModel> validation = validationRepository.findByCodValidationAndSituacao(codValidation, "A");
			
			if (validation != null) {
				if (validation.size() > 0) {
					v = true;
				}
			}
		}catch (Exception e) {
		
		}
		return v;
		
	}
	
	

}
