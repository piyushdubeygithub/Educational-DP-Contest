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
        IntersectingLinkedList list = new IntersectingLinkedList();
        // creating first linked list
        list.head1 = new Node(3);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(10);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);
        // creating second linked list
        list.head2 = new Node(10);
        list.head2.next = list.head1.next.next.next;
        list.head2.next.next = list.head1.next.next.next.next;


        // method 1
        System.out.println("The node of intersection is " + getNode());

        // method 2
        System.out.println("The node of intersection is " + getIntersectedNode(head1, head2));

    }

    private static int getIntersectedNode(Node head1, Node head2) {
        if(head1 == null || head2 == null){
            return -1;
        }
        Node temp1 = head1;
        Node temp2 = head2;
        while(temp1 != temp2){
            temp1 = temp1 == null?head2:temp1.next;
            temp2 = temp2 == null?head1:temp2.next;
        }
            return temp1.data;
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
            if(temp1==temp2){
                return temp1.data;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        temp1 = null;
        temp1 = null;
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
