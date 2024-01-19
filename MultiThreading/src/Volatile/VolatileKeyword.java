package Volatile;

public class VolatileKeyword
{
    volatile public static int flag = 0; //can be accessed and modified by multiple threads
    public static void main(String[] args)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while(true)
                {
                    if(flag == 0)
                        System.out.println("Running");
                    else
                        break;
                }
            }
        }).start();

        new Thread(new Runnable()
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
                VolatileKeyword.flag = 1;
                System.out.println("Flag value updated");
            }
        }).start();

    }
}
