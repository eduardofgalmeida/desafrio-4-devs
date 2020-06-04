package com.almeida.feedback.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.almeida.feedback.model.Avaliacoes;
import com.almeida.feedback.model.ValidationModel;
import com.almeida.feedback.repository.AvaliacoesRepository;

@Controller
public class CadastroAvaliacoesController {
	
	@Autowired
	AvaliacoesRepository avaliacoesRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(CadastroValidationController.class);
	
	@RequestMapping(value="/cadastroavaliacoes", method=RequestMethod.GET)
    public ModelAndView carregaAvaliacoes(){
        ModelAndView mv = new ModelAndView("cadastroavaliacoes");
        List<Avaliacoes> avaliacoesAll = avaliacoesRepository.findAll();
        mv.addObject("cadastroavaliacoes", avaliacoesAll);
        return mv;
    }

}
