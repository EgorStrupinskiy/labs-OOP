package io;

import java.util.Scanner;

public class SingletonScanner {
    private final static Scanner inputSc = new Scanner(System.in);
    private SingletonScanner() {}

    public static Scanner getScanner() {
        return inputSc;
    }
}
