package com.bharat;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
public class HandsOnJSON {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        // 1. Read JSON & print keys and values
        ObjectNode data = mapper.createObjectNode();
        data.put("name", "Kiran");
        data.put("age", 28);
        data.fields().forEachRemaining(
                e -> System.out.println(e.getKey() + " : " + e.getValue())
        );
        // 2. Convert list to JSON array
        ArrayNode listJson = mapper.createArrayNode();
        listJson.add(mapper.createObjectNode().put("id", 1));
        listJson.add(mapper.createObjectNode().put("id", 2));
        System.out.println("\nJSON Array:\n" + listJson);
        // 3. Filter users > 25
        System.out.println("\nUsers older than 25:");
        for (JsonNode node : listJson) {
            if (node.has("age") && node.get("age").asInt() > 25)
                System.out.println(node);
        }
        // 4. Validate email
        String email = "test@example.com";
        System.out.println("\nEmail Valid: " + email.contains("@"));
        // 5. Merge JSON files (simulated)
        ObjectNode a = mapper.createObjectNode().put("A", 1);
        ObjectNode b = mapper.createObjectNode().put("B", 2);
        a.setAll(b);
        System.out.println("\nMerged JSON:\n" + a);
        // 6. Convert JSON to XML
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(a);
        System.out.println("\nXML Output:\n" + xml);
        // 7. Convert CSV to JSON (simulated)
        ArrayNode csvJson = mapper.createArrayNode();
        csvJson.add(mapper.createObjectNode().put("name", "A").put("age", 25));
        System.out.println("\nCSV to JSON:\n" + csvJson);
        // 8. Generate JSON report (DB simulation)
        ArrayNode report = mapper.createArrayNode();
        report.add(mapper.createObjectNode().put("user", "Admin").put("role", "Manager"));
        System.out.println("\nJSON Report:\n" + report);
    }
}
