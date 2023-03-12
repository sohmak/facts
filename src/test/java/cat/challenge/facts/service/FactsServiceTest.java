package cat.challenge.facts.service;

import cat.challenge.facts.domain.CatFact;
import cat.challenge.facts.domain.Name;
import cat.challenge.facts.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FactsServiceTest {

    @Autowired
    private FactsService service;

    private static List<CatFact> stubAllFacts() {
        CatFact fact1 = stubFactFromUser("Chandler", "Bing", 4);
        CatFact fact2 = stubFactFromUser("Ross", "Geller", 2);
        CatFact fact3 = stubFactFromUser("Chandler", "Bing", 2);

        return List.of(fact1, fact2, fact3);
    }

    private static CatFact stubFactFromUser(String firstName, String lastName, int upvotes) {
        CatFact fact = new CatFact();
        Name chandler = new Name();
        chandler.setFirstName(firstName);
        chandler.setLastName(lastName);
        User user1 = new User();
        user1.setName(chandler);
        fact.setUser(user1);
        fact.setUpvotes(upvotes);
        return fact;
    }

    private static Map<String, Integer> stubUserAndVoteMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Ross Geller", 2);
        map.put("Chandler Bing", 8);
        map.put("Rachel Green", 3);
        map.put("Joey Tribbiani", 4);
        return map;
    }

    @Test
    void groupFactByUserAndVotes() {
        Map<String, Integer> result = service.groupFactByUserAndVotes(stubAllFacts());
        assertEquals(2, result.size());
        assertEquals(6, (int) result.get("Chandler Bing"));

    }

    @Test
    void sortByMostVotes() {
        Map<String, Integer> sorted = service.sortByMostVotes(stubUserAndVoteMap());
        List<Integer> values = sorted.values().stream().toList();
        for (int i = 1; i < values.size(); i++) {
            assertTrue(values.get(i) < values.get(i - 1));
        }
    }
}