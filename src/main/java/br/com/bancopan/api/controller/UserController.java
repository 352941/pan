package br.com.bancopan.api.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancopan.api.exception.ApiException;
import br.com.bancopan.api.model.Response;
import br.com.bancopan.api.model.User;
import br.com.bancopan.api.services.UserService;

@RestController
@RequestMapping("bancopan/api/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    
    /**
     * API que busca a retorna as informações do usuario de acordo com o CPF
     * @param cpf
     * @return ResponseEntity<User>
     * @throws Exception
     */
    @RequestMapping(path = "/{cpf}", method = RequestMethod.GET)
    public ResponseEntity<User> findUser(@PathVariable Long cpf) throws Exception {
    	logger.info("retornando as informações do usuario do cpf : " + cpf);
    	User user = userService.findUser(cpf);
    	
    	if (user == null || user.getCpf() == null ) {
    		throw new ApiException("Cpf não existe");
    	}
    	
    	return new ResponseEntity<User> (userService.findUser(cpf), HttpStatus.OK);
    }
    
    /**
     * API que atualiza a informações de endereço do usuario
     * @param user
     * @return ResponseEntity<Response>
     * @throws Exception
     */
    @RequestMapping(path = "/update", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Response> updateUser(@Valid @RequestBody User user) throws Exception {
    	logger.info("atualizando as informações do usuario do cpf : " + user.getCpf());
    	User userUpdate = userService.updateUser(user);
    	
    	if (userUpdate == null || userUpdate.getCpf() == null ) {
    		throw new ApiException("Cpf não existe");
    	}
    	
    	return new ResponseEntity<Response> (new Response(HttpStatus.OK.value(), "cpf atualizado com sucesso"), HttpStatus.OK);
    }
    
}
