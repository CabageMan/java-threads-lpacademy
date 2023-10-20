package com.ironhead;

import static com.ironhead.ThreadColor.*;

public class Main {
  public static void main(String[] args) {
    /*
    System.out.println(ANSI_PURPLE + "We are in the Main thread");

    // We can run only one instance of thread at once.
    // To run another task need to create new instance of thread.
    Thread firstThread = new FirstThread();
    firstThread.setName("- First Thread -");
    firstThread.start();

    // Creating of anonymous class thread.
    new Thread() {
      public void run() {
        System.out.println(ANSI_GREEN + "We are in the anonymous class thread.");
      }
    }.start();

//    Thread firstRunnableThread = new Thread(new FirstRunnable());

//    Another way to declare using anonymous class:
//    Thread firstRunnableThread = new Thread(new FirstRunnable() {
//      @Override
//      public void run() {
//        super.run();
//      }
//    });

    Thread firstRunnableThread = new Thread(new FirstRunnable() {
      @Override
      public void run() {
        System.out.println(ANSI_RED + "We are in the anonymous class implementation of FirstRunnable run()");
        try {
//          firstThread.join(2000); // Set time out for thread execution
          firstThread.join();
          System.out.println(ANSI_RED + "firstThread terminated, or timed  so I'm running :)");
          drawDivider(1);
        } catch (InterruptedException e) {
          System.out.println(ANSI_RED + "I couldn't wait after all. I was interrupted.");
        }
      }
    });

    firstRunnableThread.start();

    // Interrupt thread.
//    firstThread.interrupt();

    // If color is not defined, it uses a color from the last statement.
    System.out.println(ANSI_PURPLE + "Another message from the Main thread");
    */

    // Check threads with variables.
    Countdown countdown = new Countdown();

    CountdownThread thread1 = new CountdownThread(countdown);
    thread1.setName("Thread 1");
    CountdownThread thread2 = new CountdownThread(countdown);
    thread2.setName("Thread 2");

    thread1.start();
    thread2.start();
  }

  private static void drawDivider(int numberOfLines) {
    System.out.println("\n");
    do {
      System.out.println(ANSI_CYAN + "---------------------------------------------------");
      numberOfLines--;
    } while (numberOfLines > 0);
    System.out.println("\n");
  }
}