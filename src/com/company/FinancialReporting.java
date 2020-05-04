package com.company;

import java.util.HashMap;
import java.util.LinkedList;

public class FinancialReporting {

    private HashMap<String, LineItem> lookup = new HashMap<>();
    private LinkedList<LineItem> report = new LinkedList<>();

    private class LineItem {
        String WBS;
        Integer budgetValue;
        Integer changeOrderValue;
        Integer invoiceValue;
    }

    FinancialReporting(Budget budget1, Budget budget2, Budget budget3) {
        for (Node node: budget1.getNodes()) {
            LineItem newLine = new LineItem();
            newLine.WBS = node.getWBS();
            newLine.budgetValue = node.getValue();
            report.add(newLine);
            lookup.put(newLine.WBS, newLine);
        }

        for (Node node: budget2.getNodes()) {
            if (lookup.containsKey(node.getWBS())) {
                lookup.get(node.getWBS()).changeOrderValue = node.getValue();
            } else {
                LineItem newLine = new LineItem();
                newLine.WBS = node.getWBS();
                newLine.changeOrderValue = node.getValue();
                report.add(newLine);
                lookup.put(newLine.WBS, newLine);
            }
        }

        for (Node node: budget3.getNodes()) {
            if (lookup.containsKey(node.getWBS())) {
                lookup.get(node.getWBS()).invoiceValue = node.getValue();
            } else {
                LineItem newLine = new LineItem();
                newLine.WBS = node.getWBS();
                newLine.invoiceValue = node.getValue();
                report.add(newLine);
                lookup.put(newLine.WBS, newLine);
            }
        }
    }

    public void print() {
        System.out.println("=======REPORT=======");
        System.out.println("WBS : BUDGET : CO : INVOICE");
        System.out.println("---------------------------");

        for (LineItem lineItem: report) {
            System.out.println(lineItem.WBS + " : " + lineItem.budgetValue + " : " + lineItem.changeOrderValue + " : " + lineItem.invoiceValue);
        }
    }
}
