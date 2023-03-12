package cat.challenge.facts.controller;

import cat.challenge.facts.client.CatsApiClient;
import cat.challenge.facts.domain.CatFact;
import cat.challenge.facts.service.FactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static cat.challenge.facts.service.CsvService.writeCsv;

@RequestMapping("/api/v1")
@RestController
public class FactController {
    @Autowired
    private CatsApiClient catsApiClient;
    @Autowired
    private FactsService factsService;

//    public FactController(CatsApiClient catsApiClient) {
//        this.catsApiClient = catsApiClient;
//    }

    @GetMapping("facts/scoreBoard")
    public @ResponseBody Map<String, Integer> getUpvotesByUsers() throws Exception {
        final List<CatFact> factList = catsApiClient.getAllFacts();
        Map<String, Integer> facts = factsService.groupFactByUserAndVotes(factList);
        Map<String, Integer> sortedFacts = factsService.sortByMostVotes(facts);

        writeCsv(sortedFacts);
        return sortedFacts ;
    }
}
