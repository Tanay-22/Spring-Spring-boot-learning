import java.util.Random;

class MyCounter /*extends Thread*/ implements Runnable
{
    private int threadsNo;

    public MyCounter(int threadsNo)
    {
        this.threadsNo = threadsNo;
    }

    @Override
    public void run()
    {
//        countMe();
        Random random = new Random();
        for (int i = 0; i < 10; i++)
        {
            try
            {
                Thread.sleep(random.nextInt(5000));
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("Value of is " + i + " and the thread number is: " + threadsNo);
        }
    }

    /*public void countMe()
    {
        for (int i = 0; i < 10; i++)
        {
            try
            {
                sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(i + " Thread No. - " + threadsNo);

        }
    }*/
}

public class App
{
    public static void main(String[] args) throws InterruptedException
    {
        /*MyCounter counter1 = new MyCounter(1);
        MyCounter counter2 = new MyCounter(2);*/

        /*long startTime = System.currentTimeMillis();
//        System.out.println("Start time : " + startTime);
//        counter1.run();
        counter1.start();
        System.out.println("************");
//        counter2.run();
        counter2.start();   // ACTUAL JAVA MULTI-THREADING
        Thread.sleep(5015);
        long endTime = System.currentTimeMillis();
//        System.out.println("End Time : " + endTime);
        System.out.println("Total Time taken : " + (endTime - startTime) + "ms");*/

        /*Thread th1 = new Thread(new MyCounter(1));
        Thread th2 = new Thread(new MyCounter(2));

        th1.start();
        th2.start();*/

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 10; i++)
                {
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
            }
        }).start();
    }
}