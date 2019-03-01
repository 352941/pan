package br.com.bancopan.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancopan.api.exception.ApiException;
import br.com.bancopan.api.model.Estado;
import br.com.bancopan.api.model.Municipios;
import br.com.bancopan.api.services.EstadoService;

@RestController
@RequestMapping("bancopan/api/estado")
public class EstadosController {
	
	private static final Logger logger = LoggerFactory.getLogger(EstadosController.class);
	
    @Autowired
    private EstadoService estadoService;
    
    /**
     * API que busca e retorna a lista de estados
     * @return ResponseEntity<Iterable<Estado>>
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Estado>> findAll() throws Exception {
    	logger.info("retornando todos os estados");
    	if (estadoService.findAll() == null) {
    		throw new ApiException("Não existem estados cadastrados");
    	}
    	
    	logger.info("retornando todos os estados" + estadoService.findAll());
    	return new ResponseEntity<Iterable<Estado>>(estadoService.findAll(), HttpStatus.OK);
    }
    
    /**
     * API que busca e retorna a lista de municipios de acordo com o ID do estado de entrada.
     * @param idEstado
     * @return ResponseEntity<Iterable<Municipios>>
     * @throws Exception
     */
    @RequestMapping(path = "/municipios/{idEstado}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Municipios>> findUser(@PathVariable Long idEstado) throws Exception {
    	logger.info("retornando todos os municipios do estado de id : " + idEstado);
    	List<Municipios> listMunicipios = (List<Municipios>) estadoService.findMunicipio(idEstado);
    	logger.info("retornando todos os municipios do estado de id : " + listMunicipios);
    	if (listMunicipios == null || listMunicipios.isEmpty()) {
    		throw new ApiException("Não existe municipios para o ID informado");
    	}
    	return new ResponseEntity<Iterable<Municipios>>(listMunicipios, HttpStatus.OK);
    }
}
