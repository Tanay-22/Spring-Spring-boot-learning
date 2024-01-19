import Volatile.App;

public class WaitNotify
{
    /*  BANKING SYSTEM USING WAIT-NOTIFY
        used when one thread is dependent on another
     */
    static int balance = 0;
    public void withdraw(int amount)
    {
        synchronized (this)
        {
            if (balance <= 0 || balance < amount)
            {
                try
                {
                    System.out.println("Waiting for balance updation");
                    wait(6000);
                    /*causes current thread to release the lock and wait until
                     either another thread invokes the notify() method or the notifyAll()
                     method for this object, or a specified amount of time has elapsed.
                     */
                }
                catch (InterruptedException e)
                {
//                    System.out.println("Interrupted");
                    balance -= amount;
                    System.out.println(amount + " withdrawn successfully and current balance is: " + balance);
                }
            }
        }

    }

    public void deposit(int amount)
    {
        balance += amount;
        System.out.println(amount + " deposited successfully");
        synchronized (this)
        {
            notifyAll();    //gives the notification to all waiting threads of a particular object
        }
    }

    public static void main(String[] args)
    {
        WaitNotify app = new WaitNotify();

        Thread thread1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                app.withdraw(1000);
            }
        });
        thread1.setName("Thread1");
        thread1.start();
        if(balance <= 0)
        {
            try
            {
                Thread.sleep(5000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
//        thread1.interrupt();
        /*used to interrupt the thread. If any thread is in sleeping
        or waiting state (i.e. sleep() or wait() is invoked) then using
        the interrupt() method, we can interrupt the thread execution by
        throwing InterruptedException.
        */


        Thread thread2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                app.deposit(2000);
                thread1.interrupt();
            }
        });
        thread2.setName("Thread2");
        thread2.start();
    }
}
