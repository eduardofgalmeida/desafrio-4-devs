package com.almeida.feedback.resource;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.almeida.feedback.model.Clientes;
import com.almeida.feedback.repository.ClientesRepository;
import com.almeida.feedback.utils.UtilGeral;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Clientes")
public class ClientesResource {

	@Autowired
	private ClientesRepository clientesRepository;

	@Autowired
	private UtilGeral utilGeral;

	private static final Logger logger = LoggerFactory.getLogger(ClientesResource.class);

	@ResponseBody
	@GetMapping("/clientes/validation/{codValidation}")
	@ApiOperation(value = "Retorna todos os dados dos clientes")
	public List<Clientes> clientesAll(String codValidation) throws Exception {

		List<Clientes> ltResult = null;

		try {
			Boolean validation = utilGeral.CheckValidation(codValidation);
			if (validation) {
				ltResult = clientesRepository.findAll();
			}
		} catch (Exception e) {
			logger.error("clientesAll: {}", e.toString());
		}

		return ltResult;

	}

	@ResponseBody
	@GetMapping("/clientes/validation/{codValidation}/findnome/{findnome}")
	@ApiOperation(value = "Retorna o filtro de clientes por nome")
	public List<Clientes> clientesPorNome(String codValidation, String Nome) throws Exception {

		List<Clientes> ltResult = null;

		Boolean validation = utilGeral.CheckValidation(codValidation);
		try {
			if (validation) {
				ltResult = clientesRepository.findClientesByNome(Nome);
			}
		} catch (Exception e) {
			logger.error("clientesPorNome: {}", e.toString());
		}

		return ltResult;

	}

	@ApiOperation(value = "Cadastra um cliente")
	@PostMapping("/clientes/validation/{codValidation}")
	public Clientes cadastraCliente(@RequestBody @Valid Clientes clientes, String codValidation) {

		Clientes result = new Clientes();

		Boolean validation = utilGeral.CheckValidation(codValidation);
		try {
			if (validation) {
				result = clientesRepository.save(clientes);
			}
		} catch (Exception e) {
			logger.error("cadastraCliente: {}", e.toString());
		}

		return result;

	}

	@ApiOperation(value = "Deleta um Cliente")
	@DeleteMapping("/clientes/validation/{codValidation}")
	public void deletaCliente(@RequestBody @Valid Clientes clientes, String codValidation) {

		Boolean validation = utilGeral.CheckValidation(codValidation);
		try {
			if (validation) {
				clientesRepository.delete(clientes);
			}
		} catch (Exception e) {
			logger.error("deletaCliente: {}", e.toString());
		}

	}

	@ApiOperation(value = "Atualiza um Cliente")
	@PutMapping("/clientes/validation/{codValidation}")
	public Clientes atualizaProduto(@RequestBody @Valid Clientes Clientes, String codValidation) {
		Clientes result = new Clientes();

		Boolean validation = utilGeral.CheckValidation(codValidation);
		try {
			if (validation) {
				result = clientesRepository.save(Clientes);

			}
		} catch (Exception e) {
			logger.error("atualizaProduto: {}", e.toString());
		}

		return result;
	}

}
