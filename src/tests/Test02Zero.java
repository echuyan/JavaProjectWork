package tests;

import app.Sum;
import org.junit.Assert;

public class Test02Zero {


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
}
