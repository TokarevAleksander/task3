import java.util.ArrayList;
import java.util.List;

// Родительский класс для всех видов сладостей
class Sweets {
    private String name;
    private double weight;
    private double price;

    public Sweets(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return name + " (вес: " + weight + " г, цена: " + price + " руб)";
    }
}

// Подкласс для шоколада с уникальным параметром - страной производства
class Chocolate extends Sweets {
    private String countryOfOrigin;

    public Chocolate(String name, double weight, double price, String countryOfOrigin) {
        super(name, weight, price);
        this.countryOfOrigin = countryOfOrigin;
    }

    public String toString() {
        return super.toString() + ", страна производства: " + countryOfOrigin;
    }
}

// Подкласс для конфет с уникальным параметром - вкусом
class Candy extends Sweets {
    private String flavor;

    public Candy(String name, double weight, double price, String flavor) {
        super(name, weight, price);
        this.flavor = flavor;
    }

    public String toString() {
        return super.toString() + ", вкус: " + flavor;
    }
}

// Подкласс для печенья с уникальным параметром - типом печенья
class Cookie extends Sweets {
    private String cookieType;

    public Cookie(String name, double weight, double price, String cookieType) {
        super(name, weight, price);
        this.cookieType = cookieType;
    }

    public String toString() {
        return super.toString() + ", тип печенья: " + cookieType;
    }
}

// Класс подарок
class Gift {
    private List<Sweets> sweetsList;

    public Gift() {
        sweetsList = new ArrayList<>();
    }

    // Добавления сладости в подарок
    public void addSweets(Sweets sweets) {
        sweetsList.add(sweets);
    }

    // Подсчета общего веса подарка
    public double getTotalWeight() {
        double totalWeight = 0;
        for (Sweets sweets : sweetsList) {
            totalWeight += sweets.getWeight();
        }
        return totalWeight;
    }

    // Подсчета общей стоимости подарка
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Sweets sweets : sweetsList) {
            totalPrice += sweets.getPrice();
        }
        return totalPrice;
    }

    public void printGiftContents() {
        System.out.println("Состав подарка:");
        for (Sweets sweets : sweetsList) {
            System.out.println("- " + sweets);
        }
    }
}

public class task3_2 {
    public static void main(String[] args) {
        Chocolate chocolate = new Chocolate("Шоколад", 100, 150, "Россия");
        Candy candy = new Candy("Конфеты", 200, 200, "Карамельные");
        Cookie cookie = new Cookie("Печенье", 150, 100, "Овсяное");

        Gift gift = new Gift();

        gift.addSweets(chocolate);
        gift.addSweets(candy);
        gift.addSweets(cookie);

        System.out.println("Общий вес подарка: " + gift.getTotalWeight() + " г");
        System.out.println("Общая стоимость подарка: " + gift.getTotalPrice() + " руб");
        gift.printGiftContents();
    }
}
