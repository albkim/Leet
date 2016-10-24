package leetcode.questions.number;

import java.util.HashMap;
import java.util.Map;

/**
 Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 For example,
 •Given numerator = 1, denominator = 2, return "0.5".
 •Given numerator = 2, denominator = 1, return "2".
 •Given numerator = 2, denominator = 3, return "0.(6)".

 -------------------------------------------------------------------------------------------------------

 Seems like it wants to implement division. The tricky part is to detect if there a repeated pattern. What
 if we store individual digits in an array and use to check for repeats

 */
public class Fraction_Recurring_Decimal_166 {

   public static String fractionToDecimal(int numerator, int denominator) {
       StringBuilder result = new StringBuilder();

       long numeratori = (long)numerator;
       long denominatori = (long)denominator;

       // need to handle the sign separately...because it could mess up remainder calculation
       // we should make both parts into positive and then consider sign separately
       if (((numeratori < 0) && (denominatori > 0)) || ((numeratori > 0) && (denominatori < 0))) {
           result.append("-");
       }

       numeratori = Math.abs(numeratori);
       denominatori = Math.abs(denominatori);

       // left part
       result.append(numeratori / denominatori);

       long remainder = numeratori % denominatori;

       if (remainder > 0) {
           // need decimal
           result.append('.');
           remainder *= 10;

           // use a map to track possible remainder / start index
           // if we see the same remainder then pattern would repeat from that index to now
           Map<Long, Integer> remainders = new HashMap<>();

           while(remainder > 0) {
               if (remainders.containsKey(remainder)) {
                   // we have seen this before. Now it can only repeat!
                   result.insert(remainders.get(remainder), "(");
                   // we have seen this before. Now it can only repeat!
                   result.append(')');
                   break;
               }

               // put the lookup
               remainders.put(remainder, result.length());

               // not big enough, need to move the digits and make it bigger
               if (remainder < denominatori) {
                   result.append("0");
                   remainder *= 10;
                   continue;
               }

               // add the result
               result.append(remainder / denominatori);

               // get new remainder
               remainder %= denominatori;

               remainder *= 10;
           }
       }

       return result.toString();
   }

}
