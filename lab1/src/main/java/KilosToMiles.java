package com.lab1;

import java.util.Scanner;

public class KilosToMiles {
    public static double convertToLandMile(double kms) {
        return kms * 1.609344;
    }

    public static double convertToNauticalMile(double kms) {
        return kms * 1.852;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        double v = sc.nextDouble();
        int kms = 1;
        System.out.println(convertToLandMile(kms));
        System.out.println(convertToNauticalMile(kms));
    }
}
