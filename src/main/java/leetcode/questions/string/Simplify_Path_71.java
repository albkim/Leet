package leetcode.questions.string;

import java.util.ArrayList;
import java.util.List;

/**
 Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"


 click to show corner cases.

 Corner Cases:

 Did you consider the case where path = "/../"?
 In this case, you should return "/".

 Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 In this case, you should ignore redundant slashes and return "/home/foo".

 */
public class Simplify_Path_71 {

    public static String simplifyPath(String path) {
        List<String> result = new ArrayList<>();

        for(String folder : path.split("/")) {
            if (folder.length() == 0) {
                continue;
            }
            if (folder.equals(".")) {
                continue;
            }
            if (folder.equals("..")) {
                if (result.size() > 0) {
                    result.remove(result.size() - 1);
                }
                continue;
            }
            result.add(folder);
        }

        StringBuilder newPath = new StringBuilder();

        for (String folder : result) {
            newPath.append('/');
            newPath.append(folder);
        }

        if (newPath.length() == 0) {
            return "/";
        }

        return newPath.toString();
    }

}
