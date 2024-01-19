public class UnSynchronization
{
    public static int counter = 0;

    public static void main(String[] args) throws InterruptedException
    {
        Thread thread1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 10000; i++)
                {
                    UnSynchronization.counter++;
                }
            }
        });

        System.out.println(UnSynchronization.counter);


        Thread thread2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 10000; i++)
                {
                    UnSynchronization.counter++;
                }
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(2000); // UN-SYNCHRONISED
        System.out.println(UnSynchronization.counter);
    }
}
