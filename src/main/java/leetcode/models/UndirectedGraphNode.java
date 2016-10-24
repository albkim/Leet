package leetcode.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sang on 10/5/2016.
 */
public class UndirectedGraphNode {

    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        this.label = x;
        this.neighbors = new ArrayList<UndirectedGraphNode>();
    }

}
