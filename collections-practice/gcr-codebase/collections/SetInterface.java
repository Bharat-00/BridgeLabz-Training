import java.util.*;
public class SetInterface {
    // 1. Check if Two Sets Are Equal
    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);
    }
    // 2. Union of Two Sets
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }
    // 2. Intersection of Two Sets
    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }
    // 3. Symmetric Difference
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        for (T element : set2) {
            if (!result.add(element)) {
                result.remove(element);
            }
        }
        return result;
    }
    // 4. Convert Set to Sorted List
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        return sortedList;
    }
    // 5. Check if One Set is Subset of Another
    public static <T> boolean isSubset(Set<T> subset, Set<T> mainSet) {
        return mainSet.containsAll(subset);
    }
    // MAIN METHOD (Testing All Problems)
    public static void main(String[] args) {
        // 1. Check if Two Sets Are Equal
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));
        System.out.println("Sets Equal: " + areSetsEqual(set1, set2));
        // 2. Union & Intersection
        Set<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> setB = new HashSet<>(Arrays.asList(3, 4, 5));
        System.out.println("Union: " + union(setA, setB));
        System.out.println("Intersection: " + intersection(setA, setB));
        // 3. Symmetric Difference
        System.out.println("Symmetric Difference: " + symmetricDifference(setA, setB));
        // 4. Convert Set to Sorted List
        Set<Integer> unsortedSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        System.out.println("Sorted List: " + convertToSortedList(unsortedSet));
        // 5. Find Subset
        Set<Integer> subset = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> mainSet = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        System.out.println("Is Subset: " + isSubset(subset, mainSet));
    }
}
