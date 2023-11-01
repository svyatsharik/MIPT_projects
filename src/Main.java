import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
  public static int[] arr = new int[101];
  public static int[] counter = new int[2];

  public static class Gamer implements Runnable {
    private final String name;
    private final CountDownLatch latch;


    public Gamer(String name, CountDownLatch latch) {
      this.name = name;
      this.latch = latch;
    }

    @Override
    public void run() {
      while (latch.getCount() > 0) {
        try {
          Random rn = new Random();
          int elem = rn.nextInt(101);
          if (arr[elem] == 0) {
            arr[elem]++;
            if (this.name.equals("first_gamer")) counter[0]++;
            else counter[1]++;
            latch.countDown();
          }
          Thread.sleep(1);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          return;
        }
      }
    }
  }

  public static class Referee implements Runnable {
    private final CountDownLatch latch;

    public Referee(CountDownLatch latch) {
      this.latch = latch;
    }

    @Override
    public void run() {
      try {
        latch.await();
        if (counter[0] > counter[1]) System.out.println("First gamer is winner!");
        else System.out.println("Second gamer is winner!");

      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return;
      }
    }
  }
  public static void main(String[] args) throws InterruptedException {
    var latch = new CountDownLatch(101);
    var executor = Executors.newCachedThreadPool();
    Gamer g1 = new Gamer("first_gamer", latch);
    Gamer g2 = new Gamer("second_gamer", latch);
    executor.submit(g1);
    executor.submit(g2);
    executor.submit(new Referee(latch));
    executor.shutdown();
  }
}