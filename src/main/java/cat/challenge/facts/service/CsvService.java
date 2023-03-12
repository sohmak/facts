package cat.challenge.facts.service;

import com.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class CsvService {
    private static final Logger log = LoggerFactory.getLogger(CsvService.class);

    public static void writeCsv(List<String[]> lines) throws Exception {
        URI uri = ClassLoader.getSystemResource("csv/twoColumn.csv").toURI();
        Path path = Paths.get(uri);
        log.info("saving to " + path);
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
            writer.writeNext(new String[]{"User", "UpVotes"});
            for (String[] line : lines) {
                writer.writeNext(line);
            }
        }

    }

}
