package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HourglassSum {

    class Result {

        /*
         * Complete the 'hourglassSum' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts 2D_INTEGER_ARRAY arr as parameter.
         */
        public static int hourglassSum(List<List<Integer>> arr) {
            List<Integer> hourGlassSumValues = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.println("hourglass from row [" + i + "] | col [" + j + "]");
                    var hourGlass = extractHourGlass(i, j, arr);
                    var hourGlassSum = sumHourGlass(hourGlass);
                    hourGlassSumValues.add(hourGlassSum);
                }
                System.out.println();
            }
            return Collections.max(hourGlassSumValues);
        }

        private static Integer sumHourGlass(List<List<Integer>> hourGlass) {
            int sum = 0;
            for (int i = 0; i < hourGlass.size(); i++) {
                for (int j = 0; j < hourGlass.get(i).size(); j++) {
                    if ((i == 1) && (j == 0 || j == 2)) {
                        continue;
                    }
                    sum += hourGlass.get(i).get(j);
                }
            }
            return sum;
        }

        private static List<List<Integer>> extractHourGlass(int i, int j, List<List<Integer>> arr) {
            List<List<Integer>> hourGlass = new ArrayList<>();
            System.out.println("printando sub-matrix");
            int rowLimit = i + 2;
            int colLimit = j + 2;
            for (int row = i; row <= rowLimit; row++) {
                List<Integer> hourGlassRow = new ArrayList<>(3);
                for (int col = j; col <= colLimit; col++) {
                    System.out.print(arr.get(row).get(col));
                    hourGlassRow.add(arr.get(row).get(col));
                }
                hourGlass.add(hourGlassRow);
                System.out.println();
            }
            System.out.println("fim sub-matrix");
            return hourGlass;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();

        // Initialize the 2D array with the given data
        arr.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        arr.add(Arrays.asList(0, 1, 0, 0, 0, 0));
        arr.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        arr.add(Arrays.asList(0, 0, 2, 4, 4, 0));
        arr.add(Arrays.asList(0, 0, 0, 2, 0, 0));
        arr.add(Arrays.asList(0, 0, 1, 2, 4, 0));

        int result = Result.hourglassSum(arr);
        System.out.println("max value from hourglasses is " + result);
    }

}
