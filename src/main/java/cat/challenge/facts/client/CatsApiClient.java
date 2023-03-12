package cat.challenge.facts.client;

import cat.challenge.facts.domain.CatFact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Component
public class CatsApiClient {

    public static final String WEBSITE_URL = "https://cat-fact.herokuapp.com/facts";
    public static final String BASE_URL = "http://localhost:3000/facts";


    RestTemplate restTemplate = new RestTemplate();

    public List<CatFact> getAllFacts() {
        ResponseEntity<CatApiResponse> responseEntity = getCatFactsRequest();
        List<CatFact> facts = Objects.requireNonNull(responseEntity.getBody()).catFacts;
        return facts;
    }

    private ResponseEntity<CatApiResponse> getCatFactsRequest() {
        return restTemplate.getForEntity(
                BASE_URL, CatApiResponse.class);
    }
}
