package com.ironhead.deadlocks_wait_notify;

import com.ironhead.deadlocks_wait_notify.Message;

import java.util.Random;

public class Reader implements Runnable {
  private Message message;

  public Reader(Message message) {
    this.message = message;
  }

  public void run() {
    Random random = new Random();
    for (
            String latestMessage = message.read();
            !latestMessage.equals("Finished");
            latestMessage = message.read()
    ) {
      System.out.println("Latest message: " + latestMessage);
      try {
        Thread.sleep(random.nextInt(2000));
      } catch (InterruptedException e) {
        System.out.println("Reader interrupted exception: " + e);
      }
    }
  }
}
