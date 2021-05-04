package com.example.cadastroUsuario.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastroUsuario.entities.Address;
import com.example.cadastroUsuario.entities.User;
import com.example.cadastroUsuario.repositories.AddressRepository;
import com.example.cadastroUsuario.repositories.UserRepository;
import com.example.cadastroUsuario.services.AddressService;
import com.example.cadastroUsuario.services.UserService;

@RestController
@RequestMapping(value = "/address")
public class AddressResource {

	@Autowired
	private AddressService service;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@GetMapping
	public ResponseEntity<List<Address>> findAll() {
		List<Address> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Address> findById(@PathVariable Long id) {
		Address obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Address> insert(@Valid @RequestBody Address obj) {
		obj = service.insert(obj);
		return ResponseEntity.created(null).body(obj);

	}

	@PutMapping("/{address_id}/users/{user_id}")
	Address assignAddressToUser(@Valid @PathVariable Long address_id, @PathVariable Long user_id) {
		Address address = addressRepository.findById(address_id).get();
		User user = userRepository.findById(user_id).get();
		address.setUser(user);
		return addressRepository.save(address);

	}
}