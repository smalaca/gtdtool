package com.smalaca.gtdtool.rest.api;

import com.smalaca.gtdtool.domain.Project;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ProjectController {
    private final AtomicLong counter = new AtomicLong();
    private final long someFan_das_cs = 13L;
    @RequestMapping(value = "/project", method = POST)
    public Project project(@RequestParam String name) {
        return new Project(counter.incrementAndGet(), name);
    }
}
