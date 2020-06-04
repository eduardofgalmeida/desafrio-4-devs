package com.almeida.feedback.service;

import java.util.List;

import com.almeida.feedback.model.Clientes;

public interface FeedbackService {
    List<Clientes> findAll();
    Clientes findById(long id);
    Clientes save(Clientes clientes);
    
    
}
