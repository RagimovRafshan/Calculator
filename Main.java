package org.example.calculate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scan = new Scanner(System.in);
        while(true) {
            String str = scan.next();
            System.out.println(calc.toSalve(str));
        }

    }
}
