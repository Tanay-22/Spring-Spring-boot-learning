package CountDownLatches;

import java.util.concurrent.CountDownLatch;

class SomeThread extends Thread
{
    private CountDownLatch latch;
    /* A synchronization aid that allows one or more
    threads to wait until a set of operations being
    performed in other threads completes */

    public SomeThread(CountDownLatch latch)
    {
        this.latch = latch;
    }

    @Override
    public void run()
    {
        System.out.println("Thread running with thread name " + Thread.currentThread().getName());
        System.out.println("Thread execution completed");
        System.out.println("**************************");
        latch.countDown();
        /*
            Decrements the count of the latch, releasing
            all waiting threads if the count reaches zero.
        */
    }
}

public class App
{
    public static void main(String[] args)
    {
        CountDownLatch latch = new CountDownLatch(4);
        SomeThread thread1 = new SomeThread(latch);
        SomeThread thread2 = new SomeThread(latch);
        SomeThread thread3 = new SomeThread(latch);
        SomeThread thread4 = new SomeThread(latch);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try
        {
            latch.await(); //Causes the current thread to wait until
                           // the latch has counted down to zero,
                           // unless the thread is interrupted.
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("In Main Thread " + Thread.currentThread().getName());
    }
}
