package org.example.service;

import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        List<Product> productList = productRepository.getAll();
        if(productList.isEmpty()){
            System.out.println("Product list is empty.");
        }
        return productList;
    }

    @Override
    public Product getById(int id) {
        if(id == 0){
            System.out.println("Incorrect id " + id);
            return null;
        }
        Product byId = productRepository.getById(id);
        if(byId == null){
            System.out.println("Product with id " + id + " not found.");
        }

        return byId;
    }

    @Override
    public Product createNew(Product product) {
        if(product.getModel().isEmpty() || product.getName().isEmpty()){
            System.out.println("Error with incoming data.");
            return null;
        }
        return productRepository.createNew(product);
    }
}
