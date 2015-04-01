package com.smalaca.gtdtool.domain;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProjectTest {

    @Test
    public void shouldReturnCorrectValue() {
        long id = 13L;
        String name = "Some fancy name";

        Project project = new Project(id, name);

        assertThat(project.getId(), is(id));
        assertThat(project.getName(), is(name));
    }
}
