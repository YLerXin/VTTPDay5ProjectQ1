package golproject;

import java.util.*;
import java.io.*;

public class BoardCreation {

    public int[][] BoardCreation(int[] size,int[] start,int[][] position){
        int[][] Board = new int[size[0]][size[1]];

            int x = 0;
    
            // Iterate through the rows of the Board starting from the start[0] position
            for (int i = start[0]; i < Board.length && x < position.length; i++) {
                // Variable y for columns in position matrix
                int y = 0;
                
                // Iterate through the columns of the Board starting from the start[1] position
                for (int k = start[1]; k < Board[i].length && y < position[x].length; k++) {
                    // If position[x][y] == 1, copy to Board[i][k]
                    if (position[x][y] == 1) {
                        Board[i][k] = 1;
                    }
                    y++; // Move to the next column in position
                }
                
                x++; // Move to the next row in position
            }
        
        for(int g=0; g < Board.length;g++){
            for(int v=0; v< Board[g].length;v++){
                System.out.print(Board[g][v]+" ");
            }
            System.out.println();
        }
        System.out.println("Original board");

        return Board;
    }

}
