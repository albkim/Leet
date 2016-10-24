package leetcode.questions.number;

/**
 The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.


 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.

 */
public class Count_And_Say_38 {

    public static String countAndSay(int n) {
        String sequence = "1";

        for (int count = 1; count < n; count++) {
            int numberCounter = 1;
            char previous = sequence.charAt(0);
            
            StringBuilder newSequence = new StringBuilder();
            for (int index = 1; index < sequence.length(); index++) {
                char current = sequence.charAt(index);
                if (current != previous) {
                    newSequence.append(numberCounter);
                    newSequence.append(previous);

                    previous = current;
                    numberCounter = 1;
                }
                else {
                    numberCounter++;
                }
            }

            // last cleanup
            newSequence.append(numberCounter);
            newSequence.append(previous);

            sequence = newSequence.toString();
        }

        return sequence;
    }

}
