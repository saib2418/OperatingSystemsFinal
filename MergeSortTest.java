import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import static org.junit.Assert.assertEquals;

public class MergeSortTest {

    @Test
    public void test() {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        List<Integer> output = new ArrayList<>(Arrays.asList(2, 3, 4, 6, 7, 8, 10, 12, 15, 18, 19));

        MergeSortTest objectOne = new MergeSortTest();
        List<Integer> result = pool.invoke(new MergeSort<Integer>(Arrays.asList(7, 12, 19, 3, 18, 4, 2, 6, 15, 8, 10)));
        assertEquals(result, output);
    }

}
