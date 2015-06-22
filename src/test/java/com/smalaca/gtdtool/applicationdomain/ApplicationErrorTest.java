package com.smalaca.gtdtool.applicationdomain;

import org.junit.Test;

import static com.smalaca.gtdtool.applicationdomain.ApplicationErrorType.INVALID_REQUEST_DATA;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ApplicationErrorTest {

    private static final ApplicationErrorType APPLICATION_ERROR_TYPE = INVALID_REQUEST_DATA;
    private static final String URL = "http://url.com";
    private static final String REASON = "some fancy reason";

    @Test
    public void shouldCreateProperObject() {
        ApplicationError error = new ApplicationError(APPLICATION_ERROR_TYPE, URL, REASON);

        assertThat(error.getType(), is(APPLICATION_ERROR_TYPE));
        assertThat(error.getUrl(), is(URL));
        assertThat(error.getReason(), is(REASON));
    }
}