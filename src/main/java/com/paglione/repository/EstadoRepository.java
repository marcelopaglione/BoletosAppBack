package com.paglione.repository;

import com.paglione.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}