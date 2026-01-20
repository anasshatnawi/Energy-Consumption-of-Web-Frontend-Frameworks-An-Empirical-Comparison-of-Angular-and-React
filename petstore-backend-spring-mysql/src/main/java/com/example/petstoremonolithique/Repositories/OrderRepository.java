package com.example.petstoremonolithique.Repositories;


import com.example.petstoremonolithique.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("select o from Order o where o.id = ?1")
    Optional<Order> findOrderById( Long id);
}
