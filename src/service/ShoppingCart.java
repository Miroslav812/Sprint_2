package service;

import model.Food;
import model.Discountable;

public class ShoppingCart {
    private Food[] items;

    public ShoppingCart(Food[] items) {
        this.items = items;
    }

    // Общая сумма без скидок
    public double getTotalPriceWithoutDiscount() {
        double sum = 0;
        for (Food item : items) {
            sum += item.getCost();
        }
        return sum;
    }

    // Общая сумма со скидками
    public double getTotalPriceWithDiscount() {
        double sum = 0;
        for (Food item : items) {
            double discount = 0;
            if (item instanceof Discountable) {
                discount = ((Discountable) item).getDiscount();
            }
            sum += item.getCost() * (1 - discount / 100);
        }
        return sum;
    }

    // Сумма вегетарианских продуктов без скидки
    public double getTotalVegetarianPriceWithoutDiscount() {
        double sum = 0;
        for (Food item : items) {
            if (item.isVegetarian()) {
                sum += item.getCost();
            }
        }
        return sum;
    }
}