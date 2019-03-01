package br.com.bancopan.api.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.bancopan.api.model.Estado;
import br.com.bancopan.api.model.Municipios;

@Service
public class EstadoService {
	
	List<Estado> listaEstados =  new ArrayList<Estado>();
    
	/**
	 * Metodo que iniciliza e popula a lista de estados.
	 */
	@PostConstruct
	public void init() {
		
    	RestTemplate restTemplate = new RestTemplate();
    	
    	listaEstados = Arrays.asList(restTemplate.getForEntity("https://servicodados.ibge.gov.br/api/v1/localidades/estados/",
                Estado[].class).getBody());
        
	}
    
	/**
	 * Metodo que busca e retorna a lista de estados.
	 * @return lista de estados
	 */
    public Iterable<Estado> findAll() {
 		
        return (Iterable<Estado>) listaEstados;
    }
    
    /**
     * Metodo que recebe o Id do estado e busca os municipios executando uma API do governo e retornando a informação.
     * caso contrario, é retornando um objeto nulo.
     * @param idEstado
     * @return objeto Estado
     */
    public Iterable<Municipios> findMunicipio(Long idEstado) {
    	
    	List<Municipios> listaMunicipios =  new ArrayList<Municipios>();
    	
    	RestTemplate restTemplate = new RestTemplate();
    	
    	listaMunicipios = Arrays.asList(restTemplate.getForEntity("https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + idEstado +"/municipios",
    			Municipios[].class).getBody());
    	
        return (Iterable<Municipios>) listaMunicipios;
    }
}
