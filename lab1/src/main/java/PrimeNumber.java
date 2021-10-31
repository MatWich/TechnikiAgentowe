package com.lab1;

public class PrimeNumber {
    public boolean isPrime(int number) {
        if (number == 0 || number == 1) return false;

        int m = number / 2;

        for (int i = 2; i < m; i++)
            if (number % i == 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        PrimeNumber pn = new PrimeNumber();
        System.out.println(pn.isPrime(2));
        System.out.println(pn.isPrime(5));
        System.out.println(pn.isPrime(7));
        System.out.println(pn.isPrime(9));
    }
}
