package org.example;

public class Main {
    public static void main(String[] args) {
        new Thread("1", 100, 300).run();
        new Thread("2", 301, 500).run();
        new Thread("3", 501, 700).run();
    }
}