package dsalgo.linkedlist;

public class SegregateEvenOddPosition {

    public static void main(String[] args) {
        Node head = new Node(1);
        createLinkedList(head);
        printLinkedList(head);
        //segregateEvenOddNodes(head);
        oddEvenList(head);
        System.out.println("after operation");
        printLinkedList(head);
    }

    private static void oddEvenList(Node head) {
     Node odd = head;
     Node even = head.next;
     Node evenHead = even;
     while(even != null){
         odd.next = even.next;
         odd = odd.next;
         even.next = odd.next;
         even = even.next;
     }
     odd.next = evenHead;
    }

    private static void printLinkedList(Node head) {
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void segregateEvenOddNodes(Node head){
        Node curr = head;
        Node prev = null;
        Node next= null;

        while(curr.next != null && curr.next.next != null){
            prev = curr.next;//2
            next = prev.next.next;//4
            curr.next = prev.next;//3
            prev.next = next;//4
            curr = curr.next;//3
        }

    }

    public static void createLinkedList(Node head){
        Node temp = head;
        appendDataInLinkedList(head,2);
        appendDataInLinkedList(head,3);
        appendDataInLinkedList(head,4);
        appendDataInLinkedList(head,5);
        appendDataInLinkedList(head,6);
        appendDataInLinkedList(head,7);
    }

    public static void appendDataInLinkedList(Node head, int data){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node newNode = new Node(data);
        temp.next = newNode;
    }
}


class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
