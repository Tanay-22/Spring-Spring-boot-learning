package Join;

public class App
{
    public int counter = 0;

    public static void main(String[] args)
    {
        App app = new App();

        Thread thread1 =new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 10000; i++)
                {
                    app.counter++;
                }
            }
        });

        Thread thread2 =new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    thread1.join();     // thread 2 waits for thread 1
                }
                catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
                for (int i = 0; i < 10000; i++)
                {
                    app.counter++;
                }
            }
        });
        thread1.start();
        thread2.start();

        try
        {
            thread2.join();     // main thread waits for thread 2
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        System.out.println("Counter = " + app.counter);
    }
}
