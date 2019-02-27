package br.com.bancopan.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancopan.api.model.Endereco;
import br.com.bancopan.api.services.EnderecoService;

@RestController
@RequestMapping("bancopan/api/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;

    @RequestMapping(path = "/{cep}", method = RequestMethod.GET)
    public Iterable<Endereco> findEndereco(@PathVariable Long cep) throws Exception {
    	
    	return enderecoService.findEndereco(cep);
    }
}
