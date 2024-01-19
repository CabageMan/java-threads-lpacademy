package com.ironhead;

import com.ironhead.constants.KeyWords;
import com.ironhead.constants.ThreadColor;
import com.ironhead.deadlocks_wait_notify.Message;
import com.ironhead.deadlocks_wait_notify.Reader;
import com.ironhead.deadlocks_wait_notify.Writer;
import com.ironhead.producer_and_consumer.MyConsumer;
import com.ironhead.producer_and_consumer.MyProducer;
import com.ironhead.runnable_and_thread.FirstRunnable;
import com.ironhead.runnable_and_thread.FirstThread;
import com.ironhead.thread_variables.Countdown;
import com.ironhead.thread_variables.CountdownThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static com.ironhead.constants.ThreadColor.*;

public class Main {
  public static String mainColor = ANSI_PURPLE;
  public static String dividerColor = ANSI_CYAN;
  public static String anonymousColor = ANSI_GREEN;

  public static void main(String[] args) {

    /*
    // --------------------------------------------------------------------
    // Runnable and Threads.
    System.out.println(mainColor + "We are in the " +
            Thread.currentThread().getName() + " thread.");

    // Extending Thread class.
    Thread firstThread = new FirstThread();
    firstThread.setName("-Extended Thread-");
    firstThread.start();

    // Creating of anonymous class thread.
    new Thread() {
      public void run() {
        System.out.println(anonymousColor + "We are in the anonymous " +
                Thread.currentThread().getName() + " thread.");
      }
    }.start();

    // Implementing Runnable interface
    Thread implementedRunnableThread = new Thread(new FirstRunnable());
    implementedRunnableThread.setName("-Implemented Runnable-");
    implementedRunnableThread.start();

    // Another ways to declare using anonymous class:
    // This does the same result by calling super.run()
    new Thread(new FirstRunnable() {
      @Override
      public void run() {
        super.run();
      }
    }).start();

    // Anonymous overridden:
    Thread overriddenRunnableThread = new Thread(new FirstRunnable() {
      @Override
      public void run() {
        System.out.println(FirstRunnable.logColor +
                "We are in the anonymous " +
                Thread.currentThread().getName() +
                ": overridden implementation of FirstRunnable run()");

        try {
          firstThread.join(4000); // Set time out for thread execution
//          firstThread.join();
          System.out.println(FirstRunnable.logColor + firstThread.getName() +
                  " terminated, or timed, so " +
                  Thread.currentThread().getName() + " is running :)");
          drawDivider(1);
        } catch (InterruptedException e) {
          System.out.println(FirstRunnable.logColor +
                  Thread.currentThread().getName() +
                  " couldn't wait after all. It was interrupted.");
        }
      }
    });
    overriddenRunnableThread.setName("-Overridden Runnable-");
    overriddenRunnableThread.start();

//    firstThread.interrupt();

    // If color is not defined, it uses a color from the last statement.
    System.out.println(mainColor + "Another message from the " +
            Thread.currentThread().getName() + " thread");
     */

    /*
    // --------------------------------------------------------------------
    // Threads variables.
    Countdown countdown = new Countdown();

    CountdownThread thread1 = new CountdownThread(countdown);
    thread1.setName(KeyWords.THREAD_NAME_1);
    CountdownThread thread2 = new CountdownThread(countdown);
    thread2.setName(KeyWords.THREAD_NAME_2);
    CountdownThread thread3 = new CountdownThread(countdown);
    thread3.setName(KeyWords.THREAD_NAME_3);

    thread1.start();
    thread2.start();
    thread3.start();
     */

    // --------------------------------------------------------------------
    // Deadlocks with notify.
    Message message = new Message();
//    (new Thread(new Writer(message))).start();
//    (new Thread(new Reader(message))).start();

    /*
    // Producer and Consumer
    List<String> buffer = new ArrayList<>();
    ReentrantLock bufferLock = new ReentrantLock();
    MyProducer producer = new MyProducer(buffer, ANSI_YELLOW, bufferLock);
    MyConsumer consumer1 = new MyConsumer(buffer, ANSI_PURPLE, bufferLock);
    MyConsumer consumer2 = new MyConsumer(buffer, ANSI_GREEN, bufferLock);

    new Thread(producer).start();
    new Thread(consumer1).start();
    new Thread(consumer2).start();
     */
  }

  private static void drawDivider(int numberOfLines) {
    System.out.println("\n");
    do {
      System.out.println(dividerColor + "---------------------------------------------------");
      numberOfLines--;
    } while (numberOfLines > 0);
    System.out.println("\n");
  }
}