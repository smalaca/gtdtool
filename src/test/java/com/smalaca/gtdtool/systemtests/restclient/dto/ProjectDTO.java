package com.smalaca.gtdtool.systemtests.restclient.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDTO {

    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
