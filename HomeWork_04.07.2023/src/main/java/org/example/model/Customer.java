package org.example.model;

import java.util.List;

public class Customer {

    private int id;
    private String name;
    private String lastName;
    private int age;

    private List<Product> customerProductList;

    public Customer(int id, String name, String lastName, int age, List<Product> customerProductList) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.customerProductList = customerProductList;
    }

    public Customer() {
    }

    public List<Product> getCustomerProductList() {
        return customerProductList;
    }

    public void setCustomerProductList(List<Product> customerProductList) {
        this.customerProductList = customerProductList;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
