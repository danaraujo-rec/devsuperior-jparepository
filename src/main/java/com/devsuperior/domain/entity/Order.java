package com.devsuperior.domain.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private Instant instant;
	private OrderStatus status;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@OneToMany(mappedBy = "order")
	private List<OrderItem> items = new ArrayList<>();

	public Order() {

	}

	public Order(Long id, Instant instant, OrderStatus status, Client client) {
		this.id = id;
		this.instant = instant;
		this.status = status;
		this.client = client;
	}

	public double getTotal() {
		Double sum = 0.0;
		for(OrderItem item : items) {
			sum += item.getSubTotal();
		}
		
		return sum;
	}
}
