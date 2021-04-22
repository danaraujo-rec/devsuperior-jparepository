package com.devsuperior.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private Integer quantity;
	private Double price;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@JsonIgnore //barra a serialização do objeto json na web, no momento de busca
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public OrderItem() {

	}

	public OrderItem(Long id, Integer quantity, Double price, Product product, Order order) {
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.product = product;
		this.order = order;
	}
	
	public double getSubTotal() {
		Double subTotal = this.price * this.quantity;
		
		return subTotal;
	}

}
