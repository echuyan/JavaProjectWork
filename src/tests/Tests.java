package tests;

import app.Sum;
import org.junit.Assert;

public class Tests {

    public void testBoundaries() {
        Sum sumNegative = new Sum("-1000");
        Sum sumTooLarge = new Sum("4000000000000");
        String scenario = "Тест выхода за пределы граничных значений";


        try {
            Assert.assertTrue(sumNegative.checkAndTransformSum(sumNegative).equals("Некорректно введено число - выход за пределы граничных значений"));
            Assert.assertTrue(sumTooLarge.checkAndTransformSum(sumTooLarge).equals("Некорректно введено число - выход за пределы граничных значений"));
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
            System.err.println("Неверно работают граничные значения");
        }
    }

    public void testNotANumber() {
        Sum sumNotANumber = new Sum("dsg");

        String scenario = "Тест на ввод нечислового значения";


        try {
            Assert.assertTrue(sumNotANumber.checkAndTransformSum(sumNotANumber).equals("Некорректно введено число - введено не число"));

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
            System.err.println("Не прошли тест на ввод не числа");
        }
    }

    public void testZero() {

        String scenario = "Тест на ноль";

        Sum sumZero = new Sum("0");
        String expected = "Ноль рублей";

        try {
            Assert.assertTrue(sumZero.formatNumber(sumZero).equals(expected));


            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
            System.err.println("Не прошли тест на ноль");
        }
    }

    public void testDeclinations() {
        String scenario = "Тест на склонения";

        Sum sumThousand = new Sum("1000");
        String expectedThousand = "одна тысяча рублей";
        Sum sumThousandEleven = new Sum("1011");
        String expectedThousandEleven = "одна тысяча одиннадцать рублей";
        Sum sumThousandTwentyOne = new Sum("1021");
        String expectedThousandTwentyOne = "одна тысяча двадцать один рубль";
        Sum sumMillion = new Sum("1000000");
        String expectedMillion = "один миллион рублей";
        Sum sumMillionFour = new Sum("1000004");
        String expectedMillionFour = "один миллион четыре рубля";

        try {
            Assert.assertTrue(sumThousand.formatNumber(sumThousand).equals(expectedThousand));
            Assert.assertTrue(sumThousandEleven.formatNumber(sumThousandEleven).equals(expectedThousandEleven));
            Assert.assertTrue(sumThousandTwentyOne.formatNumber(sumThousandTwentyOne).equals(expectedThousandTwentyOne));
            Assert.assertTrue(sumMillion.formatNumber(sumMillion).equals(expectedMillion));
            Assert.assertTrue(sumMillionFour.formatNumber(sumMillionFour).equals(expectedMillionFour));

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
            System.err.println("Не прошли тест на склонения" + expectedThousand + sumThousand.formatNumber(sumThousand));
        }
    }

}
