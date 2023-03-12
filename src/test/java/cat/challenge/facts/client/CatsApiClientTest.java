package cat.challenge.facts.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CatsApiClientTest {

    CatsApiClient client = new CatsApiClient();

    @Test
    public void catApiClientReturnsListOfFacts() {
        Object expected = client.getAllFacts();
        assertNotNull(expected);


    }

}