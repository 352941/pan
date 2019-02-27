package br.com.bancopan.api.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bancopan.api.model.Endereco;

@Service
public class EnderecoService {

    public Iterable<Endereco> findEndereco(Long cep) {

        List<Endereco> listaEndereco =  new ArrayList<Endereco>();
        List<Endereco> endereco =  new ArrayList<Endereco>();
        
        listaEndereco.add(new Endereco((long)1,"Rua x"));
        listaEndereco.add(new Endereco((long)2,"Rua y"));
        listaEndereco.add(new Endereco((long)3,"Rua z"));
        listaEndereco.add(new Endereco((long)4,"Rua w"));
    
        Iterator<Endereco> aux = listaEndereco.iterator();
        
        while(aux.hasNext()) {
        	
        	Endereco end = aux.next();
        	if (end.getCep().equals(cep)) {
        		endereco.add(end);
        	}

        }
        
        return (Iterable<Endereco>) endereco;
    }
    
}
