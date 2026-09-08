package org.example.csv;

import java.util.List;

public interface FileReader {
    List<String> readLines(String path);
}
