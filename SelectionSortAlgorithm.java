
/**
 * Created by gregory on 2/17/16.
 */
public class SelectionSortAlgorithm implements SortingAlgorithm {

    public SelectionSortAlgorithm() {
    }

    /**
     * Returns the name of the sorting algorithm.
     *
     * @return a <code>String</code> corresponding to the sorting algorithm's
     * name
     */
    public String name() {
        return "Selection Sort";
    }

    /**
     * Sorts the given array using the Selection Sort Algorithm.
     *
     * @param xs an array of <code>Comparable</code> objects to be sorted
     */
    public void sort(Comparable[] xs) {
        for (int i = 0; i < xs.length; i++) {
            int min = i;
            for (int j = i + 1; j < xs.length; j++) {
                if (lessThan(xs[j], xs[i])) {
                    min = j;
                }
            }
            swap(xs, i, min);
        }
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
