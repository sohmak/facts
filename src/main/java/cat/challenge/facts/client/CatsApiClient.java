package cat.challenge.facts.client;

import cat.challenge.facts.domain.CatFact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Component
public class CatsApiClient {

    public static final String WEBSITE_URL = "https://cat-fact.herokuapp.com/facts";
    public static final String BASE_URL = "http://localhost:3000/facts";
    private final static Logger log = LoggerFactory.getLogger(CatsApiClient.class);

    public List<CatFact> getAllFacts() {
        ResponseEntity<CatApiResponse> responseEntity = getCatFactsRequest();
        List<CatFact> facts = Objects.requireNonNull(responseEntity.getBody()).catFacts;
        log.info("Successfully fetched {} facts.", facts.size());

        return facts;
    }


    private ResponseEntity<CatApiResponse> getCatFactsRequest() {
        final RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.getForEntity(
                    BASE_URL, CatApiResponse.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}
