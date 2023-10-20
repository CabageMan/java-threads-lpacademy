package com.ironhead;

import static com.ironhead.ThreadColor.ANSI_BLUE;
public class FirstThread extends Thread {

  @Override
  public void run() {
    System.out.println(ANSI_BLUE + "We are in the " + currentThread().getName());

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      System.out.println(ANSI_BLUE + "Another thread woke me up");
      return; // Immediately interrupt the thread.
    }
    System.out.println(ANSI_BLUE + "Three seconds have passed and I'm awake");
  }
}

