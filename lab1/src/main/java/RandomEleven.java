package com.lab1;

import java.util.Arrays;
import java.util.Random;

// 3
public class RandomEleven {
    public static void main(String[] args) {

        Random r = new Random();
        int[] ints = new int[11];
        for (int i = 0; i < ints.length; i++)
            ints[i] = r.nextInt();
//        int[] ints = new int[]{56,1,2,3,4,5,45,3,5,43,543};
        System.out.print("[");
        for (int i : ints)
            System.out.print(i + ", ");
        System.out.print("]");

        Arrays.sort(ints);
        System.out.println("\nNajwieksza: " + ints[ints.length -1]);
        System.out.println("Prawie najwieksza: " + ints[ints.length -2]);
    }
}
