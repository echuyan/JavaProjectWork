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

        try {
            if (sum.checkSum(sum)) {
                System.out.println(sum.formatNumber(sum));
            } else {
                System.err.println("Некорректно введено число - выход за пределы граничных значений");
            }

        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            System.err.println("Некорректно введено число - введено не число");
        } finally {
            System.out.println("Вы ввели число: " + sum.getInput(sum));
        }
    }
}
