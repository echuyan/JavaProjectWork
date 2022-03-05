package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * число в рублях прописью
 * до триллионов
 */

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Введите целое число. Программа работает с целыми числами от нуля до трёх триллионов.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();

        Sum sum = new Sum(number);

        System.out.println(sum.checkAndTransformSum(sum));

    }
}

