package cat.challenge.facts.controller;

import cat.challenge.facts.client.CatsApiClient;
import cat.challenge.facts.domain.CatFact;
import cat.challenge.facts.service.FactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static cat.challenge.facts.service.CsvService.writeCsv;


@RestController
public class FactController {
    private final CatsApiClient catsApiClient;
    @Autowired
    private FactService factService;

    public FactController(CatsApiClient catsApiClient) {
        this.catsApiClient = catsApiClient;
    }

    @GetMapping()
    public String HelloWorld() throws Exception {
        final List<CatFact> factList = catsApiClient.getAllFacts();
        Map<String, Integer> facts = factService.groupFactByUserAndVotes(factList);
        Map<String, Integer> sortedFacts = factService.sortByMostVotes(facts);

        List<String[]> lines = new ArrayList<>();
        sortedFacts.forEach((k, v) -> lines.add(new String[]{k, v.toString()}));

        writeCsv(lines);

        return "OK";
    }
}
