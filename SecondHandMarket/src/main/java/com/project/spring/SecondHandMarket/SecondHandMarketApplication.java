package com.project.spring.SecondHandMarket;

import com.project.spring.SecondHandMarket.modelo.Producto;
import com.project.spring.SecondHandMarket.modelo.Usuario;
import com.project.spring.SecondHandMarket.servicios.ProductoServicio;
import com.project.spring.SecondHandMarket.servicios.UsuarioServicio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SecondHandMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondHandMarketApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(UsuarioServicio usuarioServicio, ProductoServicio productoServicio) {
		return args -> {

			Usuario usuario = new Usuario("Amador", "Sabido Carrero",null, "asabido@viavansi.com", "asabido");
			usuario = usuarioServicio.registrar(usuario);

			Usuario usuario2 = new Usuario("Antonio", "García Martín", null, "antonio.garcia@gmail.com", "antonio");
			usuario2 = usuarioServicio.registrar(usuario2);


			List<Producto> listado = Arrays.asList(new Producto("Bicicleta de montaña", 100.0f, null, usuario),
					new Producto("Golf GTI Serie 2", 2500.0f, null, usuario),
					new Producto("Raqueta de tenis", 10.5f, null, usuario),
					new Producto("Xbox One X", 425.0f, null, usuario2),
					new Producto("Trípode flexible", 10.0f, null, usuario2),
					new Producto("Iphone 7 128 GB", 350.0f, null, usuario2));

			listado.forEach(productoServicio::insertar);
		};
	}

}
