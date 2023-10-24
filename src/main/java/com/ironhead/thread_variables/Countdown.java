package com.ironhead.thread_variables;

import static com.ironhead.constants.ThreadColor.*;

public class Countdown {
  private int i;
  /* First way to synchronous
  public synchronized void doCountdown() {
    String color;
    String threadName = Thread.currentThread().getName();

    switch (threadName) {
      case "Thread 1":
        color = ANSI_CYAN;
        break;
      case "Thread 2":
        color = ANSI_PURPLE;
        break;
      default:
        color = ANSI_GREEN;
    }

    for (i = 10; i > 0; i--) {
      System.out.println(color + threadName + ": i=" + i);
    }
  }
   */

  public void doCountdown() {
    String color;
    String threadName = Thread.currentThread().getName();

    switch (threadName) {
      case "Thread 1":
        color = ANSI_CYAN;
        break;
      case "Thread 2":
        color = ANSI_PURPLE;
        break;
      default:
        color = ANSI_GREEN;
    }

    synchronized (this) {
      for (i = 10; i > 0; i--) {
        System.out.println(color + threadName + ": i=" + i);
      }
    }
  }
}