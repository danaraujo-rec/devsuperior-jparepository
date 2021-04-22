package com.devsuperior.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.domain.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
