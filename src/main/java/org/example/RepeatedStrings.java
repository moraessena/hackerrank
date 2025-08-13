package org.example;

public class RepeatedStrings {

    class ResultV1 {

        /*
         * Complete the 'repeatedString' function below.
         *
         * The function is expected to return a LONG_INTEGER.
         * The function accepts following parameters:
         *  1. STRING s
         *  2. LONG_INTEGER n
         */

        // abcac abcac abcac abcac

        public static long repeatedString(String s, long n) {
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() <= n) {
                sb.append(s);
            }
            return sb.toString().chars().limit(n).filter(c -> c == 'a').count();
        }

    }

    class ResultV2 {

        /*
         * Complete the 'repeatedString' function below.
         *
         * The function is expected to return a LONG_INTEGER.
         * The function accepts following parameters:
         *  1. STRING s
         *  2. LONG_INTEGER n
         */

        // abcac abcac abcac abcac

        public static long repeatedString(String s, long n) {
            var countAsInS = s.chars().filter(c -> c == 'a').count();
            var completeReps = n / s.length();
            var remainingChars = n % s.length();
            var total = countAsInS * completeReps;
            if (remainingChars > 0) {
                total += s.chars().limit(remainingChars).filter(c -> c == 'a').count();
            }
            return total;
        }

    }

    public static void main(String[] args) {
        long result = ResultV1.repeatedString("a", 1000000000000L);
        System.out.println("'a' count: " + result);
    }

}
