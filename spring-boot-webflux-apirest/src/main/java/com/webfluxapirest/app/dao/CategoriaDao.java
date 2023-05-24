package com.webfluxapirest.app.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.webfluxapirest.app.models.Categoria;

public interface CategoriaDao extends ReactiveMongoRepository<Categoria, String>{

}
