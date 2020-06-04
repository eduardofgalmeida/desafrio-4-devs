package com.almeida.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.almeida.feedback.model.Avaliacoes;

@Repository
public interface AvaliacoesRepository extends JpaRepository<Avaliacoes, Long> {

}
