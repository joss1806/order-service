
package com.company.order.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.company.order.entity.Order;
import java.util.UUID;
public interface OrderRepository extends JpaRepository<Order, UUID>{}
