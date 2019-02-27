package br.com.bancopan.api.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bancopan.api.model.User;



@Service
public class UserService {

    public Iterable<User> findUser(Long cpf) {

        List<User> listaUsers =  new ArrayList<User>();
        List<User> user =  new ArrayList<User>();
        
        listaUsers.add(new User("Maria", (long) 123, (long) 30, "solteiro", "Rua x", (long) 10, (long) 111111111));
        listaUsers.add(new User("Joao", (long) 1234, (long) 31, "solteiro", "Rua y", (long) 11, (long) 111111112));
        listaUsers.add(new User("Rogerio", (long) 12345, (long) 32, "solteiro", "Rua z", (long) 12, (long) 111111113));
        listaUsers.add(new User("Mariana", (long) 1234567, (long) 33, "solteiro", "Rua w", (long) 13, (long) 111111114));
        listaUsers.add(new User("Marta", (long) 12345678, (long) 34, "solteiro", "Rua t", (long) 14, (long) 111111115));
    
        Iterator<User> aux = listaUsers.iterator();
        
        while(aux.hasNext()) {
        	
        	User us = aux.next();
        	if (us.getCpf().equals(cpf)) {
        		user.add(us);
        	}

        }
        
        return (Iterable<User>) user;
    }
}
