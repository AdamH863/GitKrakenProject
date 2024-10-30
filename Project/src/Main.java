import java.util.concurrent.atomic.AtomicLong;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{

    public Main()  {
        Thread[] threads = new Thread[1000];
        final AtomicLong sum = new AtomicLong(0L);
        System.out.println("Creating Array of Threads");
        for (int x=0;x<threads.length;x++)
        {
            threads[x] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int x=0;x<1000000;x++)
                    {
                        sum.incrementAndGet();
                    }
                }
            });
            threads[x].start();
        }

        System.out.println("Joining Threads");


        for (int x=0;x<threads.length;x++)
        {
            try {
                threads[x].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(sum);
    }

    public static void main(String[] args)
    {
        Main app=new Main();
    }
}