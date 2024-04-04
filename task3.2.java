import java.util.ArrayList;
import java.util.List;

// Класc сладость
class Sweets {
    private String name;
    private double weight;
    private double price;
    private String uniqueParameter;

    public Sweets(String name, double weight, double price, String uniqueParameter) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.uniqueParameter = uniqueParameter;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return name + " (вес: " + weight + " г, цена: " + price + " руб, " + uniqueParameter + ")";
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

public class GiftMaking {
    public static void main(String[] args) {
        Sweets chocolate = new Sweets("Шоколад", 100, 150, "темный");
        Sweets candy = new Sweets("Конфеты", 200, 200, "карамельные");
        Sweets cookies = new Sweets("Печенье", 150, 100, "овсяное");

        
        Gift gift = new Gift();

        gift.addSweets(chocolate);
        gift.addSweets(candy);
        gift.addSweets(cookies);

        System.out.println("Общий вес подарка: " + gift.getTotalWeight() + " г");
        System.out.println("Общая стоимость подарка: " + gift.getTotalPrice() + " руб");
        gift.printGiftContents();
    }
}
