package com.lab1;

public class AnciiTriangle {

    private static final char NEW_LINE = '\n';
    private static final char STAR = '*';
    private static final char DASH = ' ';

    public static String drawIsoscelesTriangle(int n) {
        final StringBuilder stringBuilder = new StringBuilder();
        int amountStarsToDrawInRow = 1;
        for (int i=n-1;i>=0;i--) {
            for(int j=0;j<i;j++) {
                stringBuilder.append(DASH);
            }
            for(int j=0;j<amountStarsToDrawInRow;j++) {
                stringBuilder.append(STAR);
            }
            amountStarsToDrawInRow += 2;
            stringBuilder.append(NEW_LINE);
        }
        return stringBuilder.toString();
    }

    public static void drawSquaredTriangle(int n) {
        String liniaGwiazdek1 = "";

        for (var i = 0; i < n; i++) {
            liniaGwiazdek1 = liniaGwiazdek1 + '*';
            System.out.println(liniaGwiazdek1 );
        }
    }

    public static void main(String[] args) {
        drawSquaredTriangle(5);

        System.out.println(drawIsoscelesTriangle(6));
    }
}
