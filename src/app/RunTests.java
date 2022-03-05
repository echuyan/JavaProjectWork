package app;

import tests.Tests;

public class RunTests {

    public static void main(String[] args) {
        System.out.println("\n\n-----------Running tests-----------\n\n");

        new Tests().testBoundaries();
        System.out.println("\n\n----------------------\n\n");


        new Tests().testZero();
        System.out.println("\n\n----------------------\n\n");

        new Tests().testDeclinations();
        System.out.println("\n\n----------------------\n\n");

        new Tests().testNotANumber();
        System.out.println("\n\n----------------------\n\n");

    }


}