package leetcode.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sang on 11/7/2016.
 */
public class NestedIntegerImpl implements NestedInteger {

    private int intValue;
    private List<NestedInteger> listValue;

    public NestedIntegerImpl() {
        this.listValue = new ArrayList<>();
    }

    public NestedIntegerImpl(int value) {
        this.intValue = value;
    }

    public NestedIntegerImpl(List<NestedInteger> value) {
        this.listValue = value;
    }

    @Override
    public boolean isInteger() {
        return this.listValue == null;
    }

    @Override
    public Integer getInteger() {
        return this.intValue;
    }

    @Override
    public void setInteger(int value) {
        this.intValue = value;
    }

    @Override
    public void add(NestedInteger ni) {
        if (this.listValue == null) {
            this.listValue = new ArrayList<>();
        }
        this.listValue.add(ni);
    }

    @Override
    public List<NestedInteger> getList() {
        return this.listValue;
    }

}
