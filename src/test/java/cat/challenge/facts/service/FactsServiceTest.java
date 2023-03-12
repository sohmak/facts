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
        CatFact fact1 = new CatFact();
        fact1.setUser(new User(new Name("Chandler", "Bing")));
        fact1.setUpvotes(3);
        CatFact fact2 = new CatFact();
        fact2.setUser(new User(new Name("Ross", "Geller")));
        fact2.setUpvotes(4);
        CatFact fact3 = new CatFact();
        fact3.setUser(new User(new Name("Chandler", "Bing")));
        fact3.setUpvotes(3);
        return List.of(fact1, fact2, fact3);
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