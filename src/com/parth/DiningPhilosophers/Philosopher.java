package com.parth.DiningPhilosophers;

public class Philosopher implements Runnable {

    // Number of iterations for which the code runs. Set the variable accordingly
    int iterations = 10;

    // Amount of time the philosophers take to think (ms)
    int thinking_time = 500;

    // Create objects Chopsticks
    private final Object Chopstick1;
    private final Object Chopstick2;

    // Constructor
    public Philosopher(Object Chopstick1, Object Chopstick2) {
        this.Chopstick1 = Chopstick1;
        this.Chopstick2 = Chopstick2;
    }

    @Override
    public void run() {
        try {
            while (iterations > 0) {
//                doAction(System.nanoTime() + ": Thinking");
                System.out.println(Thread.currentThread().getName() + " is thinking.");
                Thread.sleep(thinking_time);
                System.out.println(Thread.currentThread().getName() + " is hungry.");
                synchronized (Chopstick1) {
                    System.out.println(Thread.currentThread().getName() + " picked up chopstick 1.");
                    Thread.sleep((int) (Math.random() * 100));
                    synchronized (Chopstick2) {
                        System.out.println(Thread.currentThread().getName() + " picked up chopstick 2.");
                        Thread.sleep((int) (Math.random() * 100));
                        System.out.println(Thread.currentThread().getName() + " is done eating");
                        System.out.println(Thread.currentThread().getName() + " put down chopstick 2.");
                    }
                    System.out.println(Thread.currentThread().getName() + " is thinking again.");
                    Thread.sleep(thinking_time);
                }
                iterations--;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}