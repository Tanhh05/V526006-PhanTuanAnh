package org.example.b1;

public class Fibonacci {
    public static void main(String[] args) {
        long previous = 0;
        long current = 1;

        for (int i = 0; i < 20; i++) {
            System.out.print(previous);
            if (i < 19) {
                System.out.print(" ");
            }

            long next = previous + current;
            previous = current;
            current = next;
        }
        System.out.println();
    }
}
