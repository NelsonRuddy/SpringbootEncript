package IonixProjectTest.ionix.services.implementation;

import IonixProjectTest.ionix.controller.response.Result;
import IonixProjectTest.ionix.controller.response.SearchResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;


@Service
public class ApiService {

    @Autowired
    private RestTemplate restTemplate;

    public SearchResponse search(String param) {
        long startTime = System.currentTimeMillis();


        String encryptedParam = encryptWithDES(param);


        int registerCount = callExternalAPI(encryptedParam);

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;


        SearchResponse response = new SearchResponse();
        response.setResponseCode(0);
        response.setDescription("OK");
        response.setElapsedTime(elapsedTime);

        Result result = new Result();
        result.setRegisterCount(registerCount);
        response.setResult(result);

        return response;
    }

    public String encryptWithDES(String param) {
        try {
            DESKeySpec keySpec = new DESKeySpec("ionix123456".getBytes("UTF8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(keySpec);

            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] cleartext = param.getBytes("UTF8");
            byte[] ciphertext = cipher.doFinal(cleartext);

            return Base64.getEncoder().encodeToString(ciphertext);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int callExternalAPI(String encryptedParam) {
        String url = "https://my.api.mockaroo.com/test-tecnico/search/" + encryptedParam;
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-API-Key", "f2f719e0");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return 10;
    }
}

