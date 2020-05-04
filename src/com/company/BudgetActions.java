package com.company;


import java.util.ArrayList;
import java.util.LinkedList;

public class BudgetActions {
    LinkedList<Action> actions = new LinkedList<>();

    public void addAction(Event event, String name, String WBS, Integer value) {
        Action action = new Action(event, name, WBS, value);
        actions.addLast(action);
    }

    public Budget build() {
        return build(actions.getLast().getName());
    }

    public Budget build(String name) {
        ArrayList<Node> nodes = new ArrayList<>();

        for (Action action: actions) {

            if (action.getName().equals(name)) break;

            if (action.getEvent().equals(Event.ADD_BUDGET_TO_WBS)) {
                nodes.add(new Node(action.getWBS(), action.getValue()));
            }

            if (action.getEvent().equals(Event.CHANGE_BUDGET_VALUE)) {
                for (Node node: nodes) {
                    if(node.getWBS().equals(action.getWBS())) {
                        node.setValue(action.getValue());
                    }
                }
            }

            if (action.getEvent().equals(Event.REMOVE_BUDGET_VALUE)) {
                Node temp = null;
                for (Node node: nodes) {
                    if(node.getWBS().equals(action.getWBS())) {
                        temp = node;
                        break;
                    }
                }
                nodes.remove(temp);
            }
        }

        return new Budget(nodes);
    }
}
