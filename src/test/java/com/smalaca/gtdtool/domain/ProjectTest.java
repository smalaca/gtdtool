package com.smalaca.gtdtool.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectTest {

    @Test
    public void shouldReturnCorrectValue() {
        long id = 13L;
        String name = "Some fancy name";

        Project project = new Project(id, name);

        assertThat(project.getId()).isEqualTo(id);
        assertThat(project.getName()).isEqualTo(name);
    }
}
