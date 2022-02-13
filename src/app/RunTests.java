package app;

import tests.Test01Boundaries;
import tests.Test02Zero;
import tests.Test03DeclinationsTest;

public class RunTests {

    public static void main(String[] args) {
        System.out.println("\n\n-----------Running tests-----------\n\n");

        new Test01Boundaries().testBoundaries();
        System.out.println("\n\n----------------------\n\n");


        new Test02Zero().testZero();
        System.out.println("\n\n----------------------\n\n");

        new Test03DeclinationsTest().testDeclinations();
        System.out.println("\n\n----------------------\n\n");

    }


}