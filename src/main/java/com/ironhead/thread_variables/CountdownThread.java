package com.ironhead.thread_variables;

import com.ironhead.thread_variables.Countdown;

public class CountdownThread extends Thread {
  private Countdown countdown;

  public CountdownThread(Countdown countdown) {
    this.countdown = countdown;
  }

  public void run() {
    countdown.doCountdown();
  }
}


