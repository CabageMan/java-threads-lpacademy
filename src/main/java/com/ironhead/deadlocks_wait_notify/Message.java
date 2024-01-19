package com.ironhead.deadlocks_wait_notify;

public class Message {
  private String message;
  private boolean empty = true;

  public synchronized String read() {
    while (empty) {
      try {
        wait(); // Waiting for changes. In current case changes of epmty prop
      } catch (InterruptedException e) {
        System.out.println("Message read interrupted exception: " + e);
      }
    }
    empty = true;
    notifyAll();
    return message;
  }

  public synchronized void write(String message) {
    while (!empty) {
      try {
        wait(); // Waiting for changes. In current case changes of epmty prop
      } catch (InterruptedException e) {
        System.out.println("Message write interrupted exception: " + e);
      }
    }
    empty = false;
    this.message = message;
    notifyAll();
  }
}
