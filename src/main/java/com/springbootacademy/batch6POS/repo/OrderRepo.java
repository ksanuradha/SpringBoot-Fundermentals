package com.springbootacademy.batch6POS.repo;

import com.springbootacademy.batch6POS.dto.paginated.queryinterface.OrderDetailsInterface;
import com.springbootacademy.batch6POS.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order, Integer> {

    @Query(value = "select c.customer_name as customerName, c.customer_adress as customerAdress, c.contact_number as contactNumber, o.order_date as date, o.total as total" +
            " from customer c, orders o " +
            "where o.active_state=?1 and c.customer_id=o.customer_id",
            nativeQuery = true)
    List<OrderDetailsInterface> getAllOrderDetails(boolean status, Pageable of);

    @Query(value = "select count(*)" +
            " from customer c, orders o " +
            "where o.active_state=?1 and c.customer_id=o.customer_id",
            nativeQuery = true)
    long countAllOrderDetails(boolean status);
}
