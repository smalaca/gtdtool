package com.smalaca.gtdtool.rest.api;

import com.smalaca.gtdtool.domain.Project;
import com.smalaca.gtdtool.domain.UndefinedItem;
import com.smalaca.gtdtool.repository.EntityNotFoundException;
import com.smalaca.gtdtool.repository.UndefinedItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class UndefinedItemControllerTest {
    @Mock private UndefinedItemRepository repository;

    @InjectMocks private UndefinedItemController controller;

    @Test
    public void shouldThrowExceptionWhenUndefinedItemNotFound() {
        try {
            controller.convertToProject(13);
            fail("Should not found an entity.");
        } catch (EntityNotFoundException exception) {
            assertThat(exception.getMessage(), is("UndefinedItem with given id: 13 was not found."));
        }
    }

    @Test
    public void shouldConvertToProject() {
        givenUndefinedItem(69);

        Project result = controller.convertToProject(69);

        assertThat(result, instanceOf(Project.class));
    }

    private void givenUndefinedItem(int id) {
        UndefinedItem undefinedItem = mock(UndefinedItem.class);
        given(undefinedItem.convertToProject()).willReturn(mock(Project.class));
        given(repository.findById(id)).willReturn(undefinedItem);
    }
}