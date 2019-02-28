package br.com.bancopan.api.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import br.com.bancopan.api.model.Endereco;

@Service
public class EnderecoService {

	List<Endereco> listaEndereco =  new ArrayList<Endereco>();
	
	@PostConstruct
	public void init() {
		
        listaEndereco.add(new Endereco((long)1,"Rua x"));
        listaEndereco.add(new Endereco((long)2,"Rua y"));
        listaEndereco.add(new Endereco((long)3,"Rua z"));
        listaEndereco.add(new Endereco((long)4,"Rua w"));
        
	}
	
    public Endereco findEndereco(Long cep) {
       
        Endereco endereco = new Endereco();

        Iterator<Endereco> aux = listaEndereco.iterator();
        
        while(aux.hasNext()) {
        	
        	Endereco end = aux.next();
        	if (end.getCep().equals(cep)) {
        		endereco = end;
        		break;
        	}

        }
        
        return endereco;
    }
    
}
