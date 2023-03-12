package cat.challenge.facts.client;

import cat.challenge.facts.domain.CatFact;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CatApiResponse {
    @JsonProperty("all")
    public List<CatFact> catFacts;

}
