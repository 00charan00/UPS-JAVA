package com.charan.Programs;

import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public double getTotalValue() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return  "Name=" + name+
                ", price=" + price +
                ", quantity=" + quantity;
    }
}

class InventoryManager {
    private List<Product> products;

    public InventoryManager() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(product.getName())) {
                p.addQuantity(product.getQuantity());
                return;
            }
        }
        products.add(product);
    }



    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public double getTotalInventoryValue() {
        double totalValue = 0.0;
        for (Product product : products) {
            totalValue += product.getTotalValue();
        }
        return totalValue;
    }

    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager();

        inventory.addProduct(new Product("Node", 12, 5));
        inventory.displayProducts();
        inventory.addProduct(new Product("Laptop", 10, 2));
        inventory.displayProducts();

        System.out.println("\nTotal: " + inventory.getTotalInventoryValue());
    }
}
