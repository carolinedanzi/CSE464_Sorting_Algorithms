
/**
 * An implementation of the Quicksort Algorithm using the Hoare Parittion Scheme.
 *
 * @author Gregory Gelfond
 * @version 1.0
 */
public class QuicksortAlgorithm implements SortingAlgorithm {

    public QuicksortAlgorithm() {
    }

    /**
     * Returns the name of the sorting algorithm.
     *
     * @return a <code>String</code> corresponding to the sorting algorithm's
     * name
     */
    public String name() {
        return "Quicksort";
    }

    /**
     * @param xs an array of <code>Comparable</code> objects to be sorted
     */
    public void sort(Comparable[] xs) {
        sort(xs, 0, xs.length - 1);
    }

    /**
     * Sorts the elements of <code>xs[lo..hi]</code> in ascending order. The indices
     * <code>[lo..hi]</code> are inclusive on both the left and the right.
     *
     * @param xs an array of <code>Comparable</code> objects to be sorted
     * @param lo a valid index into <code>xs</code> denoting the lower bound of the
     *           indices <code>[lo..hi]</code> over which to sort
     * @param hi a valid index into <code>xs</code> denoting the upper bound of the
     *           indices <code>[lo..hi]</code> over which to sort
     */
    private static void sort(Comparable[] xs, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(xs, lo, hi);

            if (lo < pivot - 1) {
                sort(xs, lo, pivot - 1);
            }

            if (hi > pivot) {
                sort(xs, pivot, hi);
            }
        }
    }

    /**
     * If <code>xs</code> is an array of integers and <code>lo</code> and <code>hi</code>
     * are valid indices into <code>xs</code> denoting the interval <code>[lo..hi]</code>,
     * then <code>partition(xs,lo,hi)</code> does the following:
     * <ul>
     * <li>Partitions the elements of <code>xs</code> such that <code>xs[lo..j-1] <= xs[j]</code>
     * and <code>xs[j] <= xs[j+1..hi]</code></li>
     * <li>Returns the index <code>j</code></li>
     * </ul>
     *
     * @param xs an array of <code>Comparable</code> objects to be partitioned
     * @param lo a valid index into <code>xs</code> denoting the lower bound of the
     *           indices to partition
     * @param hi a valid index into <code>xs</code> denoting the upper bound of the
     *           indices to partition
     * @return the index position <code>j</code> such that <code>xs[lo..j-1] <= xs[j]</code>
     * and <code>xs[j] <= xs[j+1..hi]</code></li>
     */
    private static int partition(Comparable[] xs, int lo, int hi) {
        int i = lo;
        int j = hi;
        Comparable pivotValue = xs[i];

        while (i <= j) {
            while (lessThan(xs[i], pivotValue)) {
                i++;
            }
            while (lessThan(pivotValue, xs[j])) {
                j--;
            }

            if (i <= j) {
                swap(xs, i, j);
                i++;
                j--;
            }
        }

        return i;
    }

    /**
     * The function <code>lessThan</code> is a generalization of the relational operator
     * <code><</code> to objects which implement the <code>Comparable</code> interface.
     * If <code>x</code> and <code>y</code> are <code>Comparable</code> objects then
     * <code>lessThan(x,y)</code> is <code>true</code> if and only if <code>x < y</code>.
     *
     * @param x a <code>Comparable</code> object to compare
     * @param y a <code>Comparable</code> object to compare
     * @return <code>true</code> if <code>x < y</code> and <code>false</code> otherwise
     */
    private static boolean lessThan(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    /**
     * The function <code>swap</code> is a helper function for swapping the elements of an array.
     * If <code>xs</code> is an array of <code>Comparable</code> objects and <code>i</code> and
     * <code>j</code> are valid indices into <code>xs</code>, then <code>swap(xs,i,j)</code>
     * exchanges the ith and jth elements of <code>xs</code>.
     *
     * @param xs the array in which to swap the elements
     * @param i  a valid index into <code>xs</code> denoting an object to swap
     * @param j  a valid index into <code>xs</code> denoting an object to swap
     */
    private static void swap(Comparable[] xs, int i, int j) {
        Comparable tmp = xs[i];
        xs[i] = xs[j];
        xs[j] = tmp;
    }

}


