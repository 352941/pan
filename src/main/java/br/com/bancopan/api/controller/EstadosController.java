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
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Estado>> findAll() throws Exception {
    	logger.info("retornando todos os estados");
    	if (estadoService.findAll() == null) {
    		throw new ApiException("Não existem estados cadastrados");
    	}
    	return new ResponseEntity<Iterable<Estado>>(estadoService.findAll(), HttpStatus.OK);
    }
    
    @RequestMapping(path = "/municipios/{idEstado}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Municipios>> findUser(@PathVariable Long idEstado) throws Exception {
    	logger.info("retornando todos os municipios do estado de id : " + idEstado);
    	Iterable<Municipios> listMunicipios = estadoService.findMunicipio(idEstado);
    	if (listMunicipios == null) {
    		throw new ApiException("Não existe municipios para o ID informado");
    	}
    	return new ResponseEntity<Iterable<Municipios>>(listMunicipios, HttpStatus.OK);
    }
}
