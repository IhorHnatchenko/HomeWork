package org.example.service;

import org.example.model.Customer;
import org.example.model.Product;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> getAll() {
        List<Customer> customerList = customerRepository.getAll();
        if (customerList.isEmpty()) {
            System.out.println("Customer list is empty.");
        }
        return customerList;
    }

    @Override
    public Customer getById(int id) {
        if (id == 0) {
            System.out.println("Incorrect id " + id);
            return null;
        }

        Customer byId = customerRepository.getById(id);
        if(byId == null){
            System.out.println("Customer with id " + id + " not found.");
        }

        return byId;
    }

    @Override
    public Customer createNew(Customer customer) {
        if(customer.getLastName().isEmpty() || customer.getName().isEmpty()){
            System.out.println("Error with incoming data.");
            return null;
        }
        return customerRepository.createNew(customer);
    }

    @Override
    public List<Product> saveInBasket(int id, Product product) {
        return customerRepository.saveInBasket(id, product);
    }
}
