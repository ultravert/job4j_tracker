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
        swap0and3(books);
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        for (Book bk : books) {
            if (bk.getName().equals("Clean code")) {
                System.out.println(bk.getName() + " - " + bk.getCount());
            }
        }
    }

    public static void swap0and3(Book[] name) {
        Book temp = new Book("name", 999);
        temp = name[0];
        name[0] = name[3];
        name[3] = temp;
    }
}
