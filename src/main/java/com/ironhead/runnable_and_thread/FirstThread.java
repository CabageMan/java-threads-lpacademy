package com.ironhead.runnable_and_thread;

import static com.ironhead.constants.ThreadColor.ANSI_BLUE;
public class FirstThread extends Thread {
  public static String logColor = ANSI_BLUE;
  private static final long DELAY = 3000;

  @Override
  public void run() {
    System.out.println(logColor + "We are in the " + currentThread().getName());

    try {
      Thread.sleep(DELAY);
    } catch (InterruptedException e) {
      System.out.println(logColor + "The thread " +
              currentThread().getName() + " is interrupted.");
      return; // Immediately interrupt the thread.
    }
    System.out.println(logColor + DELAY + " milliseconds have passed and " +
            currentThread().getName() + " is awake");
  }
}

