package com.shivam.practice.PracticeProblems.Pattern_PrintingRecursively;

public class StarPrint {
    public static void main(String[] args) {
        int n = 5;
        starPrint(n);
    }

    public static void starPrint(int n) { // for next row
        if (n == 0) return;


        star(n);
        System.out.println();
        starPrint(n - 1);  // breaking into smaller problem

    }

    public static void star(int n) { // for coln print
        if (n == 0) {
            return;
        }

        System.out.print("* ");
        star(n -1);


    }

}
