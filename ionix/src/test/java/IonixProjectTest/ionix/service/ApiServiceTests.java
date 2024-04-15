package IonixProjectTest.ionix.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import IonixProjectTest.ionix.services.implementation.ApiService;

import static org.mockito.Mockito.*;

@SpringBootTest
public class ApiServiceTests {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ApiService apiService;

    public ApiServiceTests() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testCallExternalAPI() {

        String encryptedParam = "encrypted_test_param";
        String expectedUrl = "https://my.api.mockaroo.com/test-tecnico/search/" + encryptedParam;
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-Key", "f2f719e0");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> expectedResponse = new ResponseEntity<>("mock response", HttpStatus.OK);

        when(restTemplate.exchange(expectedUrl, HttpMethod.GET, entity, String.class)).thenReturn(expectedResponse);


        int result = apiService.callExternalAPI(encryptedParam);

        assert result == 10;
        verify(restTemplate, times(1)).exchange(expectedUrl, HttpMethod.GET, entity, String.class);
    }
}