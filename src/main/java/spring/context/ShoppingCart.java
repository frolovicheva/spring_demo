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

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private List<Product> productsInCart;

    public ShoppingCart(List<Product> productsInCart) {
        this.productsInCart = new ArrayList<Product> ();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "productsInCart=" + productsInCart +
                '}';
    }

    public List <Product> addToCart (int id) {
        for (Product product: productRepository.getProducts ()) {
            if (product.getId () == id){
                productsInCart.add (product);
            }
        }
        return productsInCart;
    }

    public List <Product> deleteFromCart (int id) {
        for (Product product: productRepository.getProducts ()) {
            if (product.getId () == id){
                productsInCart.remove (product);
            }
        }
        return productsInCart;
    }

}
