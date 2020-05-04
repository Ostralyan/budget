package com.company;

public class Action {
    private Event event;
    private String name;
    private String WBS;
    private Integer value;

    public Action(Event event, String name, String WBS, Integer value) {
        this.event = event;
        this.name = name;
        this.WBS = WBS;
        this.value = value;
    }

    public Event getEvent() {
        return event;
    }

    public String getName() {
        return name;
    }

    public String getWBS() {
        return WBS;
    }

    public Integer getValue() {
        return value;
    }
}
