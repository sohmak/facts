package cat.challenge.facts.service;

import com.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CsvService {
    private static final Logger log = LoggerFactory.getLogger(CsvService.class);
    public static String[] HEADER_ROW = {"User", "UpVotes"};
    public static String CSV_FILE = "build/results.csv";

    public static void writeCsv(Map<String, Integer> map) throws Exception {
        List<String[]> lines = mapToList(map);
        log.info("Trying to save the results to " + CSV_FILE);
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
            writer.writeNext(HEADER_ROW);
            for (String[] line : lines) {
                writer.writeNext(line);
            }
        } catch (Exception e){
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    private static List<String[]> mapToList(Map<String, Integer> map) {
        List<String[]> lines = new ArrayList<>();
        map.forEach((k, v) -> lines.add(new String[]{k, v.toString()}));
        return lines;
    }

}
