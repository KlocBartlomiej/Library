package com.kloc.demo2.Repositories;

import com.kloc.demo2.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
