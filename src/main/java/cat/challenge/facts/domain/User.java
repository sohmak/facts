package cat.challenge.facts.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonProperty("_id")
    String userId;
    @JsonProperty("name")
    Name name;

    public String getUserId() {
        return userId;
    }

    public Name getName() {
        return name;
    }

}
