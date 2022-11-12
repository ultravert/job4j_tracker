package ru.job4j.oop;

public class Max {
    public static int max(int left, int right) {
        return left > right ? left : right;
    }

    public static int max(int first, int second, int third) {
        int rsl;
        if (first > second && first > third) {
            rsl = first;
        } else if (second > first && second > third) {
            rsl = second;
        } else {
            rsl = third;
        }
        return rsl;
    }

    public static int max(int first, int second, int third, int fourth) {
        return max(max(first, second, third), fourth);
    }

    public static void main(String[] args) {
        int result = max(4, 9);
        int result1 = max(5, 3, 5);
        int result2 = max(3, 2, 5, 5);
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
    }
}
