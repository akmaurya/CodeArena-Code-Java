package learn.codex.business.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileReport {

    public static void main(String[] args) {
        String folderPath = "D:\\Arvind\\Movies\\South\\Watched"; // Replace with your folder path
        folderPath = folderPath.replace("\\", "/");
        String csvFilePath = folderPath+"/files_info.csv";
        String jsonFilePath = folderPath+"/files_info.json";
        String preImage = "";
        if(csvFilePath.contains("Bhojpuri"))
        	preImage="assets/img/moviesImage/bhojpuri/";
        if(csvFilePath.contains("3D Movies"))
        	preImage="assets/img/moviesImage/3Dmovies/";
        if(csvFilePath.contains("Bollywood"))
        	preImage="assets/img/moviesImage/bollywood/";
        if(csvFilePath.contains("Hollywood"))
        	preImage="assets/img/moviesImage/hollywood/";
        if(csvFilePath.contains("Short Movies"))
        	preImage="assets/img/moviesImage/shortmovies/";
        if(csvFilePath.contains("South"))
        	preImage="assets/img/moviesImage/south/";
        if(csvFilePath.contains("Series"))
        	preImage="assets/img/moviesImage/series/";
        
        
        try (FileWriter csvWriter = new FileWriter(csvFilePath)) {
            csvWriter.append("Name,Size,Image,Link\n");

            File rootFolder = new File(folderPath);
            processFiles(rootFolder, csvWriter, preImage);
            csvWriter.close();
            System.out.println("CSV file created successfully!");
            
            List<Map<String, String>> jsonData = convertCsvToJson(csvFilePath);
            writeJsonToFile(jsonData, jsonFilePath);

            System.out.println("JSON data has been written to: " + jsonFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processFiles(File folder, FileWriter csvWriter, String preImage) throws IOException {
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursive call for subdirectories
                    //processFiles(file, csvWriter, preImage);
                } else {
                    double fileSizeInBytes = file.length();
                    String fileSizeFormatted = formatFileSize(fileSizeInBytes);
                    if(!file.getName().contentEquals("files_info.csv"))
                    csvWriter.append(file.getName().substring(0, file.getName().length()-4)).append(",")
                    .append(fileSizeFormatted).append(",")
                    .append(preImage).append(file.getName().substring(0, file.getName().length()-4)).append(".jpg,")
                    .append("link").append("\n");
                }
            }
        }
    }

    private static String formatFileSize(double fileSizeInBytes) {
        double fileSizeInKB = fileSizeInBytes / 1024;
        double fileSizeInMB = fileSizeInKB / 1024;
        double fileSizeInGB = fileSizeInMB / 1024;

        if (fileSizeInGB > 1) {
            return String.format("%.2f GB", fileSizeInGB);
        } else if (fileSizeInMB > 1) {
            // Round off if in MB
            return String.format("%.0f MB", fileSizeInMB);
        } else {
            return String.format("%.2f KB", fileSizeInKB);
        }
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
        	System.out.println("Total -- "+jsonData.size());
            writer.write("[\n");
            for (Map<String, String> record : jsonData) {
                writer.write("\t" + mapToJsonString(record) + ",\n");
            }
            writer.write("]\n");
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
        return jsonString.toString();
    }
}