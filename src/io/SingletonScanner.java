package io;

import java.util.Scanner;

public class SingletonScanner {
    private static Scanner inputSc;

    public SingletonScanner() {
    }

    public Scanner getScanner() {
        if (inputSc == null) {
            inputSc = new Scanner(System.in);
        }
        return inputSc;
    }
}
