package com.johanna;

import java.util.Scanner;

public class Hexadecimal {
    public static int hex_to_decimal(String s)
    {
        String digits = "0123456789ABCDEF";
        s = s.toUpperCase();
        int val = 0;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
    }
    public static void main(String[] args) {
        /*String hexdec_num;
        int dec_num;
        Scanner scan = new Scanner(System.in);

        System.out.println("Input a hexadecimal number: ");
        hexdec_num = scan.nextLine();

        dec_num = hex_to_decimal(hexdec_num);

        System.out.println("Equivalent decimal number is: " + dec_num+"\n");*/

        int a = 3;
        int b = 4;

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(a ^ b));

        System.out.println("a ^ b = " + (a ^ b));

    }

}

