package br.com.bancopan.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancopan.api.model.User;
import br.com.bancopan.api.services.UserService;

@RestController
@RequestMapping("bancopan/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping(path = "/{cpf}", method = RequestMethod.GET)
    public Iterable<User> findUser(@PathVariable Long cpf) throws Exception {
    	
    	return userService.findUser(cpf);
    }
    
}
