package br.com.bancopan.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancopan.api.model.Endereco;
import br.com.bancopan.api.services.EnderecoService;
import br.com.bancopan.api.exception.ApiException;

@RestController
@RequestMapping("bancopan/api/endereco")
public class EnderecoController {
	
	private static final Logger logger = LoggerFactory.getLogger(EnderecoController.class);
	
	@Autowired
	private EnderecoService enderecoService;

	/**
	 * API que retorna as informações do endereço de acordo com o CEP de entrada.
	 * @param cep
	 * @return ResponseEntity<Endereco>
	 * @throws Exception
	 */
    @RequestMapping(path = "/{cep}", method = RequestMethod.GET)
    public Endereco findEndereco(@PathVariable String cep) throws Exception {
    	logger.info("retornando o endereço do cep : " + cep);
    	
    	if (cep == null || cep.isEmpty() || !cep.matches("\\d{5}-\\d{3}")) {
    		throw new ApiException("CEP invalido");
    	}
    	
    	return enderecoService.findEndereco(cep);
    }
}
