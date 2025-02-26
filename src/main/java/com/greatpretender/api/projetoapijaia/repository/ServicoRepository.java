package com.greatpretender.api.projetoapijaia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatpretender.api.projetoapijaia.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

    Optional<Servico> findByNome(String nome);
    
}
