class Semaphore {
    private int value;

    public Semaphore(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Semaphore value cannot be negative");
        }
        this.value = value;
    }

    public Semaphore() {
        this(0);
    }

    public synchronized void Wait() {
        while (this.value <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Semaphore::Wait() - caught InterruptedException: " + e.getMessage());
                e.printStackTrace();
            }
        }
        this.value--;
    }

    public synchronized void Signal() {
        ++this.value;
        notify();
    }

    public synchronized void P() {
        this.Wait();
    }

    public synchronized void V() {
        this.Signal();
    }
}
