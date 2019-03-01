package br.com.bancopan.api.services;

import java.util.HashMap;


import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import br.com.bancopan.api.model.User;



@Service
public class UserService {
	
    HashMap<Long, User> mapUser = new  HashMap<Long, User>();
    
	/**
	 * Metodo que iniciliza e popula o HashMap contendo as informações de Usuarios
	 */
	@PostConstruct
	public void init() {
		
		mapUser.put((long) 123, new User("Maria", (long) 123, (long) 30, "solteiro", "Rua x", (long) 10, (long) 111111111));
		mapUser.put((long) 1234, new User("Joao", (long) 1234, (long) 31, "solteiro", "Rua y", (long) 11, (long) 111111112));
		mapUser.put((long) 12345, new User("Rogerio", (long) 12345, (long) 32, "solteiro", "Rua z", (long) 12, (long) 111111113));
		mapUser.put((long) 1234567,new User("Mariana", (long) 1234567, (long) 33, "solteiro", "Rua w", (long) 13, (long) 111111114));
		mapUser.put((long) 12345678, new User("Marta", (long) 12345678, (long) 34, "solteiro", "Rua t", (long) 14, (long) 111111115));
               
	}
	
	/**
	 * Metodo que recebe o cpf do usuario, busca as informações do usuario no HashMap, caso encontre, retorna as informações
	 * do usuario, caso contrario, retorna um objeto nulo.
	 * @param cpf
	 * @return objeto User
	 */
    public User findUser(Long cpf) {

        User user = new User();
        
        if (mapUser.containsKey(cpf)) {
        	user = mapUser.get(cpf);
        }
        
        return user;
    }
    
    /**
     * Metodo que recebe o endereço do usuario a ser atualizado.
     * Localiza o usuario no hashMap, caso encontre atualiza o endereço e retorna o usuario com as informações atualizadas,
     * caso contrario, retorna o nulo.
     * @param user
     * @return objeto user
     */
    public User updateUser(User user) {
    	
    	if (mapUser.containsKey(user.getCpf())) {
    		User aux  = mapUser.get(user.getCpf());
    		aux.setEndereço(user.getEndereço());
    		aux.setNumero(user.getNumero());
    		
    		mapUser.replace(user.getCpf(), aux);
    		
    		return aux;
    		
    	} 
   
       return null; 
    }
}
