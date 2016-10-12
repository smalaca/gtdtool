package com.smalaca.gtdtool.rest.api;

import com.smalaca.gtdtool.domain.ToDoItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ToDoItemController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/todoitem", method = POST)
    public ToDoItem toDoItem(@RequestParam String name) {
        return new ToDoItem(counter.incrementAndGet(), name);
    }

}
