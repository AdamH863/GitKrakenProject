import java.util.concurrent.atomic.AtomicLong;

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    // Constructor for the Main class
    public Main()  {
        // Create an array to hold 1000 thread objects
        Thread[] threads = new Thread[1000];

        // Create an AtomicLong to safely increment the sum across multiple threads
        final AtomicLong sum = new AtomicLong(0L);

        // Record the start time for performance measurement
        long startTime = System.currentTimeMillis();

        System.out.println("Creating Array of Threads");

        // Loop to initialize and start 1000 threads
        for (int x = 0; x < threads.length; x++)
        {
            // Create a new thread that will execute the Runnable
            threads[x] = new Thread(new Runnable() {
                @Override
                public void run() {
                    // Each thread increments the sum 1,000,000 times
                    for (int x = 0; x < 1000000; x++)
                    {
                        sum.incrementAndGet(); // Safely increment the sum
                    }
                }
            });
            // Start the thread
            threads[x].start();
        }

        System.out.println("Joining Threads");

        // Loop to wait for all threads to finish executing
        for (int x = 0; x < threads.length; x++)
        {
            try {
                // Wait for the thread to complete
                threads[x].join();
            } catch (InterruptedException e) {
                // Handle the exception if thread is interrupted
                throw new RuntimeException(e);
            }
        }

        // Print the final value of the sum
        System.out.println(sum);
        // Print the time taken to execute the threads
        System.out.println(System.currentTimeMillis() - startTime + " ms");
    }

    // Main method to run the application
    public static void main(String[] args)
    {
        // Create an instance of Main, which starts the thread execution
        Main app = new Main();
    }
}
