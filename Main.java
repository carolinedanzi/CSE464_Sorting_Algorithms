import org.math.plot.Plot2DPanel;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.IntStream;

/**
 * A simple driver for testing and plotting various sorting algorithms
 *
 * @author Gregory Gelfond
 * @version 1.0
 */
public class Main {

    public static final double NANOSECONDS_PER_MILLISECOND = 1000000.0;

    public static final int TEST_CASES_PER_BATCH = 100;

    public static final int[] TEST_CASE_SIZES =
    	{10,20,30,40,50,60,70,80,90,100};

    public static final int MIN = 0;

    public static final int MAX = 100;

    public static final Map<SortingAlgorithm, Color> algorithmColorMap;

    static {
        algorithmColorMap = new HashMap<>();
        algorithmColorMap.put(new SelectionSortAlgorithm(), Color.BLACK);
        algorithmColorMap.put(new QuicksortAlgorithm(), Color.BLUE);
    }

    /**
     * Generates an <code>IntStream</code> of <code>n</code> random integers from
     * the interval <code>[min,max)</code>.
     *
     * @param min the lower bound of the interval from which to select a random integer
     * @param max the upper bound of the interval from which to select a random integer
     * @param n   the size of the array to generate
     * @return an <code>IntStream</code>  of <code>n</code> random integers from the
     * interval <code>[min,max)</code>
     */
    public static IntStream testCase(int min, int max, int n) {
        Random generator = new Random();
        return generator.ints(min, max).limit(n);
    }

    /**
     * Generates a <code>List</code> of <code>size</code> test cases, where each test
     * case is an <code>IntStream</code> of <code>n</code> random integers from the
     * interval <code>[min,max)</code>
     *
     * @param min  the lower bound of the interval for a test case
     * @param max  the upper bound of the interval for a test case
     * @param n    the size of each test case
     * @param size the number of test cases to generate
     * @return a <code>List</code> of <code>size</code> test cases, where each test
     * case is an <code>IntStream</code> of <code>n</code> random integers from the
     * interval <code>[min,max)</code>
     */
    public static List<IntStream> testCases(int min, int max, int n, int size) {
        List<IntStream> testCases = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            testCases.add(testCase(min, max, n));
        }

        return testCases;

    }

    /**
     * Returns the average time needed to apply the <code>SortingAlgorithm</code> to
     * all of the given <code>testCases</code>.
     *
     * @param algorithm the <code>SortingAlgorithm</code>
     * @param testCases the test cases to apply the algorithm to
     * @return the average time needed to apply the <code>SortingAlgorithm</code> to
     * all of the given <code>testCases</code>
     */
    public static double timeTestCases(SortingAlgorithm algorithm, List<IntStream> testCases) {
        double total = 0;

        for (IntStream testCase : testCases) {
            total += timeTestCase(algorithm, testCase);
        }

        return total / testCases.size();
    }

    /**
     * Returns the total time in milliseconds needed to apply the <code>SortingAlgorithm</code>
     * to the given <code>testCase</code>.
     *
     * @param algorithm the <code>SortingAlgorithm</code>
     * @param testCase  the sequence of random integers to sort
     * @return the total time in milliseconds needed to apply the <code>SortingAlgorithm</code>
     * to the given <code>testCase</code>
     */
    public static double timeTestCase(SortingAlgorithm algorithm, IntStream testCase) {
        Integer[] xs = testCase.boxed().toArray(Integer[]::new);

        long startTime = System.nanoTime();
        algorithm.sort(xs);
        return (System.nanoTime() - startTime) / NANOSECONDS_PER_MILLISECOND;
    }

    /**
     * Returns an array of <code>double</code> values representing the compute time
     * for the given <code>SortingAlgorithm</code> over a set of random test cases.
     *
     * @param algorithm the <code>SortingAlgorithm</code> to use during evaluation
     * @return an array of <code>double</code> values representing the compute time
     * for the given <code>SortingAlgorithm</code> over a set of random test cases
     */
    public static double[] timingData(SortingAlgorithm algorithm) {
        double[] timingData = new double[TEST_CASE_SIZES.length];

        for (int dataPoint = 0; dataPoint < TEST_CASE_SIZES.length; dataPoint++) {
            List<IntStream> testSuite = testCases(MIN, MAX, TEST_CASE_SIZES[dataPoint], TEST_CASES_PER_BATCH);
            timingData[dataPoint] = timeTestCases(algorithm, testSuite);
        }

        return timingData;
    }

    public static void main(String[] args) {
        double[] sizeData = new double[TEST_CASE_SIZES.length];
        for (int i = 0; i < TEST_CASE_SIZES.length; i++) {
            sizeData[i] = TEST_CASE_SIZES[i];
        }

        Plot2DPanel plot = new Plot2DPanel();
        plot.setAxisLabels("Array Size", "Time (milliseconds)");

        for (Map.Entry<SortingAlgorithm, Color> plotInfo : algorithmColorMap.entrySet()) {
            SortingAlgorithm algorithm = plotInfo.getKey();
            Color plotColor = plotInfo.getValue();
            double[] computeTime = timingData(algorithm);
            plot.addLinePlot(algorithm.name(), plotColor, sizeData, computeTime);
        }

        plot.addLegend("SOUTH");

        JFrame frame = new JFrame();
        frame.setContentPane(plot);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
