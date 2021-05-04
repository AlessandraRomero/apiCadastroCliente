package com.example.cadastroUsuario.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastroUsuario.entities.User;
import com.example.cadastroUsuario.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	private Logger logger = LoggerFactory.getLogger(UserResource.class);
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
	User obj = service.findById(id);
	return ResponseEntity.ok().body(obj);
    }
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody @Valid User obj){
		obj = service.insert(obj);
		logger.info(obj.toString());
		return ResponseEntity.created(null).body(obj);
        
	}

	@GetMapping(value = "/{id}/address")
	public ResponseEntity<User>findAddress(@PathVariable Long id) {
	User obj = service.findById(id);
	return ResponseEntity.ok().body(obj);
    }
	
 }
