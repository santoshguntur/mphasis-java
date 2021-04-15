package com.mph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

//Product pojo class
class Product {
    long prodId;
    String name;
    Double cost;
    String category;

    public long getProdId() {
        return prodId;
    }

    public void setProdId(long prodId) {
        this.prodId = prodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }


    public Product() {
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Product(long prodId, String name, Double cost, String category) {
        this.prodId = prodId;
        this.name = name;
        this.cost = cost;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", category='" + category + '\'' +
                '}';
    }
}


class MapImplementation {

    private static Map<Long, Product> products = new HashMap<>();

    public static Map<Long, Product> getProduct() {
        return products;
    }

}

class DAOImplementation {
    private Map<Long, Product> products = MapImplementation.getProduct();

    public DAOImplementation() {
        products.put(1L, new Product(1, "dove", 25.20, "soap"));
        products.put(2L, new Product(2, "pears", 30.5, "soap"));
        products.put(3l, new Product(3, "almond", 300.0, "nuts"));
    }

    //Get All products
    public List<Product> getAllProducts() {

        return new ArrayList<Product>(products.values());
    }

    //Get product by product id
    public Product getProduct(long pid) {

        return products.get(pid);
    }

    //To Add the products
    public Product addProduct(Product product) {
        product.setProdId(products.size() + 1);
        products.put(product.getProdId(), product);
        return product;
    }

    //Update the product
    public Product updateProduct(Product product) {
        if (product.getProdId() <= 0) {
            return null;
        }
        products.put(product.getProdId(), product);
        return product;
    }

    // Delete the product
    public Product deleteProduct(long pid) {

        return products.remove(pid);

    }

    //Get the product by category
    public List<Product> getProductByCategory(String category) {

        if (products.size() == 0) {
            return new ArrayList<>();
        }

        return this.products.values().stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());
    }
}

public class CallBackPractise {
    public static void main(String[] args) {

        DAOImplementation dao = new DAOImplementation();
        dao.getProduct(1);
        System.out.println(dao.addProduct(new Product(4, "new item", 40.20, "type")));
        System.out.println(dao.getAllProducts());

        CompletableFuture.supplyAsync(() -> {
            return dao.getProduct(2);
        }).thenApply(product -> product.getCost() * 2 + " " + product)
                .thenAccept(product -> {
                    System.out.println("Got product detail from remote service " + product);
                });

    }
}
