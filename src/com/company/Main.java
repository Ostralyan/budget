package com.company;

public class Main {

    public static void main(String[] args) {
	    BudgetActions budgetActions = new BudgetActions();
	    budgetActions.addAction(Event.ADD_BUDGET_TO_WBS, "Event 1", "abc", 100);
        budgetActions.addAction(Event.ADD_BUDGET_TO_WBS, "Event 2", "def", 200);
        budgetActions.addAction(Event.ADD_BUDGET_TO_WBS, "Event 3", "ghi", 300);
        budgetActions.addAction(Event.ADD_BUDGET_TO_WBS, "Event 4", "jkl", 400);
        budgetActions.addAction(Event.TAKE_SNAPSHOT, "Snapshot 1", null, null);
        budgetActions.addAction(Event.ADD_BUDGET_TO_WBS, "Event 5", "mno", 500);
        budgetActions.addAction(Event.ADD_BUDGET_TO_WBS, "Event 6", "pqr", 600);
        budgetActions.addAction(Event.ADD_BUDGET_TO_WBS, "Event 7", "stu", 700);
        budgetActions.addAction(Event.ADD_BUDGET_TO_WBS, "Event 8", "vwx", 800);
        budgetActions.addAction(Event.TAKE_SNAPSHOT, "Snapshot 2", null, null);

        budgetActions.addAction(Event.REMOVE_BUDGET_VALUE, "Event 9", "abc", null);
        budgetActions.addAction(Event.CHANGE_BUDGET_VALUE, "Event 10", "def", 9000);
        budgetActions.addAction(Event.CHANGE_BUDGET_VALUE, "Event 10", "ghi", 9001);
        budgetActions.addAction(Event.TAKE_SNAPSHOT, "Snapshot 3", null, null);

        Budget budget = budgetActions.build();
        Budget otherBudget = budgetActions.build("Snapshot 2");
        Budget contract = budgetActions.build("Snapshot 1");

        FinancialReporting report = new FinancialReporting(budget, otherBudget, contract);

        budget.print();
        otherBudget.print();
        contract.print();
        report.print();
    }
}
