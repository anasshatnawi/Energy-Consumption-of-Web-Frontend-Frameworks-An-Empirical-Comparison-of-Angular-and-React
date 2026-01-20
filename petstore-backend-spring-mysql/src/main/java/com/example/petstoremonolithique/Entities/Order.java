package com.example.petstoremonolithique.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue
	private Long id;
	private Long petId;
	private int quantity;
	private LocalDateTime shipDate;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	private boolean complete;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
	}

	public Long getPetId() {
		return this.petId;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setShipDate(LocalDateTime shipDate) {
		this.shipDate = shipDate;
	}

	public LocalDateTime getShipDate() {
		return this.shipDate;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public OrderStatus getStatus() {
		return this.status;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	public Boolean getComplete() {
		return this.complete;
	}
}
