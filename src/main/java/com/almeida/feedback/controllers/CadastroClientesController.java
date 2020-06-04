package com.almeida.feedback.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.almeida.feedback.model.Clientes;
import com.almeida.feedback.repository.ClientesRepository;

import javassist.bytecode.stackmap.BasicBlock.Catch;

@Controller
public class CadastroClientesController {

	
	private List<Clientes> ltClientes;
	
	
	private Clientes clientesModel;

	@Autowired
	private ClientesRepository clientesRepository;

	private BigDecimal idClientes;
	
	private static final Logger logger = LoggerFactory.getLogger(CadastroClientesController.class);

    @RequestMapping(value="/cadastroclientes", method=RequestMethod.GET)
    public ModelAndView carregaClientes(){
        ModelAndView mv = new ModelAndView("cadastroclientes");
        List<Clientes> clientesAll = clientesRepository.findAll();
        mv.addObject("cadastroclientes", clientesAll);
        return mv;
       
    }
	
	@PostMapping("**/pesquisarcliente")
	public ModelAndView pesquisar(@RequestParam("nomepesquisa") String nomepesquisa) throws Exception {
		ModelAndView modelAndView = new ModelAndView("cadastroclientes");
		modelAndView.addObject("listaclientes", clientesRepository.findClientesByNome(nomepesquisa));
		modelAndView.addObject("clientebj", new Clientes());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listaclientes")
	public ModelAndView listaClientes() {
		
		ModelAndView modelAndView = new ModelAndView("cadastroclientes");
		Iterable<Clientes> clientesIt = clientesRepository.findAll();
		modelAndView.addObject("listaclientes", clientesIt);
		return modelAndView;
	}

	@RequestMapping(value="/salvarcliente", method=RequestMethod.POST)
	public String savePost(@Valid Clientes clientesModel, BindingResult result, RedirectAttributes attributes) {
		try {
		if(result.hasErrors()) {
			 attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
	            return "redirect:/cadastroclientes";
	        }
	        clientesModel.setDtCadastro(LocalDate.now());
	        clientesRepository.save(clientesModel);
		} catch (Exception e) {
			logger.error("allCodEmp: " + e.toString());
		}
	        return "redirect:/cadastroclientes";
	
	}
	
//	@GetMapping("editarcliente/{idcliente}")
//	public ModelAndView editar(@PathVariable("idcliente") Long idcliente) {
//		Optional<Clientes> cliente = clientesRepository.findById(idcliente);
//		
//		ModelAndView modelAndView = new ModelAndView("cadastroclientes");
//		modelAndView.addObject("clienteobj", cliente.get());
//		return modelAndView;
//	}
	
}
