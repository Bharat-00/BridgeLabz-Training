import java.util.*;
public class ListInterface {
    // 1. Reverse a List (Without using Collections.reverse)
    // Works for ArrayList & LinkedList
    public static <T> void reverseList(List<T> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
    // 2. Find Frequency of Elements
    public static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }
    // 3. Rotate Elements in a List
    public static <T> void rotateList(List<T> list, int positions) {
        int size = list.size();
        positions = positions % size;
        List<T> rotated = new ArrayList<>();
        for (int i = positions; i < size; i++) {
            rotated.add(list.get(i));
        }
        for (int i = 0; i < positions; i++) {
            rotated.add(list.get(i));
        }
        list.clear();
        list.addAll(rotated);
    }
    // 4. Remove Duplicates While Preserving Order
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new HashSet<>();
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (!seen.contains(item)) {
                seen.add(item);
                result.add(item);
            }
        }
        return result;
    }
    // 5. Find Nth Element from End (Without size())
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> fast = list.iterator();
        Iterator<T> slow = list.iterator();
        for (int i = 0; i < n; i++) {
            if (fast.hasNext())
                fast.next();
            else
                throw new IllegalArgumentException("N is larger than list size");
        }
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }
        return slow.next();
    }
    // MAIN METHOD (Testing All Problems)
    public static void main(String[] args) {
        // 1. Reverse List
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);
        List<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
        // 2. Frequency of Elements
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");
        System.out.println("Frequency Map: " + findFrequency(fruits));
        // 3. Rotate List
        List<Integer> rotateList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        rotateList(rotateList, 2);
        System.out.println("Rotated List: " + rotateList);
        // 4. Remove Duplicates
        List<Integer> duplicates = Arrays.asList(3, 1, 2, 2, 3, 4);
        System.out.println("Without Duplicates: " + removeDuplicates(duplicates));
        // 5. Nth Element from End
        LinkedList<String> letters = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println("Nth Element from End: " + findNthFromEnd(letters, 2));
    }
}
