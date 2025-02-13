import java.util.*;

class ArrayListThread extends Thread {
    public void run() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        System.out.println("ArrayList: " + arrayList);
    }
}

class LinkedListThread extends Thread {
    public void run() {
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Dog");
        linkedList.add("Cat");
        linkedList.add("Rabbit");
        System.out.println("LinkedList: " + linkedList);
    }
}

class StackThread extends Thread {
    public void run() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: " + stack);
    }
}

class VectorThread extends Thread {
    public void run() {
        Vector<Double> vector = new Vector<>();
        vector.add(1.1);
        vector.add(2.2);
        vector.add(3.3);
        System.out.println("Vector: " + vector);
    }
}

public class ListSample {
    public static void main(String[] args) {
        ArrayListThread arrayListThread = new ArrayListThread();
        LinkedListThread linkedListThread = new LinkedListThread();
        StackThread stackThread = new StackThread();
        VectorThread vectorThread = new VectorThread();

        arrayListThread.start();
        linkedListThread.start();
        stackThread.start();
        vectorThread.start();
    }
}
