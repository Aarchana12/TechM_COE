class PrimeSumThread extends Thread {
    int start, end, sum = 0;

    PrimeSumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
    }
}

public class PrimeSum {
    public static void main(String[] args) throws InterruptedException {
        int limit = 50;
        PrimeSumThread t1 = new PrimeSumThread(1, limit / 2);
        PrimeSumThread t2 = new PrimeSumThread((limit / 2) + 1, limit);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        int totalSum = t1.sum + t2.sum;
        System.out.println("Sum of prime numbers up to " + limit + " is: " + totalSum);
    }
}
