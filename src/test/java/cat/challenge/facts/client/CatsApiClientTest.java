package cat.challenge.facts.client;

import cat.challenge.facts.domain.CatFact;
import org.assertj.core.internal.Objects;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatsApiClientTest {


    CatsApiClient client = new CatsApiClient();
    @Test
    public void catApiClientReturnsListOfFacts(){
        Object expected = client.getAllFacts();
        assertNotNull(expected);



    }

}