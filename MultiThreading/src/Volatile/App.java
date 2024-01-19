package Volatile;

public class App
{
    public static int balance = 0;
    public void withdraw(int amount)
    {
        if(balance <= 0)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        balance -= amount;
        System.out.println("DB");
    }
    public void deposit(int amount)
    {
        balance += amount;
        System.out.println("CR");
    }
    public static void main(String[] args)
    {
        App app = new App();

        Thread thread1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                app.withdraw(1000);
            }
        });
        thread1.setName("Thread 1");
        thread1.start();

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
                app.withdraw(2000);
            }
        });
        thread2.setName("Thread 2");
        thread2.start();
    }
}
