package com.bharat;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import java.util.*;
public class PracticeProblemsJSON {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        // 1. Create JSON object for Student
        ObjectNode student = mapper.createObjectNode();
        student.put("name", "Amit");
        student.put("age", 22);
        student.putArray("subjects").add("Math").add("Science");
        System.out.println("Student JSON:\n" + student);
        // 2. Java Object to JSON
        Car car = new Car("BMW", 2023);
        String carJson = mapper.writeValueAsString(car);
        System.out.println("\nCar JSON:\n" + carJson);
        // 3. Read JSON & extract fields
        JsonNode readNode = mapper.readTree(student.toString());
        System.out.println("\nExtracted Name: " + readNode.get("name").asText());
        // 4. Merge JSON objects
        ObjectNode json1 = mapper.createObjectNode().put("city", "Delhi");
        ObjectNode json2 = mapper.createObjectNode().put("country", "India");
        json1.setAll(json2);
        System.out.println("\nMerged JSON:\n" + json1);
        // 5. Validate JSON
        try {
            mapper.readTree("{invalid}");
        } catch (Exception e) {
            System.out.println("\nInvalid JSON detected");
        }
        // 6. List of Java objects to JSON array
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Honda", 2021));
        cars.add(new Car("Toyota", 2020));
        System.out.println("\nCars List JSON:\n" + mapper.writeValueAsString(cars));
        // 7. Parse JSON & filter age > 25
        ArrayNode users = mapper.createArrayNode();
        users.add(mapper.createObjectNode().put("name", "Ravi").put("age", 30));
        users.add(mapper.createObjectNode().put("name", "Anu").put("age", 20));
        System.out.println("\nUsers age > 25:");
        for (JsonNode user : users) {
            if (user.get("age").asInt() > 25)
                System.out.println(user);
        }
    }
}
// Supporting class
class Car {
    public String brand;
    public int year;
    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
}
