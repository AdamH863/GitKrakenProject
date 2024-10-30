//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{

    public Main()
    {
        Thread[] threads = new Thread[1000];
        for (int x=0;x<1000;x++)
        {
            threads[x] = new Thread(new Runnable() {
                @Override
                public void run() {
                    long sum = 0;
                    for (int x=0;x<1000000;x++)
                    {
                        sum+=1;
                    }
                }
            });
            threads[x].start();
        }
    }

    public static void main(String[] args)
    {
        Main app=new Main();
    }
}