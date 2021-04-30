package com.example.cadastroUsuario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cadastroUsuario.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
