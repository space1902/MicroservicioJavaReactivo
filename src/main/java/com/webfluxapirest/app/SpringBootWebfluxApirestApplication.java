package com.webfluxapirest.app;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.webfluxapirest.app.models.Categoria;
import com.webfluxapirest.app.models.Producto;
import com.webfluxapirest.app.SpringBootWebfluxApirestApplication;
import com.webfluxapirest.app.service.ProductoService;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringBootWebfluxApirestApplication implements CommandLineRunner{



	@Autowired
	private ProductoService productoServiceImpl;

	@Autowired
	private ReactiveMongoTemplate mongoTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootWebfluxApirestApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebfluxApirestApplication.class, args);

	}

		@Override
		public void run(String... args) throws Exception {
			
			mongoTemplate.dropCollection("productos").subscribe();
			mongoTemplate.dropCollection("categorias").subscribe();
			
			Categoria prueba = new Categoria("prueba");
			Categoria deporte = new Categoria("deporte");
			Categoria electronico = new Categoria("electronico");
			
			Flux.just(prueba, deporte, electronico)
			.flatMap(productoServiceImpl::saveCategoria)
			.thenMany(Flux.just(new Producto("computador", 123.456, prueba),
					new Producto("computador2", 1234.456, deporte),
					new Producto("computador3", 1235.456, electronico),
					new Producto("computador4", 1236.456, prueba),
					new Producto("computador5", 1237.456, deporte),
					new Producto("computador6", 1238.456, electronico),
					new Producto("computador7", 1239.456, prueba))
			.flatMap(prod -> {
				prod.setCreateAt(new Date());
				return productoServiceImpl.save(prod);
			}))
			.subscribe(prod -> log.info("inserto: " + prod.getId() + " " + prod.getNombre()));
		}


}
