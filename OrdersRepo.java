package com.Neeharika.CRUDDemo.Repository;

import com.Neeharika.CRUDDemo.Model.Orders;
import jakarta.persistence.criteria.Order;
//import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer> {

    //@Query("SELECT o FROM Order o JOIN FETCH o.user")
    @Query("SELECT o FROM Orders o JOIN FETCH o.user")
    List<Orders> findAllOrdersWithUsers();
}
