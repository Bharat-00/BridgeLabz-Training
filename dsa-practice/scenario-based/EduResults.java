import java.util.*;
// ---------------- STUDENT CLASS ----------------
class Student {
    int rollNo;
    int marks;
    public Student(int rollNo, int marks) {
        this.rollNo = rollNo;
        this.marks = marks;
    }
}
// ---------------- MERGE SORT LOGIC ----------------
class MergeSort {
    public static void sort(List<Student> list) {
        if (list.size() <= 1) return;
        int mid = list.size() / 2;
        List<Student> left = new ArrayList<>(list.subList(0, mid));
        List<Student> right = new ArrayList<>(list.subList(mid, list.size()));
        sort(left);
        sort(right);
        merge(list, left, right);
    }
    private static void merge(List<Student> result, List<Student> left, List<Student> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).marks >= right.get(j).marks) {
                result.set(k++, left.get(i++)); // stable
            } else {
                result.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) result.set(k++, left.get(i++));
        while (j < right.size()) result.set(k++, right.get(j++));
    }
}
// ---------------- MAIN CLASS ----------------
public class EduResults {
    public static void main(String[] args) {
        List<Student> stateRankList = new ArrayList<>();
        // District-wise sorted data
        stateRankList.add(new Student(101, 88));
        stateRankList.add(new Student(102, 92));
        stateRankList.add(new Student(103, 75));
        stateRankList.add(new Student(104, 92));
        stateRankList.add(new Student(105, 81));
        MergeSort.sort(stateRankList);
        System.out.println("📊 Final State Rank List:");
        for (Student s : stateRankList) {
            System.out.println("Roll No: " + s.rollNo + ", Marks: " + s.marks);
        }
    }
}
