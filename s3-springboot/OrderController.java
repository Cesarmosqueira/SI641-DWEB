package com.example.upcpredemointrospringboot.controller;

import com.example.upcpredemointrospringboot.dto.OrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class OrderController {

    //http://localhost:8081/orders==> method htpp GET
    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> findAll(){
        List<OrderResponse> orders=new ArrayList<>();

        OrderResponse response=new OrderResponse();
        response.setAccountId("999819");
        response.setOrderId("11123");
        response.setStatus("PENDING");
        response.setTotalAmount(100.00);
        response.setTotalTax(10.00);
        response.setTransactionDate(new Date());

        OrderResponse response02=new OrderResponse();
        response02.setAccountId("999819");
        response02.setOrderId("11124");
        response02.setStatus("PENDING");
        response02.setTotalAmount(120.00);
        response02.setTotalTax(12.00);
        response02.setTransactionDate(new Date());

        orders.add(response);
        orders.add(response02);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    //http://localhost:8081/orders/1 ==> GET
    @GetMapping("orders/{orderId}")
    public ResponseEntity<OrderResponse> findById(@PathVariable String orderId){
        OrderResponse response=new OrderResponse();
        response.setAccountId("999819");
        response.setOrderId(orderId);
        response.setStatus("PENDING");
        response.setTotalAmount(100.00);
        response.setTotalTax(10.00);
        response.setTransactionDate(new Date());

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
