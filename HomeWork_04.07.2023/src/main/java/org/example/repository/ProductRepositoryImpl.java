package org.example.repository;
import org.example.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Map<Integer, Product> productMap = new HashMap<>();

    @PostConstruct
    private void init() {
        productMap.put(1, new Product(1, "Pen", "A36B8", true));
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product getById(int id) {
        return productMap.get(id);
    }

    @Override
    public Product createNew(Product product) {
        int lastId = productMap.keySet().stream().mapToInt(s->s).max().getAsInt();
        product.setId(lastId + 1);
        productMap.put(product.getId(), product);
        return product;
    }
}
