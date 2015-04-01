package com.smalaca.gtdtool.systemtests.stories;

import com.smalaca.gtdtool.domain.Project;
import com.smalaca.gtdtool.rest.api.ProjectController;
import com.smalaca.gtdtool.systemtests.JBehaveConfiguration;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProjectStories extends JBehaveConfiguration {

    private final ProjectController controller = new ProjectController();
    private String projectName;
    private Project project;

    @Given("a project name $projectName")
    public void givenProjectName(String projectName) {
        this.projectName = projectName;
    }

    @When("I will execute controller method")
    public void whenControllerMethodIsExecuted() {
        project = controller.project(projectName);
    }

    @Then("the project is created")
    public void thenTheProjectIsCreated() {
        assertThat(project.getName(), is(projectName));
    }
}
