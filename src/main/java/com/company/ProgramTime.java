package com.company;

public class ProgramTime {

    public static void main(String[] args) {

        Thread firstThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException exc) {
                    System.out.println(exc.getMessage());
                    ;
                }
                System.out.println("Time since the start of the program: " +
                        (System.currentTimeMillis() - start) / 1000 + " second " + Thread.currentThread().getName());
            }
        });
        firstThread.start();

        Thread secondThread = new Thread(() -> {
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(5050);
                } catch (InterruptedException exc) {
                    System.out.println(exc.getMessage());
                    ;
                }
                System.out.println("5 seconds passed" + " " + Thread.currentThread().getName());
            }
        });
        secondThread.start();
    }
}

