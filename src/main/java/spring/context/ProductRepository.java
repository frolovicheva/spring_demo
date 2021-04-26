package spring.context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ProductRepository {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<Product> (Arrays.asList (
                new Product (1, "Oranges", 50),
                new Product (2, "Apples", 40),
                new Product (3, "Bananas", 30),
                new Product (4, "Kivis", 20),
                new Product (5, "Pineapple", 70),
                new Product (6, "Grapes", 30),
                new Product (7, "Pears", 50),
                new Product (8, "Mandarines", 10),
                new Product (9, "Strawberries", 30),
                new Product (10, "Cherries", 45)
        ));
    }


    @Override
    public String toString() {
        return "ProductRepository{" +
                "products=" + products +
                '}';
    }

    public String getNameByID (Integer id) {
        String name = "No such ID";
            for (Product product: products) {
                if (id.equals (product.getId ())) return product.getName ();
            }
        return name;
    }
}
