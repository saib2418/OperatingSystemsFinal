//package report;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class QuickSort
        extends RecursiveTask<Integer> {

    int head, tail;
    int[] arrayOfElements;

    private int partion(int head, int tail, int[] arrayOfElements) {

        int i = head, j = tail;


        int pivote = new Random()
                .nextInt(j - i)
                + i;


        int temp = arrayOfElements[j];
        arrayOfElements[j] = arrayOfElements[pivote];
        arrayOfElements[pivote] = temp;
        j--;


        while (i <= j) {

            if (arrayOfElements[i] <= arrayOfElements[tail]) {
                i++;
                continue;
            }

            if (arrayOfElements[j] >= arrayOfElements[tail]) {
                j--;
                continue;
            }

            temp = arrayOfElements[j];
            arrayOfElements[j] = arrayOfElements[i];
            arrayOfElements[i] = temp;
            j--;
            i++;
        }


        temp = arrayOfElements[j + 1];
        arrayOfElements[j + 1] = arrayOfElements[tail];
        arrayOfElements[tail] = temp;
        return j + 1;
    }


    public QuickSort(int head, int tail, int[] arr) {
        this.arrayOfElements = arr;
        this.head = head;
        this.tail = tail;
    }

    @Override
    protected Integer compute() {

        if (head >= tail)
            return null;

        int p = partion(head, tail, arrayOfElements);
        QuickSort threadLeft = new QuickSort(head, p - 1, arrayOfElements);
        QuickSort threadRight = new QuickSort(p + 1, tail, arrayOfElements);


        threadLeft.fork();
        threadRight.compute();


        threadLeft.join();


        return null;
    }


    public static void main(String args[]) {

        int[] inputArray = {7, 12, 19, 3, 18, 4, 2, 6, 15, 8, 10};
        int n = inputArray.length;


        ForkJoinPool pool = ForkJoinPool.commonPool();


        pool.invoke(new QuickSort(0, n - 1, inputArray));

        for (int i = 0; i < n; i++)
            System.out.print(inputArray[i] + " ");
    }
}
