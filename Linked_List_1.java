package com.rohan.linked_List;

public class Linked_List_1 {
    private Node head;
    private Node tail;
    private int size;

    public Linked_List_1() {
        this.size = 0;
    }
    public void insertFirst(int val){
        Node node=new Node(val);
        node.next=head;
        head=node; //head always point to first
        if(tail==null){//only one node is there
        tail=head;
        }
        size++;
    }
    public void insertLast(int value){
        if(tail==null){
           insertFirst(value);
            return;
        }
        Node node=new Node(value);
        tail.next=node;
        tail=node;
        size++;
    }
    //Insert on particular position
    public void insert(int value,int index){
        if(index==0){
            insertFirst(value);
            return;
        }
        if(index==size){
            insertLast(value);
            return;
        }
        Node temp=head;
        for (int i = 1; i < index; i++) {
            temp=temp.next;
        }
        Node node=new Node(value,temp.next);
        temp.next=node;
        node=temp;
        size++;
    }

    public int deleteFirst(){
        int value=head.value;
        if(head==null){
             tail = null;
        }
        head=head.next;
        size--;
        return value;
    }


    public Node get(int index){
        Node node=head;
        for (int i = 0; i <index ; i++) {
            node=node.next;
        }
        return node;
    }
    public int deleteLast(){
     if(size<=1){
    return deleteFirst();
  }
  Node secondLast=get(size-2);
  int value= tail.value;
   tail=secondLast;
   tail.next=null;
   size--;
  return value;
    }

    public int deleteMiddle(int index){
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }
        Node prev=get(index-1);
        int value= prev.next.value;
        prev.next=prev.next.next;
        return value;
    }

    public int find(int index){
        if(index>size-1){
            return -1;
        }
        Node node=get(index);
        int value=node.value;
        return value;
    }
    public Node findIndex(int value){
        Node node=head;
        while (node!=null){
            if(node.value==value){
                return node;
            }
            node=node.next;
        }
        return null;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value +"->");
            temp=temp.next;
        }
        System.out.println("End");
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value) { this.value = value; }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }
    public static void main(String[] args) {
        Linked_List_1 list=new Linked_List_1();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
//        list.display();
        list.insertLast(7);
        list.insert(6,2);
        list.display();
        System.out.println(list.deleteFirst());
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.deleteMiddle(2));
        list.display();
        System.out.println(list.find(3));
       list.findIndex(4);
    }
}
