package com.smalaca.gtdtool.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ToDoItemTest {
    @Test
    public void shouldReturnCorrectValue() {
        long id = 13L;
        String name = "Some fancy name";

        ToDoItem toDoItem = new ToDoItem(id, name);

        assertThat(toDoItem.getId()).isEqualTo(id);
        assertThat(toDoItem.getName()).isEqualTo(name);
    }
}