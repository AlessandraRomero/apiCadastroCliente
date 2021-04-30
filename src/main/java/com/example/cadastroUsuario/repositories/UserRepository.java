package com.example.cadastroUsuario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cadastroUsuario.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
