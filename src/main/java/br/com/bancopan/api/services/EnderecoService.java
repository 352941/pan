package br.com.bancopan.api.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.bancopan.api.model.Endereco;

@Service
public class EnderecoService {
	
	/**
	 * Metodo que recebe o cep como parametro de entrada e retorna o endereço executando a API do viacep.
	 * @param cep
	 * @return Endereco ou NULL caso não localize o endereço.
	 */
    public Endereco findEndereco(String cep) {
       
        Endereco endereco = new Endereco();
        
        RestTemplate restTemplate = new RestTemplate();
    	
        endereco = restTemplate.getForEntity("https://viacep.com.br/ws/" + cep +"/json",
    			Endereco.class).getBody();
        return endereco;
    }
    
}
