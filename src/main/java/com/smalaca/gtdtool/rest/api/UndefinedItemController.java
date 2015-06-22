package com.smalaca.gtdtool.rest.api;

import com.smalaca.gtdtool.domain.Project;
import com.smalaca.gtdtool.domain.UndefinedItem;
import com.smalaca.gtdtool.repository.EntityNotFoundException;
import com.smalaca.gtdtool.repository.UndefinedItemRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UndefinedItemController {
    private UndefinedItemRepository repository = new UndefinedItemRepository();

    @RequestMapping(value = "/undefineditem/converttoproject/{id}")
    public Project convertToProject(@PathVariable long id) {
        UndefinedItem undefinedItem = repository.findById(id);

        if (undefinedItem == null) {
            throw new EntityNotFoundException("UndefinedItem with given id: " + id + " was not found.");
        }

        return undefinedItem.convertToProject();
    }
}
