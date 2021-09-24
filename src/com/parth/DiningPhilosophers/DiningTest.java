package com.parth.DiningPhilosophers;

public class DiningTest {
    // Set the number of philosophers here
    static int number = 3;

    public static void main(String[] args) {
        // Creation of objects
        Philosopher[] philosophers = new Philosopher[number];
        Object[] chopsticks = new Object[philosophers.length];
        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = new Object();
        }

        // Assignment of chopsticks to philosophers
        for (int i = 0; i < philosophers.length; i++) {
            Object Chopstick1 = chopsticks[i];
            Object Chopstick2 = chopsticks[(i + 1) % chopsticks.length];

            // If the current philosopher is the last one, then make them pick up chopstick2 (right) first.
            if (i == philosophers.length - 1) philosophers[i] = new Philosopher(Chopstick2, Chopstick1);
            // For all others, make them pick up chopstick1 (left) first
            else philosophers[i] = new Philosopher(Chopstick1, Chopstick2);

            // Start executing threads, representing philosophers.
            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}