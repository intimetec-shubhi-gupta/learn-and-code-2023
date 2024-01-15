import java.util.Arrays;
import java.util.Scanner;

public class KarpekarConstant
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a four-digit number: ");
        int value = scanner.nextInt();
        
        if (isValidFourDigitNumber(value)) {
            System.out.println("Iterations to reach Kaprekar Constant:");
            findKaprekarConstant(value);
        } else {
            System.out.println("Invalid input. Please enter a four-digit number.");
        }
        scanner.close();
    }

    public static boolean isValidFourDigitNumber(int value) {
        return value >= 1000 && value <= 9999;
    }

    public static void findKaprekarConstant(int value) {
        int kaprekar = 6174;
        while (value != kaprekar) {
            int[] digits = getDigits(value);
            int ascending = getAscendingValue(digits);
            int descending = getDescendingValue(digits);
            value = Math.abs(descending - ascending);
            System.out.println(String.valueOf(descending) + " - " + String.valueOf(ascending) + " = " + String.valueOf(value));

        }
    }

    public static int[] getDigits(int value) {
        int[] digits = new int[4];
        for (int index= 0; index< 4; index++) {
            digits[index] = value % 10;
            value /= 10;
        }
        return digits;
    }

    public static int getAscendingValue(int[] digits) {
        int value = 0;
        Arrays.sort(digits);
        for (int digit : digits) {
            value = value * 10 + digit;
        }
        return value;
    }

    public static int getDescendingValue(int[] digits) {
        int value = 0;
        for (int index= 3; index>= 0; index--) {
            value = value * 10 + digits[index];
        }
        return value;
    }
}
