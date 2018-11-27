package com.paglione.repository;

import com.paglione.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}