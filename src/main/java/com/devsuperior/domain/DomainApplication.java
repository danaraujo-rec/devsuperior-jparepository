package com.devsuperior.domain;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.domain.entity.Client;
import com.devsuperior.domain.entity.Order;
import com.devsuperior.domain.entity.OrderItem;
import com.devsuperior.domain.entity.OrderStatus;
import com.devsuperior.domain.entity.Product;
import com.devsuperior.domain.repositories.ClientRepository;
import com.devsuperior.domain.repositories.OrderItemRepository;
import com.devsuperior.domain.repositories.OrderRepository;
import com.devsuperior.domain.repositories.ProductRepository;

@SpringBootApplication
public class DomainApplication implements CommandLineRunner{
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DomainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//clientes
		Client c1 = new Client(null, "Dan Araújo", "aderivan.mkt@gmail.com");
		clientRepository.save(c1);
				
		//produtos
		Product p1 = new Product(null, "TV", 1000.0);
		Product p2 = new Product(null, "Mouse", 40.0);
		Product p3 = new Product(null, "PC", 1200.0);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Order o1 = new Order(null, Instant.parse("2021-04-18T11:25:09Z"), OrderStatus.PAID, c1);
		Order o2 = new Order(null, Instant.parse("2021-04-20T12:30:00Z"), OrderStatus.WAITING, c1);
		
		orderRepository.saveAll(Arrays.asList(o1, o2));
		
		OrderItem order1 = new OrderItem(null, 1, 1000.0, p1, o1);
		OrderItem order2 = new OrderItem(null, 2, 40.0, p2, o1);
		OrderItem order3 = new OrderItem(null, 1, 40.0, p2, o2);
		OrderItem order4 = new OrderItem(null, 1, 1200.0, p3, o2);
		
		orderItemRepository.saveAll(Arrays.asList(order1, order2, order3, order4));
	}

}
