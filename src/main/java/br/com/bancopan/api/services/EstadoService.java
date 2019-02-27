package br.com.bancopan.api.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bancopan.api.model.Estado;
import br.com.bancopan.api.model.EstadoMunicipio;
import br.com.bancopan.api.model.Municipios;

@Service
public class EstadoService {
    
    public Iterable<Estado> findAll() {

        List<Estado> listaEstados =  new ArrayList<Estado>();
        
        listaEstados.add(new Estado((long)1,"Sao Paulo"));
        listaEstados.add(new Estado((long)2,"Rio de Janeiro"));
        listaEstados.add(new Estado((long)3,"Minas Gerais"));
    
        return (Iterable<Estado>) listaEstados;
    }
    
    public Iterable<EstadoMunicipio> findMunicipio(Long idEstado) {
    	
        List<EstadoMunicipio> listaEstadosMunicipios =  new ArrayList<EstadoMunicipio>();
        List<Municipios> listaMunicipios = new ArrayList<Municipios>();
        List<EstadoMunicipio> municipios = new ArrayList<EstadoMunicipio>();

        listaMunicipios.add(new Municipios((long) 1, "Sao Paulo"));
        listaMunicipios.add(new Municipios((long) 2, "Diadema"));
        listaMunicipios.add(new Municipios((long) 3, "Sao Bernardo"));
        listaEstadosMunicipios.add(new EstadoMunicipio((long) 1, listaMunicipios));
        
        List<Municipios> listaMunicipios2 = new ArrayList<Municipios>();
        listaMunicipios2.add(new Municipios((long) 4, "Municipio X"));
        listaMunicipios2.add(new Municipios((long) 5, "Municipio Y"));
        listaMunicipios2.add(new Municipios((long) 6, "Municipio Z"));
        
        listaEstadosMunicipios.add(new EstadoMunicipio((long) 2, listaMunicipios2));
        
        List<Municipios> listaMunicipios3 = new ArrayList<Municipios>();
        listaMunicipios3.add(new Municipios((long) 7, "Municipio W"));
        listaMunicipios3.add(new Municipios((long) 8, "Municipio O"));
        listaMunicipios3.add(new Municipios((long) 9, "Municipio P"));
        
        listaEstadosMunicipios.add(new EstadoMunicipio((long) 3, listaMunicipios3));
        
        Iterator<EstadoMunicipio> aux = listaEstadosMunicipios.iterator();
        
        while(aux.hasNext()) {
        	
        	EstadoMunicipio est = aux.next();
        	if (est.getIdEstado().equals(idEstado)) {
        		municipios.add(est);
        	}

        }
        
        return (Iterable<EstadoMunicipio>) municipios;
    }
}
