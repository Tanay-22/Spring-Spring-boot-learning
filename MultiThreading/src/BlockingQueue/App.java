package BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

class Producer implements Runnable
{
    ArrayBlockingQueue<Integer> queue; //A High Performance Data Structure for a Multithreaded Application

    public Producer(ArrayBlockingQueue<Integer> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                Thread.sleep(1000);
                queue.put(App.counter++);
                System.out.println("Value added in the queue - " + App.counter);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable
{
    ArrayBlockingQueue<Integer> queue; //A High Performance Data Structure for a Multithreaded Application

    public Consumer(ArrayBlockingQueue<Integer> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                Thread.sleep(5000);
                queue.take();
                App.counter--;
                System.out.println("Value removed in the queue - " + App.counter);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
public class App
{
    static  int counter = 0;
    public static void main(String[] args)
    {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        Producer produce = new Producer(queue);
        Thread producerThread = new Thread(produce);
        producerThread.start();

        Consumer consume = new Consumer(queue);
        Thread consumerThread = new Thread(consume);
        consumerThread.start();
    }
}
