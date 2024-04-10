package com.pluralsight;

public class PracticeOperations {

    public static void main(String[] args) {
        String word1 = "Love";
        String word2 = "to";
        String word3 = "code";
        String Combination;
        Combination = word1 + " " + word2 + " " + word3;
        double numba = 18.31;
        double numba2 = 6.01;
        double numba3 = 20.12;

        double together = numba + numba2 + numba3;
        System.out.println(together);
        together = numba - numba2 - numba3;
        System.out.println(together);
        together = numba * numba2 * numba3;
        System.out.println(together);
        together = numba / numba2 / numba3;
        System.out.println(together);
        double accumulation = together + 10;
        System.out.println(accumulation);
        accumulation = accumulation + 100;
        System.out.println(accumulation);
        accumulation = accumulation + 1000;
        System.out.println(accumulation);
    }
}
