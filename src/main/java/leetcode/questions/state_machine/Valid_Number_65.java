package leetcode.questions.state_machine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 Validate if a given string is numeric.

 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true


 Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.


 -----------------------------------------------------------------------------------------------------------------


 Can solve with state machine.
 Start -> Sign, Number, DecimalPoint
 Sign -> Number
 Number -> Number, DecimalPoint, Exponent
 DecimalPoint -> Decimal
 Exponent -> Sign, Number

 */
public class Valid_Number_65 {

    private enum NumberState {
        Start,
        Sign,
        Number,
        DecimalPoint,
        Exponent,
        Invalid
    }

    public static boolean isNumber(String s) {
        Map<NumberState, Set<NumberState>> validTransitions = getValidTransitions();

        NumberState current = NumberState.Start;

        // pre process trim...since space is allowed on either side but on in between
        int left = 0;
        while ((left < s.length()) && (s.charAt(left) == ' ')) {
            left++;
        }
        int right = s.length() - 1;
        while ((right >= 0) && (s.charAt(right) == ' ')) {
            right--;
        }

        if (left > right) {
            return false;
        }

        boolean numberSeen = false;
        for (int index = left; index <= right; index++) {
            if (current == NumberState.DecimalPoint) {
                // after decimal point, the numbers cannot transition to another decimal
                validTransitions.get(NumberState.Number).remove(NumberState.DecimalPoint);
            }
            if (current == NumberState.Exponent) {
                validTransitions.get(NumberState.Number).remove(NumberState.DecimalPoint);
                validTransitions.get(NumberState.Number).remove(NumberState.Exponent);
                validTransitions.get(NumberState.Sign).remove(NumberState.DecimalPoint);
            }

            Set<NumberState> validTransition = validTransitions.get(current);
            NumberState nextState = getState(s.charAt(index));

            if (validTransition.contains(nextState)) {
                current = nextState;
                if (current == NumberState.Number) {
                    // this ensures that we have a number instead of just valid sequence. " ", or "-"
                    validTransitions.get(NumberState.DecimalPoint).add(NumberState.Exponent);
                    numberSeen = true;
                }
                continue;
            }
            else {
                return false;
            }
        }

        // do not agree but apparently it's valid to end the number like "3."
        return numberSeen && (
                (current == NumberState.Number) || (current == NumberState.DecimalPoint)
        );
    }

    private static NumberState getState(char chr) {
        if ((chr >= '0') && (chr <= '9')) {
            return NumberState.Number;
        }
        else if ((chr == '-') || (chr == '+')) {
            return NumberState.Sign;
        }
        else if (chr == '.') {
            return NumberState.DecimalPoint;
        }
        else if (chr == 'e') {
            return NumberState.Exponent;
        }

        return NumberState.Invalid;
    }

    private static Map<NumberState, Set<NumberState>> getValidTransitions() {
        Map<NumberState, Set<NumberState>> validTransitions = new HashMap<>();

        Set<NumberState> startSet = new HashSet<>();
        startSet.add(NumberState.Sign);
        startSet.add(NumberState.Number);
        startSet.add(NumberState.DecimalPoint);
        validTransitions.put(NumberState.Start, startSet);

        Set<NumberState> signSet = new HashSet<>();
        signSet.add(NumberState.Number);
        signSet.add(NumberState.DecimalPoint);
        validTransitions.put(NumberState.Sign, signSet);

        Set<NumberState> numberSet = new HashSet<>();
        numberSet.add(NumberState.Number);
        numberSet.add(NumberState.DecimalPoint);
        numberSet.add(NumberState.Exponent);
        validTransitions.put(NumberState.Number, numberSet);

        Set<NumberState> decimalPointSet = new HashSet<>();
        decimalPointSet.add(NumberState.Number);
        validTransitions.put(NumberState.DecimalPoint, decimalPointSet);

        Set<NumberState> exponentSet = new HashSet<>();
        exponentSet.add(NumberState.Sign);
        exponentSet.add(NumberState.Number);
        validTransitions.put(NumberState.Exponent, exponentSet);

        return validTransitions;
    }

}
