package com.smalaca.gtdtool.systemtests.restclient;

import com.smalaca.gtdtool.systemtests.restclient.dto.ProjectDTO;
import org.springframework.web.client.RestTemplate;

public class GtdToolRestClient {
    private static final RestTemplate restTemplate = new RestTemplate();

    public static ProjectDTO createProject(String name) {
        return restTemplate.getForObject("http://localhost:8080/project?name=" + name, ProjectDTO.class);
    }
}
