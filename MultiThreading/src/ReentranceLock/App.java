package ReentranceLock;
/*
A ReentrantLock is owned by the thread last
successfully locking, but not yet unlocking it.
A thread invoking lock will return, successfully
acquiring the lock, when the lock is not owned by
another thread. The method will return immediately
if the current thread already owns the lock
 */
public class App
{
    static int counter = 0;
    public static void main(String[] args)throws InterruptedException
    {
        Thread thread1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 1000; i++)
                {
                    App.counter++;
                }
            }
        });

        Thread thread2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 1000; i++)
                {
                    App.counter++;
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("The final value of counter is " + App.counter);
    }
}
