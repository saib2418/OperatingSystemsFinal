import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class MergeSortTest {

    @Test
    public void test() {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        MergeSortTest objectOne = new MergeSortTest();
        List<Integer> result = pool.invoke(new MergeSort<Integer>(Arrays.asList(7, 12, 19, 3, 18, 4, 2, 6, 15, 8, 10)));
        Assert.assertArrayEquals(result,#not sure what to pass in here);
    }

}
