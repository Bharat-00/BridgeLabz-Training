class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=next;
    }
}
class ListNode{
    Node head;
    public void addFirst(int data){
        Node newNode =new Node(data);
        if(head==null){
            head=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        }
    }
}
public class AddNodeAtFirst {
    public static void main(String [] args){
        ListNode listNode = new ListNode();
        listNode.addFirst(10);
        listNode.addFirst(20);
    }
    
}
