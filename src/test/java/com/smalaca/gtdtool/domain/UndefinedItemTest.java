package com.smalaca.gtdtool.domain;

import org.junit.Test;

import static junit.framework.Assert.assertNull;

public class UndefinedItemTest {

    @Test
    public void shouldConvertToProject() {
        Project project = new UndefinedItem().convertToProject();

        assertNull(project);
    }
}