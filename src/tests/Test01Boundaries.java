package tests;


import app.Sum;
import org.junit.Assert;

public class Test01Boundaries {

    public void testBoundaries() {
        Sum sumNegative = new Sum("-1000");
        Sum sumTooLarge = new Sum("4000000000000");
        String scenario = "Тест выхода за пределы граничных значений";


        try {
            Assert.assertTrue(!sumNegative.checkSum(sumNegative));
            Assert.assertTrue(!sumTooLarge.checkSum(sumTooLarge));
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
            System.err.println("Неверно работают граничные значения");
        }
    }
}
