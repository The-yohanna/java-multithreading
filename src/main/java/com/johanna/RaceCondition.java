package com.johanna;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceCondition {

    public static void main(String[] args) throws InterruptedException {

        InventoryCounter inventoryCounter = new InventoryCounter();
        IncrementingThread thread1 = new IncrementingThread(inventoryCounter);
        DecrementingThread thread2 = new DecrementingThread(inventoryCounter);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("We currently have " + inventoryCounter.getItems() + " items.");

    }

    public static class IncrementingThread extends Thread {

        private InventoryCounter inventoryCounter;

        public IncrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.increment();
            }
        }

    }

    public static class DecrementingThread extends Thread {

        private InventoryCounter inventoryCounter;

        public DecrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.decrement();
            }
        }

    }

    public static class InventoryCounter {

        private final AtomicInteger items = new AtomicInteger(0);

        private Stack<Integer> stack = new Stack<>();

        public void increment() {
            items.incrementAndGet();
        }

        public void decrement() {
            items.decrementAndGet();
        }

        public int getItems() {
            return items.get();
        }

    }
}
