package service;

import model.Food;
import model.Discountable;

public class ShoppingCart {
    private Food[] products;

    public ShoppingCart(Food[] products) {
        this.products = products;
    }

    public double getTotalPriceWithoutDiscount() {
        double total = 0;

        for (int i = 0; i < products.length; i++) {
            total = total + products[i].getTotalPrice();
        }

        return total;
    }

    public double getTotalPriceWithDiscount() {
        double total = 0;

        for (int i = 0; i < products.length; i++) {
            double discount =
                    ((Discountable) products[i]).getDiscount();

            total = total +  products[i].getTotalPrice()
                    * (100 - discount)
                    / 100;
        }

        return total;
    }

    public double getVegetarianTotalPrice() {
        double total = 0;

        for (int i = 0; i < products.length; i++) {

            if (products[i].isVegetarian()) {
                total = total +  products[i].getTotalPrice();
            }

        }

        return total;
    }
}