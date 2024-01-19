package com.ironhead.deadlocks_wait_notify;

public class Message {
  private String message;
  private boolean empty = true;

  public synchronized String read() {
    while (empty) {
//      try {
//        wait();
//      } catch (InterruptedException e) {
//        System.out.println("Message read interrupt exception: " + e);
//      }
    }
    empty = true;
//    notifyAll();
    return message;
  }

  public synchronized void write(String message) {
    while (!empty) {
//      try {
//        wait();
//      } catch (InterruptedException e) {
//        System.out.println("Message write interrupt exception: " + e);
//      }
    }
    empty = false;
    this.message = message;
//    notifyAll();
  }
}
