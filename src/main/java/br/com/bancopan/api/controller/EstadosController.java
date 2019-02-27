package br.com.bancopan.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancopan.api.model.Estado;
import br.com.bancopan.api.model.EstadoMunicipio;
import br.com.bancopan.api.services.EstadoService;

@RestController
@RequestMapping("bancopan/api/estado")
public class EstadosController {
	
    @Autowired
    private EstadoService estadoService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Estado> findAll() throws Exception {
    	
    	return estadoService.findAll();
    }
    
    @RequestMapping(path = "/municipios/{idEstado}", method = RequestMethod.GET)
    public Iterable<EstadoMunicipio> findUser(@PathVariable Long idEstado) throws Exception {
    	
    	return estadoService.findMunicipio(idEstado);
    }
}
