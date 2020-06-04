package com.almeida.feedback.controllers;

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

import com.almeida.feedback.model.Avaliacoes;
import com.almeida.feedback.model.ValidationModel;
import com.almeida.feedback.repository.AvaliacoesRepository;

@Controller
public class CadastroAvaliacoesController {
	
	@Autowired
	AvaliacoesRepository avaliacoesRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(CadastroValidationController.class);
	
    @RequestMapping("/")
    public String index(){
        return "index";
    }
	
	@RequestMapping(value="/cadastroavaliacoes", method=RequestMethod.GET)
    public ModelAndView carregaAvaliacoes(){
        ModelAndView mv = new ModelAndView("cadastroavaliacoes");
        List<Avaliacoes> avaliacoesAll = avaliacoesRepository.findAll();
        mv.addObject("cadastroavaliacoes", avaliacoesAll);
        return mv;
    }
	
	
	@RequestMapping(value="/salvaravaliacoes", method=RequestMethod.POST)
	public String saveAvaliacoes(@Valid Avaliacoes avaliacoesModel, BindingResult result, RedirectAttributes attributes) {
		try {
		if(result.hasErrors()) {
			 attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
	            return "redirect:/cadastroavaliacoes";
	        }
	        avaliacoesRepository.save(avaliacoesModel);
		} catch (Exception e) {
			logger.error("salvaravaliacoes: " + e.toString());
		}
	        return "redirect:/cadastroavaliacoes";
	
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listaavaliacoes")
	public ModelAndView listaAvaliacoes() {
		
		ModelAndView modelAndView = new ModelAndView("cadastrovalidation");
		Iterable<Avaliacoes> avaliacoes = avaliacoesRepository.findAll();
		modelAndView.addObject("listaavaliacoes", avaliacoes);
		return modelAndView;
	}
	

}
