package leetcode.questions;

import java.util.ArrayList;
import java.util.List;

/**
 Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 Pad extra spaces ' ' when necessary so that each line has exactly L characters.

 Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide
 evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is inserted between words.

 For example,
 words: ["This", "is", "an", "example", "of", "text", "justification."]
 L: 16.

 Return the formatted lines as:

 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]

 Note: Each word is guaranteed not to exceed L in length.



 --------------------------------------------------------------------------------------------------------------------


 Seems pretty simple, greedily assigns words to a line until we run out, back track and distribute the spaces



 */
public class Text_Justification_68 {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();

        int wordIndex = 0;
        int wordLength = 0;
        int spaceLength = 0;
        List<String> line = new ArrayList<>();
        while (wordIndex < words.length) {
            String word = words[wordIndex];
            int spaceLeft = maxWidth - wordLength - spaceLength;
            int spaceNeeded = (line.size() == 0) ? 0 : 1;
            if ((word.length() + spaceNeeded) <= spaceLeft) {
                // we can assign this word then
                line.add(word);

                wordLength += word.length();
                spaceLength += spaceNeeded;

                wordIndex++;
            }
            else {
                // we need to create the line, and let this re-loop
                processLine(maxWidth, result, wordLength, line, false);

                line.clear();
                wordLength = 0;
                spaceLength = 0;
            }
        }

        // left over
        processLine(maxWidth, result, wordLength, line, true);

        return result;
    }

    private static void processLine(int maxWidth, List<String> result, int wordLength, List<String> line, boolean lastLine) {
        int spaceToDistribute = maxWidth - wordLength;
        int wordsToDistribute = line.size() - 1;

        StringBuilder lineResult = new StringBuilder();

        if (wordsToDistribute > 0) {
            if (lastLine) {
                for (int lineWordIndex = 0; lineWordIndex < line.size(); lineWordIndex++) {
                    lineResult.append(line.get(lineWordIndex));
                    lineResult.append(" ");
                }
                int currentLength = lineResult.length();
                for (int spaceCount = currentLength; spaceCount < maxWidth; spaceCount++) {
                    lineResult.append(" ");
                }
            }
            else {
                int normalSpace = spaceToDistribute / wordsToDistribute;
                int extraSpace = spaceToDistribute % wordsToDistribute;

                for (int lineWordIndex = 0; lineWordIndex < line.size(); lineWordIndex++) {
                    lineResult.append(line.get(lineWordIndex));
                    if (lineWordIndex < wordsToDistribute) {
                        for (int spaceCount = 0; spaceCount < normalSpace; spaceCount++) {
                            lineResult.append(" ");
                        }
                        if (lineWordIndex < extraSpace) {
                            lineResult.append(" ");
                        }
                    }
                }
            }
        }
        else {
            lineResult.append(line.get(0));
            for (int spaceCount = 0; spaceCount < spaceToDistribute; spaceCount++) {
                lineResult.append(" ");
            }
        }
        result.add(lineResult.toString());
    }

}
