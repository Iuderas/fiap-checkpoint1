package br.com.fiap.checkpoint1.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.checkpoint1.model.Order;
import br.com.fiap.checkpoint1.repository.OrderRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(OrderRepository orderRepository) {
        return args -> {
            orderRepository.deleteAll();

            List<Order> orders = List.of(
                new Order(null, "Lucas Umada", null, 1500.0),
                new Order(null, "Gustavo Bonfim", null, 1220.3),
                new Order(null, "Enzo Lulu", null, 155.0)
            );

            orderRepository.saveAll(orders);

            long total = orderRepository.count();
            System.out.println(total + " orders in the database.");
        };
    }
}
