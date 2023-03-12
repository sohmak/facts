package cat.challenge.facts.service;

import cat.challenge.facts.domain.CatFact;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FactsService {

    public Map<String, Integer> groupFactByUserAndVotes(List<CatFact> factList) {
        Map<String, Integer> result = factList.stream()
                .collect(Collectors
                        .groupingBy(fact -> fact.getUser().getName().toString(), Collectors.summingInt(CatFact::getUpvotes)));
        return result;
    }

    public Map<String, Integer> sortByMostVotes(Map<String, Integer> result) {
        Map<String, Integer> sortedResult = result
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        return sortedResult;
    }
}
