package leetcode.questions.number;

/**
 Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 For example:

 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

 Follow up:
 Could you do it without any loop/recursion in O(1) runtime?

 Hint:
 1.A naive implementation of the above process is trivial. Could you come up with other methods?
 2.What are all the possible results?
 3.How do they occur, periodically or randomly?
 4.You may find this Wikipedia article useful.

 ----------------------------------------------------------------------------------------------------

 No idea who would ask this question but...it's about digital root. Here is the formula

 1 + ((n - 1) % 9)
 */
public class Add_Digits_258 {

    public static int addDigits(int num) {
        return  1 + ((num - 1) % 9);
    }

}
