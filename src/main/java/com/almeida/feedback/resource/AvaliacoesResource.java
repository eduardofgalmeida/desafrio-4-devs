package com.almeida.feedback.resource;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.almeida.feedback.model.Avaliacoes;
import com.almeida.feedback.model.Clientes;
import com.almeida.feedback.repository.AvaliacoesRepository;
import com.almeida.feedback.service.FeedbackService;
import com.almeida.feedback.utils.UtilGeral;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Avaliações")
public class AvaliacoesResource {
	
	@Autowired
	AvaliacoesRepository avaliacoesRepository;
	
	@Autowired
	private UtilGeral utilGeral;
	
	private static final Logger logger = LoggerFactory.getLogger(AvaliacoesResource.class);

	
	
	@ResponseBody
	@GetMapping("/avaliacoes/validation/{codValidation}")
	@ApiOperation(value = "Retorna todas as avaliações")
	public List<Avaliacoes> avaliacoesAll(String codValidation) throws Exception {

		List<Avaliacoes> ltResult = null;

		try {
			Boolean validation = utilGeral.CheckValidation(codValidation);
			if (validation) {
				ltResult = avaliacoesRepository.findAll();
			}
		} catch (Exception e) {
			logger.error("avaliacoesAll: {}", e.toString());
		}

		return ltResult;

	}
	
	@ApiOperation(value = "Cadastra uma avaliação")
	@PostMapping("/avaliacoes/validation/{codValidation}")
	public Avaliacoes cadastraAvaliacao(@RequestBody @Valid Avaliacoes avaliacoes, String codValidation) {

		Avaliacoes result = new Avaliacoes();

		Boolean validation = utilGeral.CheckValidation(codValidation);
		try {
			if (validation) {
				result = avaliacoesRepository.save(avaliacoes);
			}
		} catch (Exception e) {
			logger.error("cadastraAvaliacao: {}", e.toString());
		}

		return result;

	}

	@ApiOperation(value = "Deleta uma avaliação")
	@DeleteMapping("/avaliacoes/validation/{codValidation}")
	public void deletaAvaliacao(@RequestBody @Valid Avaliacoes avaliacoes, String codValidation) {

		Boolean validation = utilGeral.CheckValidation(codValidation);
		try {
			if (validation) {
				avaliacoesRepository.delete(avaliacoes);
			}
		} catch (Exception e) {
			logger.error("deletaAvaliacao: {}", e.toString());
		}

	}

	@ApiOperation(value = "Atualiza uma avaliação")
	@PutMapping("/avaliacoes/validation/{codValidation}")
	public Avaliacoes atualizaAvaliacoes(@RequestBody @Valid Avaliacoes avaliacoes, String codValidation) {
		Avaliacoes result = new Avaliacoes();

		Boolean validation = utilGeral.CheckValidation(codValidation);
		try {
			if (validation) {
				result = avaliacoesRepository.save(avaliacoes);

			}
		} catch (Exception e) {
			logger.error("atualizaAvaliacoes: {}", e.toString());
		}

		return result;
	
	}
	
}
