package com.paglione.repository;

import com.paglione.entity.Emissor;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface EmissorRepository extends JpaRepository<Emissor, Long> {

}