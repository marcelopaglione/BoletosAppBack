package com.paglione.repository;

import com.paglione.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}