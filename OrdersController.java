package com.Neeharika.CRUDDemo.Controller;

import com.Neeharika.CRUDDemo.Model.Orders;
import com.Neeharika.CRUDDemo.Model.Users;
import com.Neeharika.CRUDDemo.Repository.OrdersRepo;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrdersController {

    @Autowired
    private OrdersRepo ordersRepo;

    @GetMapping("/getOrders")
    public List<Orders> getOrders(){
        return this.ordersRepo.findAll();
        //return this.ordersRepo.findAllOrdersWithUsers();
    }

    @GetMapping("/getOrders/{id}")
    public Optional<Orders> getOrderById(@PathVariable(value = "id") int id ){
        Optional<Orders> order;
        order = ordersRepo.findById(id);
        return (order);
    }


    @PostMapping("/getOrders")
    public Orders createOrder(@RequestBody Orders order){
        return this.ordersRepo.save(order);
    }

    @PutMapping("/getOrders/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable(value = "id") int id, @RequestBody Orders newOrder ){
        Orders order;
        order = ordersRepo.findById(id).orElse(null);
        assert order != null;
        order.setOrder_description(newOrder.getOrder_description());
        //order.setName(newUser.getName());
        return ResponseEntity.ok(this.ordersRepo.save(order));
    }

    @DeleteMapping("/getOrders/{id}")
    public String deleteEmployee( @PathVariable (value ="id") int id){
        Orders order;
        order = ordersRepo.findById(id).orElse(null);
        this.ordersRepo.delete(order);
        return "Deleted: "+ order.getOrder_id()+" "+ order.getOrder_description();
    }


}
