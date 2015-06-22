package com.smalaca.gtdtool.repository;

import com.smalaca.gtdtool.domain.UndefinedItem;
import org.junit.Test;

import static org.junit.Assert.assertNull;

public class UndefinedItemRepositoryTest {
    private static final long NOT_EXISITING_ID = 13;

    @Test
    public void shouldReturnNullWhenUndefinedItemNotFound() {
        UndefinedItem undefinedItem = new UndefinedItemRepository().findById(NOT_EXISITING_ID);

        assertNull(undefinedItem);
    }
}