 public class MergeTwoSortedLists {
    int val;
    MergeTwoSortedLists next;
    MergeTwoSortedLists() {}
    MergeTwoSortedLists(int val) { this.val = val; }
    MergeTwoSortedLists(int val, MergeTwoSortedLists next) { this.val = val; this.next = next; }
}
@SuppressWarnings("unused")
class Solution {
    public MergeTwoSortedLists mergeTwoLists(MergeTwoSortedLists list1, MergeTwoSortedLists list2) {
        MergeTwoSortedLists dummy = new MergeTwoSortedLists(-1);
        MergeTwoSortedLists current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        return dummy.next;
    }
}