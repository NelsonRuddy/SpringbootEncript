package IonixProjectTest.ionix.controller;

import IonixProjectTest.ionix.controller.request.SearchRequest;
import IonixProjectTest.ionix.controller.response.SearchResponse;
import IonixProjectTest.ionix.services.implementation.ApiService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApiControllerTests {

    @Test
    public void testSearch() {

        ApiService apiService = mock(ApiService.class);
        ApiController apiController = new ApiController(apiService);

        SearchRequest request = new SearchRequest();
        request.setParam("searchParam");

        SearchResponse expectedResponse = new SearchResponse();
        expectedResponse.setResponseCode(0);
        expectedResponse.setDescription("OK");

        when(apiService.search("searchParam")).thenReturn(expectedResponse);

        SearchResponse response = apiController.search(request);

        assertEquals(expectedResponse, response);
    }
}