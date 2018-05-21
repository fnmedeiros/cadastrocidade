package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.modelo.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, String>{
	
}
