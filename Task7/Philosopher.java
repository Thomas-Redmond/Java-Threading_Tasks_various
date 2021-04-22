public class Philosopher implements Runnable {

	 // The forks on either side of this Philosopher
    private Object leftFork;
    private Object rightFork;
    private int number;

    public Philosopher(Object leftFork, Object rightFork, int number) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.number = number;
    }

	private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }

    public void run() {
        try {
            while (true) {
              if(number % 2 == 1){ // If philosopher number is odd
                  // thinking
                  doAction(System.nanoTime() + ": Thinking");
                  synchronized (leftFork) {
                      doAction(System.nanoTime() + ": Picked up left fork");
                      synchronized (rightFork) {
                          // eating
                          doAction(System.nanoTime() + ": Picked up right fork - eating");
                          doAction(System.nanoTime() + ": Put down right fork");
                      }
                      // Back to thinking
                      doAction(System.nanoTime() + ": Put down left fork. Back to thinking");
                  }
                }
                else{
                  // thinking
                  doAction(System.nanoTime() + ": Thinking");
                  synchronized (rightFork) {
                      doAction(System.nanoTime() + ": Picked up right fork");
                      synchronized (leftFork) {
                          // eating
                          doAction(System.nanoTime() + ": Picked up left fork - eating");
                          doAction(System.nanoTime() + ": Put down left fork");
                      }
                      // Back to thinking
                      doAction(System.nanoTime() + ": Put down right fork. Back to thinking");
                }
              }
          }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
