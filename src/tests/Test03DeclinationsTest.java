package tests;

import app.Sum;
import org.junit.Assert;

public class Test03DeclinationsTest {


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
