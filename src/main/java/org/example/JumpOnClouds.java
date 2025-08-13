package org.example;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JumpOnClouds {

    public static void main(String[] args) throws IOException {

//      int result = Result.jumpingOnClouds(Arrays.asList(0, 0, 1, 0, 0, 1, 0));
//      int result = Result.jumpingOnClouds(Arrays.asList(0, 0, 0, 0, 1, 0));
        int result = Result.jumpingOnClouds(Arrays.asList(0, 0, 0, 1, 0, 0));
        System.out.println("required steps: " + result);

    }

    class Result {

        /*
         * Complete the 'jumpingOnClouds' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY c as parameter.
         */

        public static int jumpingOnClouds(List<Integer> c) {
            int steps = 0, position = 0;

            while (position < c.size() - 1) {
                if (position + 2 < c.size() && c.get(position + 2) == 0) {
                    position += 2;
                } else {
                    position += 1;
                }
                steps++;
            }
            return steps;
        }

    }
}
