package com.array;

import java.util.HashSet;
import java.util.Set;

public class TwoDArray {

    private static void replaceZero(int [][] matrix) {

        Set<Integer> zeroi = new HashSet<>();
        Set<Integer> zeroj = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroi.add(i);
                    zeroj.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (zeroi.contains(i) || zeroj.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
    public static void main(String[] args) {
//        int matrix[][] = {{1,1,1},{1,0,1},{1,1,1}};
        int matrix[][] = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
         replaceZero(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+ "");
            }
            System.out.println();
        }

     }
}
