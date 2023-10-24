package com.ironhead.runnable_and_thread;

import static com.ironhead.constants.ThreadColor.ANSI_RED;

public class FirstRunnable implements Runnable {
  @Override
  public void run() {
    System.out.println(ANSI_RED + "We are in FirstRunnable implementation of run()");
  }
}
