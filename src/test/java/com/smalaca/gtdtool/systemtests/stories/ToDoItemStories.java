package com.smalaca.gtdtool.systemtests.stories;


import com.smalaca.gtdtool.Application;
import com.smalaca.gtdtool.systemtests.JBehaveConfiguration;
import com.smalaca.gtdtool.systemtests.restclient.GtdToolRestClient;
import com.smalaca.gtdtool.systemtests.restclient.dto.ToDoItemDTO;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class ToDoItemStories extends JBehaveConfiguration {
    private String toDoItemName;
    private ToDoItemDTO toDoItemDTO;

    @Given("a new to do item $toDoItemName")
    public void givenToDoItemName(String toDoItemName) {
        this.toDoItemName = toDoItemName;
    }

    @When("create a new to do item")
    public void createsToDoItem() {
        toDoItemDTO = GtdToolRestClient.createToDoItemWith(toDoItemName);
    }

    @Then("to do item with given name is created")
    public void thenToDoItemIs() {
        assertThat(toDoItemDTO.getName()).isEqualTo(toDoItemName);
    }
}
