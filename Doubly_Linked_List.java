package com.rohan.linked_List;

public class Doubly_Linked_List {
    private Node head;
    private Node tail;


    private class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
    public void insertFirst(int value){
        Node node=new Node(value);
        node.next=head;
        node.prev=null;
        if(head!=null) {
            head.prev = node;
        }
        head=node;
    }
    public void display(){
        Node node=head;
        if(node==null){
            return;
        }
        while(node!=null){
            System.out.print(node.value+" ->");
            node=node.next;
        }
        System.out.println();
    }

    public void displayRev(){
        Node node=head;
        Node last=null;
        while(node!=null){
            System.out.print(node.value+" ->");
            last=node;
            node=node.next;
        }
        System.out.println("End");
        while (last!=null){
            System.out.print(last.value+"-> ");
            last=last.prev;
        }
        System.out.println("Start");
    }
    public int addLast(int value){
        Node node=new Node(value);
        Node temp=head;
        node.next=null;
        //IF NODE IS EMPTY
        if(head==null){
            head.prev=null;
            head=node;
            return head.value;
        }
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        node.prev=temp;
        return value;
    }
    public Node get(int value){
        Node node=head;
        for (int i = 0; i <value ; i++) {
            node=node.next;
        }
        return node;
    }
    public Node FindValue(int value){
        Node node=head;
        while(node!=null){
            if(node.value==value){
               return node;
            }
            node=node.next;
        }
      return node;
    }
    public void addMiddle(int index,int value){
        Node p=FindValue(index);
        //WHAT IF P NOT EXISTS
        if(p==null){
            System.out.println("Does Not Exits");
            return;
        }
        Node node=new Node(value);
        node.next=p.next;//new node is still outside so p.next points to old next node
        p.next=node;
        node.prev=p;
        if(node.next!=null){
            node.next.prev=node;
        }
    }
    public static void main(String[] args) {
        Doubly_Linked_List list=new Doubly_Linked_List();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);

//        list.display();
//        System.out.println(list.addLast(7));
        list.display();
        list.addMiddle(4,10);
        list.display();
       list.displayRev();
    }
}
