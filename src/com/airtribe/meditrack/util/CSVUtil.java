package com.airtribe.meditrack.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    public static void writeToCSV(String filePath, List<String[]> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                writer.write(String.join(",", row));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing CSV", e);
        }
    }

    public static List<String[]> readFromCSV(String filePath) {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                data.add(line.split(","));
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV", e);
        }

        return data;
    }
}