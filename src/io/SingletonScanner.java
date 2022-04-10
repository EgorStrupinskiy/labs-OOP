package io;

import java.util.Scanner;

public class SingletonScanner {
    private static Scanner inputSc;
    private SingletonScanner() {}

    public static Scanner getScanner() {
        if (inputSc == null) {
            inputSc = new Scanner(System.in);
        }
        return inputSc;
    }
}
