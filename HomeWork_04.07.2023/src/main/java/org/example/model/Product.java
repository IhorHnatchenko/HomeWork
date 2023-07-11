package org.example.model;

public class Product {

    private int id;
    private String name;
    private String model;
    private boolean isAvailable;

    public Product(int id, String name, String model, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.isAvailable = isAvailable;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
