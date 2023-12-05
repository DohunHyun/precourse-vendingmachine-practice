package vendingmachine.domain;

public class Item {
    String name;
    int price;
    int amount;

    Item(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
}
