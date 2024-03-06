import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] inputSizes = {1000, 10000, 100000};

        for (int size : inputSizes) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            LinkedList<Integer> linkedList = new LinkedList<>();

            long startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                arrayList.add(random.nextInt());
            }
            long arrayListAddTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                linkedList.add(random.nextInt());
            }
            long linkedListAddTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                arrayList.get(i);
            }
            long arrayListAccessTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                linkedList.get(i);
            }
            long linkedListAccessTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            for (int i = size - 1; i >= 0; i--) {
                arrayList.remove(i);
            }
            long arrayListRemoveTime = System.nanoTime() - startTime;

            startTime = System.nanoTime();
            for (int i = size - 1; i >= 0; i--) {
                linkedList.remove(i);
            }
            long linkedListRemoveTime = System.nanoTime() - startTime;

            System.out.println("Input Size: " + size);
            System.out.println("ArrayList Add Time: " + arrayListAddTime);
            System.out.println("LinkedList Add Time: " + linkedListAddTime);
            System.out.println("ArrayList Access Time: " + arrayListAccessTime);
            System.out.println("LinkedList Access Time: " + linkedListAccessTime);
            System.out.println("ArrayList Remove Time: " + arrayListRemoveTime);
            System.out.println("LinkedList Remove Time: " + linkedListRemoveTime);

            System.out.println("ArrayList Iteration Time:");
            startTime = System.nanoTime();
            Iterator<Integer> arrayListIterator = arrayList.iterator();

            while (arrayListIterator.hasNext()) {
                Integer element = arrayListIterator.next();
                System.out.print(element + "is part of the list");
            }

            long arrayListIterationTime = System.nanoTime() - startTime;
            System.out.println(arrayListIterationTime + " nanoseconds");

            System.out.println("LinkedList Iteration Time:");
            startTime = System.nanoTime();
            Iterator<Integer> linkedListIterator = linkedList.iterator();

            while (linkedListIterator.hasNext()) {
                Integer element = linkedListIterator.next();
                System.out.print(element + "is part of the list");
            }

            long linkedListIterationTime = System.nanoTime() - startTime;
            System.out.println(linkedListIterationTime + " nanoseconds");

            System.out.println();
        }
    }
}