package com.smalaca.gtdtool.systemtests.stories;

import com.smalaca.gtdtool.Application;
import com.smalaca.gtdtool.systemtests.JBehaveConfiguration;
import com.smalaca.gtdtool.systemtests.restclient.GtdToolExceptionRestClient;
import com.smalaca.gtdtool.systemtests.restclient.dto.ErrorDTO;
import org.apache.commons.httpclient.HttpStatus;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static com.smalaca.gtdtool.systemtests.restclient.GtdToolRestClient.hostName;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class ExceptionHandlingStories extends JBehaveConfiguration {
    private long undefinedItemId;
    private ErrorDTO error;

    @Given("Undefined Item with id $id")
    public void givenProjectName(long id) {
        undefinedItemId = id;
    }

    @When("converting to Project")
    public void createsProject() throws IOException {
        error = GtdToolExceptionRestClient.convertUndefinedItemToProject(undefinedItemId);
    }

    @Then("Undefined Item was not found")
    public void thenTheProjectWasCreated() {
        assertThat(error.getHttpStatus(), equalTo(HttpStatus.SC_NOT_FOUND));
        assertThat(error.getReason(), is("UndefinedItem with given id: " + undefinedItemId + " was not found."));
        assertThat(error.getType(), is("INVALID_REQUEST_DATA"));
        assertThat(error.getUrl(), is(hostName() + "/undefineditem/converttoproject/" + undefinedItemId));
    }
}
