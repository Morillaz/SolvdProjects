package com.solvd.wordFrequencyCounter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        String bookName = "Pride and Prejudice";
        File file = new File("src/main/resources/books/" + bookName + ".txt");
        String book = null;
        try {
            book = FileUtils.readFileToString(file, "UTF-8");
            book = book.toLowerCase(Locale.ROOT).replaceAll("[^a-zA-Z']", " ");
        } catch (IOException e) {
            logger.error(e);
        }
        String[] words = StringUtils.split(book);
        Map<String, Integer> wordFrequency = new HashMap<>();
        Arrays.stream(words).forEach((word) -> {
            if (wordFrequency.containsKey(word)) {
                wordFrequency.put(word, wordFrequency.get(word) + 1);
            } else {
                wordFrequency.put(word, 1);
            }
        });

        wordFrequency.entrySet().stream().forEach((entry) -> {
            try {
                FileUtils.writeStringToFile(new File("output/" + bookName + " word_frequency.txt"), entry.getKey() + " = " + entry.getValue() + "\n", (String) null, true);
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        });
    }
}
