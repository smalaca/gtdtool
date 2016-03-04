package com.smalaca.gtdtool.rest.api;

import com.smalaca.gtdtool.domain.Project;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProjectControllerTest {
    private final ProjectController controller = new ProjectController();
    
    @Test
    public void shouldCreateProjectWithGivenName() {
        String projectName = "Some fancy name";
        Project project = controller.project(projectName);

        assertThat(project.getId(), is(1L));
//        assertThat(project.getName(), is(projectName));
        assertThat(project.getName(), is("different name"));
    }
}