package com.charan.CDC_D_Tasks;

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
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
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

    public void removeProduct(String productName) {
        products.removeIf(p -> p.getName().equalsIgnoreCase(productName));
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

        inventory.addProduct(new Product("Laptop", 1000.0, 5));
        inventory.addProduct(new Product("Smartphone", 700.0, 10));
        inventory.addProduct(new Product("Tablet", 400.0, 3));

        System.out.println("Inventory:");
        inventory.displayProducts();

        inventory.addProduct(new Product("Laptop", 1000.0, 2));

        System.out.println("\nInventory after updating Laptop quantity:");
        inventory.displayProducts();

        inventory.removeProduct("Tablet");

        System.out.println("\nInventory after removing Tablet:");
        inventory.displayProducts();

        System.out.println("\nTotal Inventory Value: $" + inventory.getTotalInventoryValue());
    }
}
