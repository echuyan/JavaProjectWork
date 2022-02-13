package app;

import app.enums.Currency;
import app.enums.Phrases;

public class Sum {

    private String input;
    private long number1;
    private int trillions;
    private int billions;
    private int millions;
    private int thousands;
    private int hundreds;
    private String result;
    private String[][] ed = {{"", ""}, {"один", "одна"}, {"два", "две"}, {"три", "три"}, {"четыре", "четыре"}, {"пять", "пять"}, {"шесть", "шесть"}, {"семь", "семь"}, {"восемь", "восемь"}, {"девять", "девять"}};
    private String[] des = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private String[] sotni = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private String[] desed = {"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};


    public Sum(String input) {
        this.input = input;
    }

    //геттер
    public String getInput(Sum sum) {
        return sum.input;
    }

    //проверка выхода за граничные значения и соответствия типу long
    public boolean checkSum(Sum sum) throws NumberFormatException {
        try {
            number1 = Long.valueOf(input);

            if (number1 < 0 || number1 > 3000000000000l) {
                return false;
            } else {
                return true;
            }
        } catch (NumberFormatException e) {
            throw e;
        }
    }


    //метод преобразования числа
    public String formatNumber(Sum sum) {

        long number = Long.valueOf(input);
        if (number == 0) {
            return "Ноль " + Currency.CUR3FORM.getForm();
        } else {
            //выделение из числа групп по тройкам разрядов
            trillions = (int) (number / 1000000000000l);
            billions = (int) ((number - (trillions * 1000000000000l)) / 1000000000);
            millions = (int) (number - (trillions * 1000000000000l) - (billions * 1000000000)) / 1000000;
            thousands = (int) (number - (trillions * 1000000000000l) - (billions * 1000000000) - (millions * 1000000)) / 1000;
            hundreds = (int) (number % 1000);

            result = "";

            result = result + partsOfNumberToWords(trillions, 1) + partsOfNumberToWords(billions, 2) + partsOfNumberToWords(millions, 3) +
                    partsOfNumberToWords(thousands, 4) + partsOfNumberToWords(hundreds, 5);

            if (hundreds == 0) {
                result = result + Currency.CUR3FORM.getForm();
            }
            String tempResult = result.trim();
            result = tempResult.replaceAll("\\s{2,}", " ");

            return result;
        }
    }

    private String partsOfNumberToWords(int partOfNumber, int groupNumber) {

        String text = "";
        if (partOfNumber != 0) {
            // Выделение цифры каждого из трёх разрядов
            int firstDigit = partOfNumber / 100;
            int secondDigit = (partOfNumber - (firstDigit * 100)) / 10;
            int thirdDigit = partOfNumber % 10;

            // Подготовка текста


            if (secondDigit == 1) {
                text = sotni[firstDigit] + " " + desed[thirdDigit] + " ";
            } else {
                text = sotni[firstDigit] + " " + des[secondDigit] + " ";
                if ((thirdDigit == 1 || thirdDigit == 2) && (groupNumber != 4)) {
                    text = text + ed[thirdDigit][0] + " ";
                } else {
                    text = text + ed[thirdDigit][1] + " ";
                }


            }

            // Добавление формы слова
            switch (groupNumber) {
                case 1:
                    text = text + Phrases.TRILLION.phrase(thirdDigit) + " ";
                    break;
                case 2:
                    text = text + Phrases.BILLION.phrase(thirdDigit) + " ";
                    break;
                case 3:
                    text = text + Phrases.MILLION.phrase(thirdDigit) + " ";
                    break;
                case 4:
                    if (secondDigit == 1) {
                        text = text + Phrases.THOUSAND.phrase(9) + " ";
                        break;
                    } else {
                        text = text + Phrases.THOUSAND.phrase(thirdDigit) + " ";
                        break;
                    }
                default:
                    break;
            }

            //Добавление валюты в нужной форрме
            int lastDigit = hundreds % 10;
            if (groupNumber == 5) {
                if (secondDigit == 1) {
                    text = text + Currency.CUR3FORM.getForm();

                } else {
                    switch (lastDigit) {
                        case 1:
                            text = text + Currency.CUR1FORM.getForm();
                            break;
                        case 2:
                        case 3:
                        case 4:
                            text = text + Currency.CUR2FORM.getForm();
                            break;
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 0:
                            text = text + Currency.CUR3FORM.getForm();
                            break;
                        default:
                            break;
                    }
                }

            }


        }


        return text;
    }
}





