package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        if (index >= 0 && index <= products.length - 1) {
            for (int i = index; i < products.length; i++) {
                if (i + 1 == products.length - 1) {
                    products[i] = products[i + 1];
                    products[i + 1] = null;
                    break;
                } else if (index == products.length - 1) {
                    products[i] = null;
                    break;
                } else {
                    products[i] = products[i + 1];
                }
            }
        }
        return products;
    }
}
