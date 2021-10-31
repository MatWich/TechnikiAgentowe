package com.lab1;

public class CommonReverser {

    public String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public boolean isPalindrome(String str) {
        return str.equalsIgnoreCase(reverse(str));
    }

    public boolean isPalindrome(int number) {
        String before = String.valueOf(number);
        String after = String.valueOf(reverse(number));
        return before.equalsIgnoreCase(after);
    }


    public int reverse(int number) {
        int reverse = 0;

        while(number != 0)
        {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number/10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        CommonReverser cr = new CommonReverser();
        int my_int = 123;
        System.out.println("Reversed my_int: " + cr.reverse(my_int));
        System.out.println("Is my_int palindrome: " + cr.isPalindrome(my_int));

        String my_str = "kajak";
        System.out.println("Reversed my_str: " + cr.reverse(my_str));
        System.out.println("Is my_str palindrome: " + cr.isPalindrome(my_str));
    }
}
