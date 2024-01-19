package com.ironhead.thread_variables;
public class CountdownThread extends Thread {
  private Countdown countdown;

  public CountdownThread(Countdown countdown) {
    this.countdown = countdown;
  }

  public void run() {
    countdown.doCountdown();
  }
}


