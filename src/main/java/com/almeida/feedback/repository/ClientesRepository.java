package com.almeida.feedback.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.almeida.feedback.model.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {

	@Query("select c from Clientes c where c.nome like %?1%")
	List<Clientes> findClientesByNome(String Nome) throws Exception;

}
