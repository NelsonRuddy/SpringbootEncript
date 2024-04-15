package IonixProjectTest.ionix.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponse {
    private int responseCode;
    private String description;
    private long elapsedTime;
    private Result result;
}
