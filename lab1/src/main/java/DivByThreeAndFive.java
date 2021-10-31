package com.lab1;
// 1
public class DivByThreeAndFive {
    public static String divide(int number) {
        if (number > 100)
            throw new RuntimeException("Number out of range");
        String str = "";

        if (number % 5 == 0 && number % 3 == 0)
            str = "xyxy";
        else if (number % 5 == 0)
            str = "yyy";
        else if (number % 3 == 0)
            str = "xxx";


        return str;
    }
}
