package org.example;

import java.io.IOException;

public class CountingValleys {

    public static void main(String[] args) throws IOException {
        int result = Result.countingValleys(12, "DDUUDDUDUUUD");
        System.out.println("result is " + result);
    }

}


class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */
    public static int countingValleys(int steps, String path) {
        double lowerRange = 2, upperRange = Math.pow(10, 6);
        if (steps < lowerRange || steps > upperRange) {
            throw new IllegalArgumentException("steps out of range");
        }
        if (!path.chars().allMatch(c -> c == 'U' || c == 'D')) {
            throw new IllegalArgumentException("path is invalid");
        }
        if (path.length() != steps) {
            throw new IllegalArgumentException("wrong path length");
        }
        int seaLevel = 0, valleysCounter = 0;
        for (int i = 0; i < path.length(); i++) {
            char step = path.charAt(i);
            if (step == 'U') { // up
                seaLevel++;
                if (seaLevel == 0) { // only counts upwards
                    valleysCounter++;
                }
            } else { // down
                seaLevel--;
            }
        }
        return valleysCounter;
    }

}