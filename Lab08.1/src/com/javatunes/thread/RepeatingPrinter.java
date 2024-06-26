/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class RepeatingPrinter implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("RepeatingPrinter.run");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
            }
        }
    }
}