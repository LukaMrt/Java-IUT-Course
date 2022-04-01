package com.lukamaret.course.sudoku;

import java.io.*;

/**
 * @author Luka Maret
 * @version 1.0
 */
public class Grid implements Cloneable {

    int[] cells = new int[81];
    int[] colsSet = new int[9];
    int[] rowsSet = new int[9];
    int[] subgridSet = new int[9];

    /**
     * This method returns a grid of givens and empty cells ready to be solved.
     * The cells containing givens have values between 1 and 9.
     * Empty cells have the value 0.
     * <p>
     * Characters are read one at a time from the input stream and placed
     * into the grid in left-to-right and top-down order.
     * - The characters 0 or . indicates an empty cell.
     * - The characters 1 to 9 indicates a given.
     * - The character # is used for comments; subsequent characters are
     * ignored until a newline is encountered.
     * - All other characters are simply ignored.
     *
     * @param rd Reader containing the givens
     * @return null if there are not enough characters in 'rd' to form a grid.
     */
    public static Grid create(Reader rd) throws Exception {
        Grid grid = new Grid();

        for (int loc = 0; loc < grid.cells.length; ) {
            int character = rd.read();

            if (character < 0) {
                return null;
            }

            if (character == '#') {

                while (character >= 0 && character != '\n' && character != '\r') {
                    character = rd.read();
                }

            } else if (character >= '1' && character <= '9') {
                grid.set(loc, character - '0');
                loc++;
            } else if (character == '.' || character == '0') {
                loc++;
            }

        }

        return grid;
    }

    /*
     * Finds an empty cell.
     * @return the location of an empty cell or -1 if there are no empty cells.
     *         Values must be in the range [-1, 80].
     */
    public int findEmptyCell() {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    /*
     * Sets a number in a cell. This method checks to see if
     *   1. the cell is empty
     *   2. the cell is allowed to contain the specified number. E.g. if
     *      the number is 5 but the row already has a 5, the cell will
     *      not be set and false is returned.
     * @param loc  the location of the target cell.
     *             Values must be in the range [0, 80].
     * @param num  the number to set in the cell.
     *             Values must be in the range [1, 9].
     * @return     true if the set was successful.
     */
    public boolean set(int loc, int num) {
        // Compute row and column
        int r = loc / 9;
        int c = loc % 9;
        int blockLoc = (r / 3) * 3 + c / 3;

        boolean canSet = cells[loc] == 0
                && (colsSet[c] & (1 << num)) == 0
                && (rowsSet[r] & (1 << num)) == 0
                && (subgridSet[blockLoc] & (1 << num)) == 0;
        if (!canSet) {
            return false;
        }

        cells[loc] = num;
        colsSet[c] |= (1 << num);
        rowsSet[r] |= (1 << num);
        subgridSet[blockLoc] |= (1 << num);
        return true;
    }

    /*
     * Removes the number in a cell.
     * @param loc  the location of the target cell.
     *             Values must be in the range [0, 80].
     */
    public void clear(int loc) {
        // Compute row and column
        int r = loc / 9;
        int c = loc % 9;
        int blockLoc = (r / 3) * 3 + c / 3;

        int num = cells[loc];
        cells[loc] = 0;
        colsSet[c] ^= (1 << num);
        rowsSet[r] ^= (1 << num);
        subgridSet[blockLoc] ^= (1 << num);
    }


    /**
     * Returns a copy of this grid. Any modifications to the returned
     * grid will not affect this grid.
     *
     * @return a non-null deep copy of this grid.
     */
    @Override
    public Grid clone() {
        Grid grid = new Grid();
        grid.cells = cells.clone();
        grid.colsSet = colsSet.clone();
        grid.rowsSet = rowsSet.clone();
        grid.subgridSet = subgridSet.clone();
        return grid;
    }

    /**
     * Returns a string representing the current contents of the grid.
     * Used for debugging purposes.
     *
     * @return a non-null string representing the current contents of the grid.
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0) {
                buf.append("-------------------------\n");
            }
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0) {
                    buf.append("| ");
                }
                int num = cells[r * 9 + c];
                if (num == 0) {
                    buf.append(". ");
                } else {
                    buf.append(num).append(" ");
                }
            }
            buf.append("|\n");
        }
        buf.append("-------------------------");
        return buf.toString();
    }

}