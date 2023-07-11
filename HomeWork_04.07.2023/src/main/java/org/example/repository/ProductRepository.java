package org.example.repository;

import org.example.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAll();

    Product getById(int id);

    Product createNew(Product product);


}
