import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public static void main(String[] args) {
        String inputFilePath = "c:/Robin/Word Counter/src/input.txt"; 
        String outputFilePath = "c:/Robin/Word Counter/src/output.txt"; 

        countWords(inputFilePath, outputFilePath);
    }

    public static void countWords(String inputFilePath, String outputFilePath) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Use try-with-resources to ensure resources are closed automatically
        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String word = line.trim().toLowerCase();
                if (!word.isEmpty()) {
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }

            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }

            System.out.println("Word counting completed. Results are saved to " + outputFilePath);

        } catch (IOException e) {
            System.err.println("An error occurred while processing the file: " + e.getMessage());
        }
    }
}
