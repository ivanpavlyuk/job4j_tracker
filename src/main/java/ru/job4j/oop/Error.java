package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Ошибка активна: " + active);
        System.out.println("Статус ошибки: " + status);
        System.out.println("Сообщение об ошибке: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error symbol = new Error(true, 14, "ошибка: не удается найти символ");
        Error semicolon = new Error(false, 8, "ожидаемая ошибка: ';'");
        Error outbound = new Error(true, 30, "Array out of bound");
        error.printInfo();
        symbol.printInfo();
        semicolon.printInfo();
        outbound.printInfo();
    }
}
