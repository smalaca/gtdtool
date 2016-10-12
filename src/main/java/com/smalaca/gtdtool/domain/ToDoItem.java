package com.smalaca.gtdtool.domain;

public class ToDoItem {
    private final long id;
    private final String name;

    public ToDoItem(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
