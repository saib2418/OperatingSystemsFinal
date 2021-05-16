
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class QuickSort extends RecursiveTask<Integer> {

	int first, last;
	int[] array;

	private int partition(int first, int last, int[] array) {

		int i = first;
		int j = last;
		int pivot = new Random().nextInt(j - i) + i;
		int temp = array[j];
		
		array[j] = array[pivot];
		array[pivot] = temp;
		j--;

		while (i <= j) {

			if (array[i] <= array[last]) {
				
				i++;
				continue;
				
			}

			if (array[j] >= array[last]) {
				
				j--;
				continue;
				
			}

			temp = array[j];
			array[j] = array[i];
			array[i] = temp;
			j--;
			i++;
			
		}

		temp = array[j + 1];
		array[j + 1] = array[last];
		array[last] = temp;
		return j + 1;
		
	}

	public QuickSort(int start, int end, int[] arr) {
		
		this.array = arr;
		this.first = start;
		this.last = end;
		
	}

	@Override
	protected Integer compute() {
		
		if (array.length > 100) {
			
			//QuickSort

			if (first >= last) {
				
				return null;
				
			}
			
			int pivot = partition(first, last, array);

			QuickSort left = new QuickSort(first, pivot - 1, array);

			QuickSort right = new QuickSort(pivot + 1, last, array);

			left.fork();
			
			right.compute();

			left.join();

		} else {

			//Insertion Sort
			
			int length = array.length;
			
			for (int i = 1; i < length; ++i) {
				
				int key = array[i];
				int j = i - 1;

				while (j >= 0 && array[j] > key) {
					
					array[j + 1] = array[j];
					j = j - 1;
					
				}
				
				array[j + 1] = key;
				
			}
		}
		
		return null;
		
	}

}