package spring.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class ShoppingCart {


    private ProductRepository productRepository;
    private List<Product> productsInCart;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ShoppingCart(List<Product> productsInCart) {
        this.productsInCart = new ArrayList<Product> ();
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "productsInCart=" + productsInCart +
                '}';
    }

    public List <Product> addToCart (Integer id) {
        for (Product product: productRepository.getProducts ()) {
            if (id.equals (product.getId ())){
                productsInCart.add (product);
            }
        }
        return productsInCart;
    }

    public List <Product> deleteFromCart (Integer id) {
        for (Product product: productRepository.getProducts ()) {
            if (id.equals (product.getId ())){
                productsInCart.remove (product);
            }
        }
        return productsInCart;
    }

}
