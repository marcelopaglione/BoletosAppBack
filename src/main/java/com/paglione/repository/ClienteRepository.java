package com.paglione.repository;

import com.paglione.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}