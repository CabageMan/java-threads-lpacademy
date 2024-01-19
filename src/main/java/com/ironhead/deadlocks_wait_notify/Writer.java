package com.ironhead.deadlocks_wait_notify;

import com.ironhead.constants.KeyWords;
import com.ironhead.constants.ThreadColor;

import java.util.Random;

public class Writer implements Runnable {
  public static final String TITLE_COLOR = ThreadColor.ANSI_GREEN;
  public static final String TEXT_COLOR = ThreadColor.ANSI_YELLOW;
  public static final String ERROR_COLOR = ThreadColor.ANSI_RED;
  private final Message message;

  public Writer(Message message) {
    this.message = message;
  }

  public void run() {
    String[] messages = {
            "First message",
            "Second message",
            "Third message",
            "Fourth message"
    };

    Random random = new Random();

    for (String messageText: messages) {
      message.write(messageText);
      try {
        Thread.sleep(random.nextInt(2000));
        System.out.println(TITLE_COLOR + "Write new message: " + TEXT_COLOR +
                messageText + " from thread: " + Thread.currentThread().getName());
      } catch (InterruptedException e) {
        System.out.println(ERROR_COLOR + "Writer Interrupted exception: " +
                e.getLocalizedMessage());
      }
    }
    message.write(KeyWords.FINISHED);
  }
}
