package com.smalaca.gtdtool.rest.api;

import com.smalaca.gtdtool.applicationdomain.ApplicationError;
import com.smalaca.gtdtool.repository.EntityNotFoundException;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static com.smalaca.gtdtool.applicationdomain.ApplicationErrorType.INVALID_REQUEST_DATA;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ExceptionHandlerControllerTest {
    private static final String URL = "http://url.com";
    private static final String REASON = "any reasonable reason";

    private final ExceptionHandlerController controller = new ExceptionHandlerController();

    @Test
    public void shouldCreateApplicationErrorWhenEntityNotFound() {
        HttpServletRequest reqeust = givenHttpServletRequest();
        EntityNotFoundException exception = new EntityNotFoundException(REASON);

        ApplicationError error = controller.entityNotFound(reqeust, exception);

        assertThat(error.getType(), is(INVALID_REQUEST_DATA));
        assertThat(error.getUrl(), is(URL));
        assertThat(error.getReason(), is(REASON));
    }

    private HttpServletRequest givenHttpServletRequest() {
        HttpServletRequest reqeust = mock(HttpServletRequest.class);
        given(reqeust.getRequestURL()).willReturn(new StringBuffer(URL));
        return reqeust;
    }
}