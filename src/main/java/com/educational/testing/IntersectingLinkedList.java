package com.educational.testing;

public class IntersectingLinkedList {

    static Node head1, head2;

    static class Node{
        int data;
        Node next;
        Node(int data){
          this.data = data;
          this.next = null;
        }
    }

    public static void main(String[] args) {

        // creating first linked list
        head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(19);
        head1.next.next.next = new Node(15);
        head1.next.next.next.next = new Node(30);
        // creating second linked list
        head2 = new Node(10);
        head2.next = new Node(15);
        head2.next.next = new Node(30);

        System.out.println("The node of intersection is " + getNode());

    }

    private static int getNode() {
       int c1 = getNodeCount(head1);
       int c2 = getNodeCount(head2);
       int d ;
       if(c1>c2){
           d = c1-c2;
           return getIntersectionNode(d, head1, head2);
       }else{
           d = c2-c1;
           return getIntersectionNode(d, head2, head1);
       }
    }

    private static int getIntersectionNode(int d, Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        for(int i=0; i<d; i++){
            temp1 = temp1.next;
        }
        while(temp1 != null && temp2 != null){
            if(temp1.data == temp2.data){
                return temp1.data;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return -1;
    }

    private static int getNodeCount(Node head1) {
        int count = 0;
        Node temp = head1;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

}
