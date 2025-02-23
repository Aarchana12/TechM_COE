class SharedResource {
    private int data;
    private boolean hasData = false;

    synchronized void put(int value) {
        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data = value;
        hasData = true;
        notify();
    }

    synchronized int get() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hasData = false;
        notify();
        return data;
    }
}

class Producer extends Thread {
    SharedResource res;

    Producer(SharedResource res) {
        this.res = res;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            res.put(i);
        }
    }
}

class Consumer extends Thread {
    SharedResource res;

    Consumer(SharedResource res) {
        this.res = res;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(res.get());
        }
    }
}

public class InterThreadDemo {
    public static void main(String[] args) {
        SharedResource res = new SharedResource();
        new Producer(res).start();
        new Consumer(res).start();
    }
}
