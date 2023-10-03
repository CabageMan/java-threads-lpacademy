package com.ironhead;

import static com.ironhead.ThreadColor.ANSI_RED;

public class FirstRunnable implements Runnable {
  @Override
  public void run() {
    System.out.println(ANSI_RED + "We are in FirstRunnable implementation of run()");
  }
}
