package com.bharat;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
public class IplCensorAnalyzer {
    static ObjectMapper mapper = new ObjectMapper();
    // ------------------ CENSOR LOGIC ------------------
    private static String maskTeam(String team) {
        int index = team.lastIndexOf(" ");
        return index == -1 ? "****" : team.substring(0, index) + " ****";
    }
    private static void censorJson(ObjectNode match) {
        match.put("team1", maskTeam(match.get("team1").asText()));
        match.put("team2", maskTeam(match.get("team2").asText()));
        match.put("winner", maskTeam(match.get("winner").asText()));
        match.put("player_of_match", "REDACTED");
    }
    // ------------------ JSON PROCESSING ------------------
    private static void processJson(String inputFile, String outputFile) throws Exception {
        ArrayNode matches = (ArrayNode) mapper.readTree(new File(inputFile));
        for (JsonNode node : matches) {
            censorJson((ObjectNode) node);
        }
        mapper.writerWithDefaultPrettyPrinter()
              .writeValue(new File(outputFile), matches);
    }
    // ------------------ CSV PROCESSING ------------------
    private static void processCsv(String inputFile, String outputFile) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get(inputFile));
        List<String> output = new ArrayList<>();
        output.add(lines.get(0)); // header
        for (int i = 1; i < lines.size(); i++) {
            String[] data = lines.get(i).split(",");
            data[1] = maskTeam(data[1]); // team1
            data[3] = maskTeam(data[3]); // team2
            data[5] = maskTeam(data[5]); // winner
            data[6] = "REDACTED";         // player
            output.add(String.join(",", data));
        }
        Files.write(Paths.get(outputFile), output);
    }
    // ------------------ MAIN ------------------
    public static void main(String[] args) {
        try {
            processJson("ipl_input.json", "ipl_censored.json");
            processCsv("ipl_input.csv", "ipl_censored.csv");
            System.out.println("✔ IPL Data Censored Successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
