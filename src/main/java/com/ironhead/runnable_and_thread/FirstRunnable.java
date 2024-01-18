package com.ironhead.runnable_and_thread;

import static com.ironhead.constants.ThreadColor.ANSI_RED;

public class FirstRunnable implements Runnable {
  public static String logColor = ANSI_RED;
  @Override
  public void run() {
    System.out.println(logColor + "We are in " +
            Thread.currentThread().getName() +
            ": FirstRunnable implementation of run()");
  }
}
