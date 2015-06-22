package com.smalaca.gtdtool.systemtests.restclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smalaca.gtdtool.systemtests.restclient.dto.ErrorDTO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static com.smalaca.gtdtool.systemtests.restclient.GtdToolRestClient.hostName;

public class GtdToolExceptionRestClient {
    private static final HttpClient client = HttpClientBuilder.create().build();
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static ErrorDTO convertUndefinedItemToProject(long id) {
        ErrorDTO error = null;

        try {
            HttpResponse httpResponse = client.execute(new HttpGet(hostName() + "/undefineditem/converttoproject/" + id));
            error = updateErrorWithResponseData(error, httpResponse);
        } catch (IOException e) {
            // should fail when exception will  be thrown
        } finally {
            return error;
        }
    }

    private static ErrorDTO updateErrorWithResponseData(ErrorDTO errorDTO, HttpResponse httpResponse) throws IOException {
        errorDTO = extractErrorDtoFromResponseContent(httpResponse);
        errorDTO.setHttpStatus(httpResponse.getStatusLine().getStatusCode());

        return errorDTO;
    }

    private static ErrorDTO extractErrorDtoFromResponseContent(HttpResponse httpResponse) throws IOException {
        return objectMapper.readValue(EntityUtils.toString(httpResponse.getEntity()), ErrorDTO.class);
    }
}
