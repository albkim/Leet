package leetcode.questions.number;

/**
 Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

 Consider signs
 Consider validation?
 Overflow?

 interesting, they want to allow spaces...
 interesting, they want to skip over invalid chars or spaces in the middle instead of returning error/0
 */
public class String_To_Integer_atoi_8 {

    public static int myAtoi(String str) {
        if ((str == null) || (str.length() == 0)) {
            return 0;
        }

        long result = 0;
        int negativeFactor = 1;
        boolean seenSign = false;
        boolean seenNumber = false;
        for (int index = 0; index < str.length(); index++) {
            if ((str.charAt(index) >= '0') && (str.charAt(index) <= '9')) {
                result = result * 10 + (str.charAt(index) - '0');
                seenNumber = true;
            }
            else if ((!seenSign) && (!seenNumber) && (str.charAt(index) == ' ')) {
                continue;
            }
            else if ((str.charAt(index) == '-') || (str.charAt(index) == '+')) {
                if ((!seenSign) && (!seenNumber)) {
                    if (str.charAt(index) == '-') {
                        negativeFactor = -1;
                    }
                    seenSign = true;
                    continue;
                }
                else {
                    return 0;
                }
            }
            else {
                break;
            }

            if (result > Integer.MAX_VALUE) {
                return (negativeFactor < 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }

        result *= negativeFactor;

        return (int)result;
    }

}
