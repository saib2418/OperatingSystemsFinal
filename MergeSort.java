import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MergeSort<N extends Comparable<N>> extends RecursiveTask<List<N>> {
    private List<N> arrayOfElements;

    public MergeSort(List<N> elements) {
        this.arrayOfElements = new ArrayList<>(elements);
    }

    @Override
    protected List<N> compute() {
        if (this.arrayOfElements.size() <= 1)
            return this.arrayOfElements;
        else {
            final int pivot = this.arrayOfElements.size() / 2;
            MergeSort<N> threadLeft = new MergeSort<N>(this.arrayOfElements.subList(0, pivot));
            MergeSort<N> threadRight = new MergeSort<N>(this.arrayOfElements.subList(pivot, this.arrayOfElements.size()));

            threadLeft.fork();
            threadRight.fork();

            List<N> left = threadLeft.join();
            List<N> right = threadRight.join();

            return merge(left, right);
        }
    }

    private List<N> merge(List<N> left, List<N> right) {
        List<N> sorted = new ArrayList<>();
        while (!left.isEmpty() || !right.isEmpty()) {
            if (left.isEmpty())
                sorted.add(right.remove(0));
            else if (right.isEmpty())
                sorted.add(left.remove(0));
            else {
                if (left.get(0).compareTo(right.get(0)) < 0)
                    sorted.add(left.remove(0));
                else
                    sorted.add(right.remove(0));
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        List<Integer> result = forkJoinPool.invoke(new MergeSort<Integer>(Arrays.asList(7, 12, 19, 3, 18, 4, 2, 6, 15, 8, 10)));
        System.out.println(result);
    }
}
