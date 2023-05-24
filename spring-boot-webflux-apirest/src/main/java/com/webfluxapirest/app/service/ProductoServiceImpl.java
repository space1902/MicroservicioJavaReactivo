package com.webfluxapirest.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webfluxapirest.app.dao.CategoriaDao;
import com.webfluxapirest.app.dao.ProductoDao;
import com.webfluxapirest.app.models.Categoria;
import com.webfluxapirest.app.models.Producto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImpl implements ProductoService{


	@Autowired
	private ProductoDao productDao;
	
	@Autowired
	private CategoriaDao categoriaDao;
	
	@Override
	public Flux<Producto> findAll() {

		return productDao.findAll();
	}

	@Override
	public Mono<Producto> findById(String id) {
		return productDao.findById(id);
	}

	@Override
	public Mono<Producto> save(Producto producto) {
		return productDao.save(producto);
	}

	@Override
	public Mono<Void> delete(Producto producto) {
		return productDao.delete(producto);
	}

	@Override
	public Flux<Producto> findAllConNombre() {
		// TODO Auto-generated method stub
		return productDao.findAll().map(prod ->{
			prod.setNombre(prod.getNombre().toUpperCase());
			return prod;
		});
	}

	@Override
	public Flux<Producto> findAllConNombreUpperRepeat() {
		return productDao.findAll().map(prod ->{
			prod.setNombre(prod.getNombre().toUpperCase());
			return prod;
		});
	}

	@Override
	public Flux<Categoria> findAllCategoria() {
		return categoriaDao.findAll();
	}

	@Override
	public Mono<Categoria> findCategoriaById(String id) {
		return categoriaDao.findById(id);
	}

	@Override
	public Mono<Categoria> saveCategoria(Categoria categoria) {
		return categoriaDao.save(categoria);
	}

}
