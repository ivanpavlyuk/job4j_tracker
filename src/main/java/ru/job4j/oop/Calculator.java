package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int number) {
        return number - x;
    }

    public int multiply(int number) {
        return x * number;
    }

    public int divide(int number) {
        return number / x;
    }

    public int sumAllOperation(int number) {
        return sum(number) + minus(number) + this.multiply(number) + this.divide(number);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        sum(10);
        result = minus(10);
        calculator.multiply(10);
        result = calculator.divide(10);
        System.out.println(calculator.sumAllOperation(10));
    }
}