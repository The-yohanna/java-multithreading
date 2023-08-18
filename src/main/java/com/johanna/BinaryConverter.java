package com.johanna;

import java.util.Scanner;

public class BinaryConverter {

    public static String convertToBinary(int n) {

        StringBuilder binary = new StringBuilder();

        while (n > 0) {
            binary.append(n % 2);
            n = n/2;
        }

        return binary.reverse().toString();

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer number: ");
        int input = scanner.nextInt();
        System.out.println(convertToBinary(input));

    }
}
