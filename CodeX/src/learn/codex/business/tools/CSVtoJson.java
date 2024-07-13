package learn.codex.business.tools;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVtoJson {

    public static void main(String[] args) {
        String csvFilePath = "D:/Arvind/Movies/Bhojpuri/Watched/files_info.csv";
        String jsonFilePath = "D:/Arvind/Movies/Bhojpuri/Watched/files_info.json";

        List<Map<String, String>> jsonData = convertCsvToJson(csvFilePath);
        writeJsonToFile(jsonData, jsonFilePath);

        System.out.println("JSON data has been written to: " + jsonFilePath);
    }

    private static List<Map<String, String>> convertCsvToJson(String csvFilePath) {
        List<Map<String, String>> jsonData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            String[] headers = null;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if (headers == null) {
                    headers = values;
                    continue;
                }

                Map<String, String> record = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    record.put(headers[i], values[i]);
                }

                jsonData.add(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonData;
    }

    private static void writeJsonToFile(List<Map<String, String>> jsonData, String jsonFilePath) {
        try (FileWriter writer = new FileWriter(jsonFilePath)) {
//            writer.write("[\n");
            for (Map<String, String> record : jsonData) {
                writer.write(mapToJsonString(record) + ",\n");
            }
//            writer.write("]\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String mapToJsonString(Map<String, String> map) {
        StringBuilder jsonString = new StringBuilder("{");
        int size = map.size();
        int count = 0;

        for (Map.Entry<String, String> entry : map.entrySet()) {
            jsonString.append("\n\t\t\"").append(entry.getKey()).append("\":\"").append(entry.getValue()).append("\"");

            if (++count < size) {
                jsonString.append(", ");
            }
        }

        jsonString.append("\n\t}");
        System.out.println(jsonString);
        return jsonString.toString();
    }
}