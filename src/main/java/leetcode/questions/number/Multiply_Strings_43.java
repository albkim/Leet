package leetcode.questions.number;

import java.util.ArrayList;
import java.util.List;

/**
 Given two number represented as strings, return multiplication of the number as a string.

 Note:

 •The number can be arbitrarily large and are non-negative.
 •Converting the input string to integer is NOT allowed.
 •You should NOT use internal library such as BigInteger.

 */
public class Multiply_Strings_43 {

    public static String multiply(String num1, String num2) {
        if ((num1.equals("0")) || (num2.equals("0"))) {
            return "0";
        }

        List<Integer> answer = new ArrayList<>();

        for (int index = num2.length() - 1; index >= 0; index--) {
            for (int indexTwo = num1.length() - 1; indexTwo >= 0; indexTwo--) {
                int answerIndex = num2.length() + num1.length() - index - indexTwo - 2;
                int product = Integer.parseInt(String.valueOf(num2.charAt(index))) * Integer.parseInt(String.valueOf(num1.charAt(indexTwo)));

                int digit = 0;
                while (product > 0) {
                    int digitIndex = answerIndex + digit;
                    if (answer.size() > digitIndex) {
                        product += answer.get(digitIndex);
                    }
                    else {
                        while (answer.size() <= digitIndex) {
                            answer.add(0);
                        }
                    }

                    answer.set(digitIndex, product % 10);
                    product /= 10;
                    digit++;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int index = answer.size() - 1; index >= 0; index--) {
            result.append(answer.get(index));
        }
        return result.toString();
    }

}
