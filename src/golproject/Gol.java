package golproject;

import java.io.*;
import java.util.*;

public class Gol {
    
    public void Gol(int[][] board, int gen, int[] size){
        int generation = 0;
        int maxrow = board.length;//height
        int maxcol = board[0].length;//width

        // Define the possible neighbor directions (relative to the current cell)
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1}, // Top-left, Top, Top-right
            {0, -1},         {0, 1},    // Left,       Right
            {1, -1}, {1, 0}, {1, 1}     // Bottom-left, Bottom, Bottom-right
        };

        // Run the game for the specified number of generations
        while (generation < gen) {

            // Create a new board for the next generation
            int[][] newBoard = new int[maxrow][maxcol];

            for (int i = 0; i < maxrow; i++) {
                for (int j = 0; j < maxcol; j++) {
                    // Count live neighbors
                    int liveNeighbors = 0;

                    // Loop through all 8 possible neighbors
                    for (int[] direction : directions) {
                        int neighborRow = i + direction[0];
                        int neighborCol = j + direction[1];

                        // Check if the neighbor is within bounds
                        if (neighborRow >= 0 && neighborRow < maxrow && neighborCol >= 0 && neighborCol < maxcol) {
                            if (board[neighborRow][neighborCol] == 1) {
                                liveNeighbors++;
                            }
                        }
                    }

                    // Apply Game of Life rules
                    if (board[i][j] == 1) {
                        // Live cell dies if it has fewer than 2 or more than 3 live neighbors
                        if (liveNeighbors < 2 || liveNeighbors > 3) {
                            newBoard[i][j] = 0;
                        } else {
                            newBoard[i][j] = 1; // Cell stays alive
                        }
                    } else {
                        // Dead cell becomes alive if it has exactly 3 live neighbors
                        if (liveNeighbors == 3) {
                            newBoard[i][j] = 1;
                        }
                    }
                }
            }

            // Update the board to the new generation
            board = newBoard;
            for (int i = 0; i < maxrow; i++) {
                for (int j = 0; j < maxcol; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("This is Generation: " + generation);

            generation++;
        }

        // Print final board
        for (int i = 0; i < maxrow; i++) {
            for (int j = 0; j < maxcol; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}




