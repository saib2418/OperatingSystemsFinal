

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

	@Test
	public void test() {
		int[] inputArray = { 7, 12, 19, 3, 18, 4, 2, 6, 15, 8, 10 };
		int[] resultOne = {2, 3, 4, 6 ,7, 8 ,10, 12, 15, 18, 19};
        int n = inputArray.length;
        
        ForkJoinPool pool = ForkJoinPool.commonPool();
        QuickSortTest objectOne = new QuickSortTest();
        
        pool.invoke(new QuickSort(0, n - 1, inputArray));
        Assert.assertArrayEquals(resultOne, inputArray);
        
        
		
	}
	@Test
	public void test2() {
		 int [] secondTest = new int[100];
	        for(int j = 0; j < 100; j++){
	        		secondTest[j] = (int)(Math.random() * 100);
	        		
	        }
	        ForkJoinPool pool = ForkJoinPool.commonPool();
	        QuickSortTest objectTwo = new QuickSortTest();
	        int[] clonearr = secondTest.clone();
	        Arrays.sort(clonearr);
	        pool.invoke(new QuickSort( 0, 100 - 1, secondTest));
	        Assert.assertArrayEquals(clonearr, secondTest);
   
	}
	
	

}
