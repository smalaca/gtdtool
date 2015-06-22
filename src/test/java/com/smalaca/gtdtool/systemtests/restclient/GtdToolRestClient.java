package com.smalaca.gtdtool.systemtests.restclient;

import com.smalaca.gtdtool.systemtests.restclient.dto.ProjectDTO;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class GtdToolRestClient {
    private static final String PROJECT_NAME_PARAM = "name";

    private static final RestTemplate restTemplate = new RestTemplate();

    public static String hostName() {
        return "http://localhost:8080";
    }

    public static ProjectDTO createProject(String name) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add(PROJECT_NAME_PARAM, name);

        return restTemplate.postForObject(hostName() + "/project", params, ProjectDTO.class);
    }
}
