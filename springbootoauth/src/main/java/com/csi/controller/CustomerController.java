package com.csi.controller;

import com.csi.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    List<Customer> customerList = Stream.of(new Customer(121, "SWARA", "PCMC"),
            new Customer(122, "RAM", "INDIA"),
            new Customer(124, "LAKSHMI", "PUNE"),
            new Customer(191, "APARNA", "PCMC"),
            new Customer(111, "SNEHAL", "USA")).toList();


    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Customer>> sortByName() {
        return ResponseEntity.ok(customerList.stream().sorted(Comparator.comparing(Customer::getCustName)).toList());
    }

}
