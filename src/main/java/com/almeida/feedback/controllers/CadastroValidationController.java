package com.almeida.feedback.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.almeida.feedback.model.Clientes;
import com.almeida.feedback.model.ValidationModel;
import com.almeida.feedback.repository.ValidationRepository;

import io.swagger.annotations.ApiOperation;

@Controller
public class CadastroValidationController {
	
	@Autowired
	ValidationRepository validationRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(CadastroValidationController.class);
	
	@RequestMapping(value="/cadastrovalidation", method=RequestMethod.GET)
    public ModelAndView carregaValidation(){
        ModelAndView mv = new ModelAndView("cadastrovalidation");
        List<ValidationModel> validationAll = validationRepository.findAll();
        mv.addObject("cadastrovalidation", validationAll);
        return mv;
    }
	
	@RequestMapping(value="/salvarvalidation", method=RequestMethod.POST)
	public String savePost(@Valid ValidationModel validationModel, BindingResult result, RedirectAttributes attributes) {
		try {
		if(result.hasErrors()) {
			 attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
	            return "redirect:/cadastrovalidation";
	        }
	        validationRepository.save(validationModel);
		} catch (Exception e) {
			logger.error("salvarvalidation: " + e.toString());
		}
	        return "redirect:/salvarvalidation";
	
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listavalidation")
	public ModelAndView listaValidation() {
		
		ModelAndView modelAndView = new ModelAndView("cadastrovalidation");
		Iterable<ValidationModel> validation = validationRepository.findAll();
		modelAndView.addObject("listavalidation", validation);
		return modelAndView;
	}
	
	
	

}
