package br.com.bancopan.api.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import br.com.bancopan.api.model.Estado;
import br.com.bancopan.api.model.EstadoMunicipio;
import br.com.bancopan.api.model.Municipios;

@Service
public class EstadoService {
	
	List<Estado> listaEstados =  new ArrayList<Estado>();
    List<EstadoMunicipio> listaEstadosMunicipios =  new ArrayList<EstadoMunicipio>();
	
	@PostConstruct
	public void init() {
		
        listaEstados.add(new Estado((long) 1,"Sao Paulo"));
        listaEstados.add(new Estado((long) 2,"Rio de Janeiro"));
        listaEstados.add(new Estado((long)3,"Acre"));
        listaEstados.add(new Estado((long)4,"Alagoas"));
        listaEstados.add(new Estado((long)5,"Amapa"));
        listaEstados.add(new Estado((long)6,"Amazonas"));
        listaEstados.add(new Estado((long)7,"Bahia"));
        listaEstados.add(new Estado((long)8,"Ceara"));
        listaEstados.add(new Estado((long)9,"Distrito Federal"));
        listaEstados.add(new Estado((long)10,"Espirito Santo"));
        listaEstados.add(new Estado((long)11,"Goias"));
        listaEstados.add(new Estado((long)12,"Maranhao"));
        listaEstados.add(new Estado((long)13,"Mato Grosso"));
        listaEstados.add(new Estado((long)14,"Mato Grosso do Sul"));
        listaEstados.add(new Estado((long)15,"Minas Gerais"));
        listaEstados.add(new Estado((long)16,"Para"));
        listaEstados.add(new Estado((long)17,"Paraiba"));
        listaEstados.add(new Estado((long)18,"Parana"));
        listaEstados.add(new Estado((long)19,"Pernambuco"));
        listaEstados.add(new Estado((long)20,"Piauí"));
        listaEstados.add(new Estado((long)21,"Rio Grande do Norte"));
        listaEstados.add(new Estado((long)22,"Rio Grande do Sul"));
        listaEstados.add(new Estado((long)23,"Rondonia"));
        listaEstados.add(new Estado((long)24,"Roraima"));
        listaEstados.add(new Estado((long)25,"Santa Catarina"));
        listaEstados.add(new Estado((long)26,"Sergipe"));
        listaEstados.add(new Estado((long)27,"Tocantins"));
        
        Iterator<Estado> aux = listaEstados.iterator();
        
        long idMunicipio = 1;
        
        while(aux.hasNext()) {
        	
        	Estado est = aux.next();
        	
        	idMunicipio = idMunicipio + 3;
            List<Municipios> listaMunicipios = new ArrayList<Municipios>();
            
            listaMunicipios.add(new Municipios( idMunicipio, est.getNome() + " - Municipio 1"));
            listaMunicipios.add(new Municipios( idMunicipio + 1,  est.getNome() + " - Municipio 2"));
            listaMunicipios.add(new Municipios( idMunicipio + 2,  est.getNome() + " - Municipio 3"));
            listaEstadosMunicipios.add(new EstadoMunicipio(est.getId(), listaMunicipios));
            
        }
        
	}
    
    public Iterable<Estado> findAll() {
    	
        return (Iterable<Estado>) listaEstados;
    }
    
    public EstadoMunicipio findMunicipio(Long idEstado) {
    	
    	EstadoMunicipio municipios = new EstadoMunicipio();
        
        Iterator<EstadoMunicipio> aux = listaEstadosMunicipios.iterator();
        
        while(aux.hasNext()) {
        	
        	EstadoMunicipio est = aux.next();
        	if (est.getIdEstado().equals(idEstado)) {
        		municipios = est;
        		break;
        	}

        }
        
        return municipios;
    }
}
