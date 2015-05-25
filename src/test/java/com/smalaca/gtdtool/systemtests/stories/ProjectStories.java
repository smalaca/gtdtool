package com.smalaca.gtdtool.systemtests.stories;

import com.smalaca.gtdtool.systemtests.JBehaveConfiguration;
import com.smalaca.gtdtool.systemtests.restclient.GtdToolRestClient;
import com.smalaca.gtdtool.systemtests.restclient.dto.ProjectDTO;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProjectStories extends JBehaveConfiguration {

    private String projectName;
    private ProjectDTO project;

    @Given("a project name $projectName")
    public void givenProjectName(String projectName) {
        this.projectName = projectName;
    }

    @When("creates a project")
    public void createsProject() {
        project = GtdToolRestClient.createProject(projectName);
    }

    @Then("project with given name was created")
    public void thenTheProjectWasCreated() {
        assertThat(project.getName(), is(projectName));
    }
}
