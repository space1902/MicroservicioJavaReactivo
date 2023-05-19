package com.webfluxapirest.app.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.webfluxapirest.app.models.Producto;

public interface ProductoDao extends ReactiveMongoRepository<Producto, String>{

	
}
