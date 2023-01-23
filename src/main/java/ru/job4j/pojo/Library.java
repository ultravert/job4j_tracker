package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book harryPotter = new Book("Harry Potter", 300);
        Book lordOfTheRings = new Book("Lord of the Rings", 1000);
        Book gameOfThrones = new Book("Game of Thrones", 800);
        Book cleanCode = new Book("Clean code", 500);
        Book[] books = new Book[4];
        books[0] = harryPotter;
        books[1] = lordOfTheRings;
        books[2] = gameOfThrones;
        books[3] = cleanCode;
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        for (Book bk : books) {
            if ("Clean code".equals(bk.getName())) {
                System.out.println(bk.getName() + " - " + bk.getCount());
            }
        }
    }
}
