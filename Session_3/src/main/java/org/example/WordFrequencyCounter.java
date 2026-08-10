package org.example;

import java.util.*;


public class WordFrequencyCounter {

    public static void main(String[] args) {
        // Hardcoded multi-line paragraph
        String paragraph = """
            The quick brown fox jumps over the lazy dog.
            The dog barks, and the fox runs away.
            Quick as a flash, the brown fox disappears into the forest.
            The lazy dog doesn't care, for the dog is too lazy to chase.
            Fox, fox, fox! The quick brown fox is the cleverest of all.
            """;

        WordFrequencyCounter counter = new WordFrequencyCounter();
        Map<String, Integer> wordCounts = counter.countWords(paragraph);

        System.out.println("Word Frequency Analysis");
        System.out.println("=======================");
        System.out.println("Total unique words: " + wordCounts.size());
        System.out.println("Total words: " + wordCounts.values().stream().mapToInt(Integer::intValue).sum());
        System.out.println("Top 10 Most Frequent Words:");
        System.out.println("----------------------------");

        counter.printTopWords(wordCounts, 10);
    }

    // Counts word frequencies in a paragraph

    public Map<String, Integer> countWords(String paragraph) {
        Map<String, Integer> wordCounts = new HashMap<>();

        if (paragraph == null || paragraph.trim().isEmpty()) {
            return wordCounts;
        }

        // Split on whitespace and punctuation
        // Regex: split on one or more non-word characters (anything not a-z, A-Z, 0-9, or _)
        String[] words = paragraph.toLowerCase().split("[^a-zA-Z0-9_]+");

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }

        return wordCounts;
    }

     //Prints top N most frequent words using stream sorting

    public void printTopWords(Map<String, Integer> wordCounts, int topN) {
        if (wordCounts == null || wordCounts.isEmpty()) {
            System.out.println("No words to display.");
            return;
        }

        // Using stream to sort entries by value (frequency) descending
        wordCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(topN)
                .forEach(entry -> {
                    String word = entry.getKey();
                    int count = entry.getValue();
                    String slash = "/".repeat(Math.min(count, 50));
                    System.out.printf("%-15s %3d  %s%n", word, count, slash);
                });
    }

}
