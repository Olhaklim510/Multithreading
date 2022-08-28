package com.company;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class FizzBuzzNumbers {
    static int n = 15;
    static String numberString;
    static BlockingQueue<String> queue;

    static void fizz(int num) {
        if (num % 3 == 0 & num % 5 != 0) {
            numberString = "fizz ";
        } else {
            numberString = num + " ";
        }
    }

    static void buzz(int num) {
        if (num % 5 == 0 & num % 3 != 0) {
            numberString = "buzz ";
        }
    }

    static void fizzbuzz(int num) {
        if (num % 3 == 0 & num % 5 == 0) {
            numberString = "fizzbuzz ";
        }
    }

    static void number() throws InterruptedException {
        System.out.print(queue.take());
    }

    public static void main(String[] args) throws InterruptedException {
        queue = new ArrayBlockingQueue<>(n);

        for (int i = 1; i <= n; i++) {
            final int FINAL_I = i;

            Thread a = new Thread(() -> fizz(FINAL_I));
            Thread b = new Thread(() -> buzz(FINAL_I));
            Thread c = new Thread(() -> fizzbuzz(FINAL_I));

            a.start();
            b.start();
            c.start();

            a.join();
            b.join();
            c.join();

            queue.put(numberString);
        }

        Thread d = new Thread(() -> {
            try {
                for (int i = 1; i <= n; i++) {
                    number();
                }
            } catch (InterruptedException exc) {
                System.out.println(exc.getMessage());
            }
        });
        d.start();
    }
}


