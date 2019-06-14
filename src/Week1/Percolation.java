package Week1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Percolation {

    private boolean[] sites;

    private int gridLength;

    private int virtualTop;

    private int virtualBottom;

    private WeightedQuickUnionUF ufPercolation;

    private WeightedQuickUnionUF ufPercolationFullness;

    private int openSites;


    public Percolation(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        gridLength = n;
        sites = new boolean[n * n + 2];
        virtualTop = 0;
        virtualBottom = n * n + 1;
        openSites = 0;

        sites[virtualTop] = true;

        ufPercolation = new WeightedQuickUnionUF(n * n + 2);
        ufPercolationFullness = new WeightedQuickUnionUF(n * n + 2);

        // connecting top row to virtual top and bottom to virtual bottom
        for (int i = 1; i <= gridLength; i++) {
            ufPercolation.union(virtualTop, getIndex(1, i));
            ufPercolation.union(virtualBottom, getIndex(gridLength, i));
            ufPercolationFullness.union(virtualTop, getIndex(1, i));
        }

    }

    private boolean validateIndex(int row, int column) {
        if (row >= 1 && row <= gridLength && column >= 1 && column <= gridLength) {
            return true;
        }

        throw new IllegalArgumentException();
    }

    private int getIndex(int row, int column) {
        validateIndex(row, column);
        return (row - 1) * gridLength + column;
    }

    public void open(int row, int column) {
        int index = getIndex(row, column);

        if (sites[index]) {
            return;
        }
        // incrementing open sites count
        openSites++;
        sites[index] = true;

        // left
        if (column - 1 > 0 && isOpen(row, column - 1)) {
            ufPercolation.union(index, getIndex(row, column - 1));
            ufPercolationFullness.union(index, getIndex(row, column - 1));
        }
        // right
        if (column + 1 <= gridLength && isOpen(row, column + 1)) {
            ufPercolation.union(index, getIndex(row, column + 1));
            ufPercolationFullness.union(index, getIndex(row, column + 1));
        }
        // top
        if (row - 1 > 0 && isOpen(row - 1, column)) {
            ufPercolation.union(index, getIndex(row - 1, column));
            ufPercolationFullness.union(index, getIndex(row - 1, column));
        }
        // bottom
        if (row + 1 <= gridLength && isOpen(row + 1, column)) {
            ufPercolation.union(index, getIndex(row + 1, column));
            ufPercolationFullness.union(index, getIndex(row + 1, column));
        }

    }

    public boolean isOpen(int row, int column) {
        return sites[getIndex(row, column)];
    }

    public boolean isFull(int row, int column) {
        int index = getIndex(row, column);
        if (isOpen(row, column) && ufPercolationFullness.connected(virtualTop, index)) {
            return true;
        }
        return false;
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {

        if (gridLength == 1) {
            return sites[1];
        }

        return ufPercolation.connected(virtualTop, virtualBottom);
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/palashjain/Documents/SelfLearn/Algorithms/Week1/percolation/input1.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int i = 0;

        Percolation per = new Percolation(10);
        while ((st = br.readLine()) != null) {
            if (i == 0) {
                per = new Percolation(Integer.parseInt(st));
                i++;
                continue;
            }

            String[] cood = st.trim().split(" ");
            int[] cood1 = new int[2];
            cood1[0] = Integer.parseInt(cood[0]);
            cood1[1] = Integer.parseInt(cood[1]);

            per.open(cood1[0], cood1[1]);
        }

        System.out.println(per.percolates());
    }
}

