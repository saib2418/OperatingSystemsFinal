//package report;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

public class QuickSortTest {

    @Test
    public void test() {
        int[] inputArray = {7, 12, 19, 3, 18, 4, 2, 6, 15, 8, 10};
        int[] resultOne = {2, 3, 4, 6, 7, 8, 10, 12, 15, 18, 19};
        int n = inputArray.length;

        ForkJoinPool pool = ForkJoinPool.commonPool();
        QuickSortTest objectOne = new QuickSortTest();

        pool.invoke(new QuickSort(0, n - 1, inputArray));
        Assert.assertArrayEquals(resultOne, inputArray);

    }

}
