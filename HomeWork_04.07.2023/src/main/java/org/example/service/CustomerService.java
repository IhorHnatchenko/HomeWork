package org.example.service;

import org.example.model.Customer;
import org.example.model.Product;

import java.util.List;

public interface CustomerService {
    
    List<Customer> getAll();

    Customer getById(int id);

    Customer createNew(Customer customer);

    List<Product> saveInBasket(int id, Product product);
}
