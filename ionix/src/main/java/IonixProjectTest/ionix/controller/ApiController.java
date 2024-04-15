package IonixProjectTest.ionix.controller;

import IonixProjectTest.ionix.controller.request.SearchRequest;
import IonixProjectTest.ionix.controller.response.SearchResponse;
import IonixProjectTest.ionix.services.implementation.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/des")
@RequiredArgsConstructor
public class ApiController {


    private final ApiService apiService;

    @PostMapping("/search")
    public SearchResponse search(@RequestBody SearchRequest request) {
        return apiService.search(request.getParam());
    }
}

