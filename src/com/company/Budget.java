package com.company;

import java.util.ArrayList;

public class Budget {
    private ArrayList<Node> nodes;

    public Budget(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void print() {
        System.out.println("=================");
        for (Node node: nodes) {
            System.out.println(node.getWBS() + " : " + node.getValue());
        }
    }
}
