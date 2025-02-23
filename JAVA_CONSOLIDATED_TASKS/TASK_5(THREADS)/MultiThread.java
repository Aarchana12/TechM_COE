import java.util.Arrays;

class SortThread extends Thread {
    int[] arr;

    SortThread(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        Arrays.sort(arr);
    }
}

public class MultiThread {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {5, 2, 9, 1, 5, 6};
        SortThread t1 = new SortThread(arr);
        t1.start();
        t1.join();
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
