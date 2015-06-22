package com.smalaca.gtdtool.repository;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EntityNotFoundExceptionTest {

    private static final String MESSAGE = "exception message";

    @Test
    public void shouldCreateExceptionWithAMessage() {
        RuntimeException exception = new EntityNotFoundException(MESSAGE);

        assertThat(exception.getMessage(), is(MESSAGE));
    }
}