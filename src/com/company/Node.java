package com.company;

import java.util.List;

public class Node {
    private String WBS;
    private Integer value;
    private List<Node> children;

    public Node(String WBS, Integer value) {
        this.WBS = WBS;
        this.value = value;
    }

    public String getWBS() {
        return WBS;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
