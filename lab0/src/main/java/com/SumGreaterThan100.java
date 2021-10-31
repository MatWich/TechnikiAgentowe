package com;

import java.util.Scanner;

public class SumGreaterThan100 {
    // Prints the result of the equation (firstInt + SecondInt) * ThirdInt < NUM
    private static final int NUM = 100;

    public static void main(String[] args) {
        int[] ints = new int[3];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number");
        ints[0] = sc.nextInt();
        System.out.println("Enter second number");
        ints[1] = sc.nextInt();
        System.out.println("Enter third number");
        ints[2] = sc.nextInt();

        int result = (ints[0] + ints[1]) * ints[2];

        if (result == NUM)
            System.out.println("Equals to " + NUM);
        else
            System.out.println(result < NUM ? "Less than " + NUM : "More than " + NUM);
    }
}
