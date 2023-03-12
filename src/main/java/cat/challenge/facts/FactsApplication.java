package cat.challenge.facts;


import cat.challenge.facts.client.CatsApiClient;
import cat.challenge.facts.domain.CatFact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;

import static cat.challenge.facts.service.CsvService.writeCsv;


@SpringBootApplication
public class FactsApplication {

    private static final Logger log = LoggerFactory.getLogger(FactsApplication.class);


    public static void main(String[] args) throws Exception {
        SpringApplication.run(FactsApplication.class, args);

    }





}
