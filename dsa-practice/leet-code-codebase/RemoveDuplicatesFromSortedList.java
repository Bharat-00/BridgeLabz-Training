public class RemoveDuplicatesFromSortedList {
    int val;
    RemoveDuplicatesFromSortedList next;
    RemoveDuplicatesFromSortedList() {}
    RemoveDuplicatesFromSortedList(int val) { this.val = val; }
    RemoveDuplicatesFromSortedList(int val, RemoveDuplicatesFromSortedList next) { this.val = val; this.next = next; }
}
class Solution {
    public RemoveDuplicatesFromSortedList deleteDuplicates(RemoveDuplicatesFromSortedList head) {
        if(head==null||head.next==null){
            return head;
        }
        RemoveDuplicatesFromSortedList temp=head;
        RemoveDuplicatesFromSortedList curr=head.next;
        while(temp!=null && temp.next!=null){
            if(temp.val==curr.val){
                temp.next=curr.next;
                curr=curr.next;
            }
            else{
                temp=temp.next;
                curr=curr.next;
            }
    
        }
        return head;
        
    }
}