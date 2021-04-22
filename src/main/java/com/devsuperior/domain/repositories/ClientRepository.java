package com.devsuperior.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.domain.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
