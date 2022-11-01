package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int minus(int y) {
        return y - x;
    }

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return minus(x) + sum(x) + multiply(x) + divide(x);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int minus = minus(5);
        System.out.println(minus);
        int sum = sum(5);
        System.out.println(sum);
        int multiply = calculator.multiply(5);
        System.out.println(multiply);
        int divide = calculator.divide(5);
        System.out.println(divide);
        int sumAll = calculator.sumAllOperation(5);
        System.out.println(sumAll);
    }
}
