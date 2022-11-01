package ru.job4j.oop;

public class Error {
    public boolean active;
    public int status;
    public String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error1 = new Error(true, 1, "OK");
        error.printInfo();
        error1.printInfo();
    }
}
