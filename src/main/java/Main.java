import objects.Product;
import objects.RegularClient;
import objects.Store;
import objects.User;
import other.Vegetable;

import java.util.Scanner;

public class Main {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        Store store = new Store();
        Product tomatoes = new Product("Помидоры", 150, 5);
        Product cucumbers = new Product("Огурцы", 100, 4);
        Product potatoes = new Product("Картошка", 50, 5);
        store.addProducts(tomatoes, cucumbers, potatoes);


        User me = new User(1000, store);
        User regularClient = new RegularClient(2000, store);


        System.out.println("Добро пожаловать!");
        System.out.println("Ваш баланс: " + me.getMoney());


        startShopping(me, store);
        startShopping(regularClient, store);

        System.out.println();
        System.out.println("До скорых встреч!");

    }

    private static void startShopping(User user, Store store) {
        do {
            // бесконечный цикл покупок внутри метода шоп
            // метод шоп прекращается как только введён 0
            shop(user, store);

            // выбираем, пока не решаем купить
        } while (!user.buy());
    }

    private static void shop(User me, Store store) {

        vneshniyTsikl:
        while (true) {
            System.out.println("Что вы хотите сделать? Введите число");
            System.out.println("1. Добавить в корзину");
            System.out.println("2. Удалить из корзины");

            int input = s.nextInt();

            if (input == 1) {
                System.out.println("Список продуктов:");
                store.printProducts();
                System.out.println("Что вы хотите купить? Введите id продукта");
                System.out.println("Или введите 0 для оплаты заказа");
                int id = s.nextInt();       // todo invalid input exception

                if (id == 0) {
                    break;
                }

                System.out.println("Введите количество");
                int amount = s.nextInt();


                Product productToAdd = store.getProductById(id);

                if (me.addToCart(productToAdd, amount)) {  // todo check if store contains product
                    // todo check if adding fails

                    System.out.println("Продукт \"" + productToAdd.getName() + "\" добавлен в корзину в количестве " + amount);
                    System.out.println("В вашей корзине продуктов на " + me.getCartSum() + " руб.");
                    System.out.println();
                } else {
                    System.out.println("Такого продукта в магазине нет");
                    System.out.println();
                }
            } else if (input == 2) {
                System.out.println("Список продуктов:");
                store.printProducts();
                System.out.println("Что вы хотите удалить из корзины? Введите id продукта");
                System.out.println("Или введите 0 для оплаты заказа");
                int id = s.nextInt();       // todo invalid input exception

                if (id == 0) {
                    break;
                }

                System.out.println("Введите количество");
                int amount = s.nextInt();


                Product productToRemove = store.getProductById(id);

                // todo check if adding fails
                if (me.removeFromCart(productToRemove, amount)) {
                    System.out.println("Продукт \"" + productToRemove.getName() + "\" удалён из корзины в количестве " + amount);
                    System.out.println("В вашей корзине продуктов на " + me.getCartSum() + " руб.");
                    System.out.println();
                } else {
                    System.out.println("Такого продукта в корзине нет");
                }

            }

            // TODO print contents of cart each time
        }
    }
}

// todo next:
    // method to remove from cart
    // SOLID
    // remove rating
    // remove extends
    // separate into methods
    // print contents of cart each time