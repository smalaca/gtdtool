package com.smalaca.gtdtool.rest.api;

import com.smalaca.gtdtool.domain.ToDoItem;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ToDoItemControllerTest {
    private final ToDoItemController controller = new ToDoItemController();

    @Test
    public void shouldCreateProjectWithGivenName() {
        String name = "Some fancy name";
        ToDoItem toDoItem = controller.toDoItem(name);

        assertThat(toDoItem.getId()).isEqualTo(1L);
        assertThat(toDoItem.getName()).isEqualTo(name);
    }
}