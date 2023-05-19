package com.webfluxapirest.app.service;

import com.webfluxapirest.app.models.Categoria;
import com.webfluxapirest.app.models.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {

	public Flux<Producto> findAll();
	
	public Flux<Producto> findAllConNombre();
	
	public Flux<Producto> findAllConNombreUpperRepeat();
	
	public Mono<Producto> findById(String id);
	
	public Mono<Producto> save(Producto producto);
	
	public Mono<Void> delete(Producto producto);
	
	public Flux<Categoria> findAllCategoria();
	
	public Mono<Categoria> findCategoriaById(String id);
	
	public Mono<Categoria> saveCategoria(Categoria categoria);
}
