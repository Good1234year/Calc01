import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calc {
    static int number1, number2, result;
    static char operator;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your operation:");
        String input = scanner.nextLine();
        calc(input);
    }

    public static String calc(String input) {
        char[] array = new char[10];
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            array[i] = input.charAt(i);
            if (array[i] == '+') {
                operator = '+';
                count++;
            }
            if (array[i] == '-') {
                operator = '-';
                count++;
            }
            if (array[i] == '*') {
                operator = '*';
                count++;
            }
            if (array[i] == '/') {
                operator = '/';
                count++;
            }
        if (count > 1) {
            throw new IllegalArgumentException("Only one operation allowed");
        }
        }
        String arrayString = String.valueOf(array);
        String[] arrayNumbers = arrayString.split("[+-/*]");
        String str1 = arrayNumbers[0];
        String str2 = arrayNumbers[1];
        String str3 = str2.trim();
        number1 = romanToNumber(str1);
        number2 = romanToNumber(str3);

        if (number1 <0 || number2 < 0) {
            result = 0;
        }
            else {
                result = calculated(number1, number2, operator);
            System.out.println("Result:");
            String resultRoman = convertNumToRoman(result);
            System.out.println(str1 + " " + operator + " " + str3 + " = " + resultRoman);
        }
        try {
            number1 = Integer.parseInt(str1);
            number2 = Integer.parseInt(str3);
            if (number1 <= 0 || number1 > 10 || number2 <= 0 || number2 > 10) {
                throw new IndexOutOfBoundsException("Numbers out of range");
            } else {
                result = calculated(number1, number2, operator);
                System.out.println("Result:");
                System.out.println(number1 + " " + operator + " " + number2 + " = " + result);
            }
        } catch (NumberFormatException e) {

            System.exit(0);
        }
        return null;

    }

    static int calculated(int num1, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception :" + e);
                    System.out.println("Only integer non-zero parameters allowed");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid operation sign");
        }
        return result;

    }

    private static String convertNumToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        return roman[numArabian];

    }
    static int romanToNumber(String roman) {
        try {
            switch (roman) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Invalid format");
        }
        return -1;
    }

}

