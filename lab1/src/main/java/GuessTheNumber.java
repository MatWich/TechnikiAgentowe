package com.lab1;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static int guess() {
        Random r = new Random();
        int winningCond = r.nextInt(11);
//        System.out.println(winningCond);
        int guesses = 0;
        Scanner sc = new Scanner(System.in);
        int guess = -1;
        while (guess != winningCond) {
            guess = sc.nextInt();
            guesses++;
        }
        return guesses;
    }

    public static void main(String[] args) {
        System.out.println("Attempts: " + guess());
    }
}
