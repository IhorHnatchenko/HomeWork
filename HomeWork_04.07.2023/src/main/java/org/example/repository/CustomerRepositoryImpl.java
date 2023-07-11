package org.example.repository;

import org.example.model.Customer;
import org.example.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final Map<Integer, Customer> customerMap = new HashMap<>();

    @PostConstruct
    private void init() {
        customerMap.put(1, new Customer(1, "Ihor", "Hnatchenko", 21, new ArrayList<>()));
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getById(int id) {
        return customerMap.get(id);
    }

    @Override
    public Customer createNew(Customer customer) {
        int lastId = customerMap.keySet().stream().mapToInt(s -> s).max().getAsInt();
        customer.setId(lastId + 1);
        customerMap.put(customer.getId(), customer);
        return customer;
    }

    @Override
    public List<Product> saveInBasket(int id, Product product) {
        List<Product> customerProductList = new ArrayList<>();
        getById(id).getCustomerProductList().add(product);
        return customerProductList;
    }
}
