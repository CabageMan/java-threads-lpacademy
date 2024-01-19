package com.ironhead.thread_variables;

import com.ironhead.constants.KeyWords;

import static com.ironhead.constants.ThreadColor.*;
import static com.ironhead.constants.KeyWords.*;

public class Countdown {

  private int i;

  /*
  // First way to synchronize (method)
  public synchronized void doCountdown() {
    String color;
    String threadName = Thread.currentThread().getName();

    switch (threadName) {
      case KeyWords.THREAD_NAME_1:
        color = ANSI_CYAN;
        break;
      case KeyWords.THREAD_NAME_2:
        color = ANSI_PURPLE;
        break;
      case KeyWords.THREAD_NAME_3:
        color = ANSI_BLUE;
        break;
      default:
        color = ANSI_GREEN;
    }

    for (i = 10; i > 0; i--) {
      System.out.println(color + threadName + ": i=" + i);
    }
  }
   */

  // Another way to synchronise (code block).
  public void doCountdown() {
    String color;
    String threadName = Thread.currentThread().getName();

    switch (threadName) {
      case KeyWords.THREAD_NAME_1:
        color = ANSI_CYAN;
        break;
      case KeyWords.THREAD_NAME_2:
        color = ANSI_PURPLE;
        break;
      case KeyWords.THREAD_NAME_3:
        color = ANSI_BLUE;
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