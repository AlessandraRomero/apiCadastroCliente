package com.example.cadastroUsuario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cadastroUsuario.entities.Address;
import com.example.cadastroUsuario.entities.User;
import com.example.cadastroUsuario.repositories.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repository;
	
	public List<Address> findAll(){
		return repository.findAll();
	}
	
	public Address findById(Long id) {
		Optional<Address> obj = repository.findById(id);
		return obj.get();
	}
	
	public Address insert(Address obj) {
		return repository.save(obj);
	}
}
