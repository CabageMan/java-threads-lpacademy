package com.ironhead.deadlocks_wait_notify;

import com.ironhead.deadlocks_wait_notify.Message;

import java.util.Random;

public class Writer implements Runnable {
  private Message message;

  public Writer(Message message) {
    this.message = message;
  }

  public void run() {
    String messages[] = {
            "First message",
            "Second message",
            "Third message",
            "Fourth message"
    };

    Random random = new Random();

    for (int i = 0; i < messages.length; i++) {
      message.write(messages[i]);
      try {
        Thread.sleep(random.nextInt(2000));
      } catch (InterruptedException e) {
        System.out.println("Sleep exception");
      }
    }
    message.write("Finished");
  }
}
