package br.com.fiap.checkpoint1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint1.model.Order;
import br.com.fiap.checkpoint1.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }


    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }



    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

 
}
