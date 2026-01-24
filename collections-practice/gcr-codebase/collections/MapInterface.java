import java.util.*;
// -------------------- Employee Class (For Problem 5) --------------------
class Employee {
    String name;
    String department;
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    @Override
    public String toString() {
        return name;
    }
}
// -------------------- MAIN CLASS --------------------
public class MapInterface {
    // 1. Word Frequency Counter
    public static Map<String, Integer> wordFrequency(String text) {
        Map<String, Integer> map = new HashMap<>();
        text = text.toLowerCase().replaceAll("[^a-z ]", "");
        String[] words = text.split("\\s+");
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }
    // 2. Invert a Map
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        Map<V, List<K>> inverted = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            inverted
                .computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                .add(entry.getKey());
        }
        return inverted;
    }
    // 3. Find Key with Highest Value
    public static String maxValueKey(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
    // 4. Merge Two Maps
    public static Map<String, Integer> mergeMaps(
            Map<String, Integer> map1,
            Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>(map1);
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            result.put(
                entry.getKey(),
                result.getOrDefault(entry.getKey(), 0) + entry.getValue()
            );
        }
        return result;
    }
    // 5. Group Employees by Department
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> map = new HashMap<>();
        for (Employee emp : employees) {
            map
                .computeIfAbsent(emp.department, k -> new ArrayList<>())
                .add(emp);
        }
        return map;
    }
    // -------------------- MAIN METHOD --------------------
    public static void main(String[] args) {
        // 1. Word Frequency Counter
        String text = "Hello world, hello Java!";
        System.out.println("Word Frequency: " + wordFrequency(text));
        // 2. Invert a Map
        Map<String, Integer> map = Map.of("A", 1, "B", 2, "C", 1);
        System.out.println("Inverted Map: " + invertMap(map));
        // 3. Key with Highest Value
        Map<String, Integer> scores = Map.of("A", 10, "B", 20, "C", 15);
        System.out.println("Max Value Key: " + maxValueKey(scores));
        // 4. Merge Two Maps
        Map<String, Integer> map1 = Map.of("A", 1, "B", 2);
        Map<String, Integer> map2 = Map.of("B", 3, "C", 4);
        System.out.println("Merged Map: " + mergeMaps(map1, map2));
        // 5. Group Employees
        List<Employee> employees = List.of(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );
        System.out.println("Grouped Employees: " +
                groupByDepartment(employees));
    }
}
