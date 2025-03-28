package br.com.fiap.checkpoint1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.checkpoint1.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
}
