package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book crime = new Book("Crime and punishment", 700);
        Book war = new Book("War and peace", 1500);
        Book code = new Book("Clean code", 900);
        Book pride = new Book("Pride and prejudice", 800);
        Book[] list = {crime, war, code, pride};
        for (int index = 0; index < list.length; index++) {
            Book book = list[index];
            System.out.println(book.getName() + " - " + book.getPages() + " pages");
        }
        Book book = list[0];
        list[0] = list[3];
        list[3] = book;
        for (int index = 0; index < list.length; index++) {
            book = list[index];
            System.out.println(book.getName() + " - " + book.getPages() + " pages");
        }
        for (int index = 0; index < list.length; index++) {
            book = list[index];
            if  ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getPages() + " pages");
            }
        }
    }
}