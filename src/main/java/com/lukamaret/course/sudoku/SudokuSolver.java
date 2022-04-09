package com.lukamaret.course.sudoku;

import java.io.*;
import java.util.*;

/**
 * @author Luka Maret
 * @version 1.0
 */
public class SudokuSolver {

    public static void main(String[] args) throws Exception {
        File file = new File("sudokus.txt");
        FileReader rd = new FileReader(file);

        while (true) {
            Grid grid = Grid.create(rd);
            if (grid == null) {
                break;
            }

            List<Grid> solutions = solve(grid);

            printSolutions(grid, solutions);
        }

        new SFrame();
    }

    public static List<Grid> solve(Grid grid) {
        List<Grid> solutions = new ArrayList<>();
        solve(grid, solutions);
        return solutions;
    }

    public static void solve(Grid grid, List<Grid> solutions) {

        if (solutions.size() >= 2) {
            return;
        }

        int loc = grid.findEmptyCell();

        if (loc < 0) {
            solutions.add(grid.clone());
            return;
        }

        for (int n = 1; n < 10; n++) {
            if (grid.set(loc, n)) {
                solve(grid, solutions);
                grid.clear(loc);
            }
        }

    }

    public static void printSolutions(Grid grid, List<Grid> solutions) {

        System.out.println("Original");
        System.out.println(grid);

        if (solutions.isEmpty()) {
            System.out.println("Unsolvable");
        } else if (solutions.size() == 1) {
            System.out.println("Solved");
        } else {
            System.out.println("At least two solutions");
        }

        for (Grid solution : solutions) {
            System.out.println(solution);
        }

        System.out.println();
        System.out.println();
    }

}
