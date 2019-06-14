package Week1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private int trials;
    private double[] threshold;


    public PercolationStats(int n, int trials) {
//        Percolation percolation = new Percolation(n);
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        if (trials <= 0) {
            throw new IllegalArgumentException();
        }

        this.trials = trials;
        threshold = new double[trials];

        for ( int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while(!percolation.percolates()) {
                int r = StdRandom.uniform(1, n + 1);
                int c = StdRandom.uniform(1, n + 1);

                percolation.open(r, c);
            }

            threshold[i] = (double) percolation.numberOfOpenSites() / (n * n);
        }

    }

    public double mean() {
        return StdStats.mean(threshold);
    }

    public double stddev() {
        return StdStats.stddev(threshold);
    }

    public double confidenceLo() {
        return mean() - (1.96 * stddev() / Math.sqrt(trials));
    }

    public double confidenceHi() {
        return mean() + (1.96 * stddev() / Math.sqrt(trials));
    }

    public static void main(String[] args) {
        int gridSize = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats ps = new PercolationStats(gridSize, trials);
        System.out.println("mean\t\t = " + ps.mean());
        System.out.println("stddev\t\t = " + ps.stddev());
        System.out.println("95% confidence interval\t = [" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
    }
}
