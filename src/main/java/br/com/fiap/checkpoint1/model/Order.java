package br.com.fiap.checkpoint1.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private LocalDate orderDate;

    private double totalAmount;
    
    public Order() {}

	public Order(Long id, String customerName, LocalDate orderDate, double totalAmount) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}

	@PrePersist
    private void setOrderDate() {
        if (this.orderDate == null) {
            this.orderDate = LocalDate.now();
        }
    }

    public void setTotalAmount(double totalAmount) {
        if (totalAmount < 0) {
            throw new IllegalArgumentException("Total amount cannot be negative");
        }
        this.totalAmount = totalAmount;
    }

    public void setCustomerName(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name is required");
        }
        this.customerName = customerName;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public double getTotalAmount() {
		return totalAmount;
	}
    
    
}
