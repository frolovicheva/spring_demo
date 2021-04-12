package spring.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext (AppConfig.class);

        ProductRepository repository = context.getBean ("productRepository", ProductRepository.class);
        // Получаем весь список репозитория
        System.out.println (repository);

        //Узнаем товар по ID
        System.out.println (repository.getNameByID (1));
        System.out.println (repository.getNameByID (3));
        System.out.println (repository.getNameByID (15));

        //Добавляем товары в корзину
        ShoppingCart cart = context.getBean ("shoppingCart", ShoppingCart.class);
        cart.addToCart (1);
        cart.addToCart (3);
        cart.addToCart (8);
        System.out.println (cart);

        //Добавляем товары во вторую корзину
        ShoppingCart cart2 = context.getBean ("shoppingCart", ShoppingCart.class);
        cart2.addToCart (4);
        cart2.addToCart (5);
        cart2.addToCart (7);
        //Удаляем ранее положенный в корзину товар
        cart2.deleteFromCart (4);
        System.out.println (cart2);

        context.close ();
    }
}
