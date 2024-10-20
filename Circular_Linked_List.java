package com.rohan.linked_List;

public class Circular_Linked_List {
    private Node head;
    private Node tail;


    public Circular_Linked_List(){
        this.head=null;
        this.tail=null;
    }
    public void insert(int value){
        Node node=new Node(value);
        if(head==null){
            head=node;
            tail=node;
        }
        tail.next=node;
        node.next=head;
        tail=node;
    }
    public void display() {
        Node temp = head;
        if (temp != null) {
               do{
                   System.out.print(temp.value+"-> ");
                   temp=temp.next;
               }while (temp!=head);
            System.out.println("Head");
        }
    }
    public void delete(int value){
        Node node=head;
        if(node==null){
            return;
        }
        if(node.value==value){
            head=head.next;
            tail.next=head;
            return;
        }
        Node p=head;
        while (p.next.value!=value){
            p=p.next;
        }
        p.next=p.next.next;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Circular_Linked_List list = new Circular_Linked_List();
        list.insert(5);
        list.insert(4);
        list.insert(3);
        list.insert(2);
        list.insert(1);
        list.display();
        list.delete(4);
        list.display();
    }
}
