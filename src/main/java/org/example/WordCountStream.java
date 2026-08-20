package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCountStream {

    public static void main(String[] args) {
        // Specify the path to your text file
        Path filePath = Paths.get("sample.txt");

        try {
            // Word count pipeline
            Map<String, Long> wordFrequency = Files.lines(filePath)
                    .flatMap(line -> Arrays.stream(line.split("\\W+"))) // Tokenize by non-word characters
                    .filter(token -> !token.isEmpty())                   // Remove empty tokens
                    .map(String::toLowerCase)                           // Normalize to lowercase
                    .collect(Collectors.groupingBy(
                            Function.identity(),                            // Word as key
                            Collectors.counting()                           // Count occurrences
                    ));

            // Print top 10 words by frequency
            System.out.println("Top 10 most frequent words:");
            System.out.println("=================================");

            wordFrequency.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue()
                            .reversed()                                    // Sort by frequency descending
                            .thenComparing(Map.Entry.comparingByKey()))    // Then alphabetically for ties
                    .limit(10)                                         // Take top 10
                    .forEach(entry ->
                            System.out.printf("%-15s : %d%n",
                                    entry.getKey(), entry.getValue()));

            // Bonus: Display total unique words
            System.out.println("\nTotal unique words: " + wordFrequency.size());

            // Bonus: Display total words
            long totalWords = wordFrequency.values().stream()
                    .mapToLong(Long::longValue)
                    .sum();
            System.out.println("Total words: " + totalWords);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
