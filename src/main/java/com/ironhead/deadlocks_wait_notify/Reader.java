package com.ironhead.deadlocks_wait_notify;

import com.ironhead.constants.KeyWords;
import com.ironhead.constants.ThreadColor;

import java.util.Random;

public class Reader implements Runnable {
  public static final String TITLE_COLOR = ThreadColor.ANSI_YELLOW;
  public static final String TEXT_COLOR = ThreadColor.ANSI_GREEN;
  public static final String ERROR_COLOR = ThreadColor.ANSI_RED;
  private final Message message;

  public Reader(Message message) {
    this.message = message;
  }

  public void run() {
    Random random = new Random();

    for (
            String latestMessage = message.read();
            !latestMessage.equals(KeyWords.FINISHED);
            latestMessage = message.read()
    ) {
      System.out.println(TITLE_COLOR + "Read Latest message: " + TEXT_COLOR +
              latestMessage + " from thread: " + Thread.currentThread().getName());
      try {
        Thread.sleep(random.nextInt(2000));
      } catch (InterruptedException e) {
        System.out.println(ERROR_COLOR + "Reader interrupted exception: " +
                e.getLocalizedMessage());
      }
    }
  }
}
