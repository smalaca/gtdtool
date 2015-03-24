package com.smalaca.gtdtool.rest.api;

import com.smalaca.gtdtool.domain.Project;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProjectController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/project")
    public Project project(@RequestParam(value = "name", defaultValue = "Some project") String projectName) {
        return new Project(counter.incrementAndGet(), projectName);
    }
}
