package com.smalaca.gtdtool.domain;

public class Project {
    private long id;
    private String name;

    public Project(long id, String name) {
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
