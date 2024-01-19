
class Brackets
{
    /*private Object lock = "lock";*/
    /*private static String threadCode;*/

    /*public Brackets(String threadCode)
    {
        this.threadCode = threadCode;
    }*/

    synchronized public static void generate(String threadCode) // SYNCHRONISED FUNCTION WILL ONLY WORK IF USED FOR
    {
        /*synchronized (lock)
        {*/
            for (int i = 0; i < 10; i++)
            {
                /*try
                {
                    Thread.sleep(10);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }*/
                if (i < 5)
                    System.out.print("[");
                else
                    System.out.print("]");
            }
            System.out.println("Generated by thread: " + threadCode);
        /*}*/
        /*for (int j = 0; j < 10; j++)
        {
            try
            {
                Thread.sleep(25);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }*/
    }
}

public class Synchronization
{
    public static void main(String[] args)
    {
        /*Brackets bracket1 = new Brackets("Thread 1");
        Brackets bracket2 = new Brackets("Thread 2");*/
//        brackets.generate();
        Thread thread1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                long startTime = System.currentTimeMillis();
                for (int i = 0; i <5; i++)
                {
                    Brackets.generate("Thread 1");
                }
                long endTime = System.currentTimeMillis();
                System.out.println("Time required for thread 1 was: " + startTime + " " + endTime);
            }
        });

        Thread thread2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                long startTime = System.currentTimeMillis();
                for (int i = 0; i <5 ; i++)
                {
                    Brackets.generate("Thread 2");
                }
                long endTime = System.currentTimeMillis();
                System.out.println("Time required for thread 2 was: " + startTime + " " + endTime);
            }
        });
        thread1.start();
        thread2.start();
    }
}
