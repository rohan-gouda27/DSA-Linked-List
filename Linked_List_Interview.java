package com.rohan.Linked_List_Interview;

import com.rohan.linked_List.Linked_List_1;

public class Linked_List_Interview {
    private Node head;
    private Node tail;
    private int size;

    public Linked_List_Interview() {
        this.size = 0;
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node() {
            this.value= head.value;
        }
    }

    public void display(){
        Node node=head;
        while (node!=null){
            System.out.print(node.value+"-> ");
            node=node.next;
        }
        System.out.println("End");
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
        Node node=new Node(value);
        if(tail==null){
            insertFirst(value);
            return;
        }
        tail.next=node;
        tail=node;
        size++;
    }

    //INSERT A NEW NODE IN A PARTICULAR POSITION USING RECURSION
    private Node insert(int value,int index,Node node){
        if(index==0){
            Node temp=new Node(value,node);
            size++;
            return temp;
        }
        node.next=insert(value, index-1,node.next);
        return node;
    }
    public void insertPaarticular(int value,int index){
        head=insert(value,index,head);
    }

////////////////////////////////////////////////////////////////////
//    83.REMOVE DUPLICATE
//    1-1-1-2-4-4-4
    private void removeDuplicate(){
       Node node=head;
        while (node.next!=null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        node=tail;
        node.next=null;
    }
////////////////////////////////////////////////////////////////////
// 21. MERGE TWO SORTED LIST
    public static Linked_List_Interview merge(Linked_List_Interview first,Linked_List_Interview second){
        Node f=first.head;
        Node s=second.head;
        Linked_List_Interview ans= new Linked_List_Interview();
        while (f!=null && s!=null) {
            if (f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }
            while (f !=null){
                ans.insertLast(f.value);
                f=f.next;
            }
            while (s !=null){
                ans.insertLast(s.value);
                s=s.next;
            }
        return ans;
    }
    ////////////////////////////////////////////////////////////////////
    // 141. Linked List Cycle
    public boolean hasCycle(Node head) {
        Node fast=head;
        Node slow=head;
        while(fast !=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    ////////////////////////////////////////////////////////////////////
//    COUNT THE SIZE OF THE CYCLE
    public int countCycle(Node head){
        Node fast=head;
        Node slow=head;
        int length=0;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                Node temp=slow;
                do {
                    temp=temp.next;
                    length++;
                }while (temp!=slow);
                return length;
            }
        }
        return 0;
    }
    ////////////////////////////////////////////////////////////////////
    // 142. Linked List Cycle 2
//    public int length(Node head){
//        Node fast=head;
//        Node slow=head;
//        int length=0;
//        while (fast!=null && fast.next!=null){
//            fast=fast.next.next;
//            slow=slow.next;
//            if(fast==slow){
//                Node temp=slow;
//                do {
//                    temp=temp.next;
//                    length++;
//                }while (temp!=slow);
//                return length;
//            }
//        }
//        return 0;
//    }
//
//    public Node detectCycle(Node head) {
//        Node fast=head;
//        Node slow=head;
//        int length=0;
//        while(fast !=null && fast.next!=null){
//            fast=fast.next.next;
//            slow=slow.next;
//            if(fast==slow){
//                length=length(slow);
//              break;
//            }
//        }
//        if(length==0){
//            return null;
//        }
////     FIND THE SATRT NODE
//        Node f=head;
//        Node s=head;
//        while (length>0){
//            s=s.next;
//            length--;
//        }
////        KEEP MOVING BOTH FORWARD AND THEY MEET AT ONE POINT THAT IS THE ANSWER
//        while (f!=s){
//            f=f.next;
//            s=s.next;
//        }
//        return s;//Return anything s or f
//    }

    //LEETCODE SOLUTION FOR THIS PROBLEM
//    public int length(ListNode head){
//        ListNode fast=head;
//        ListNode slow=head;
//        int size=0;
//        while (fast!=null && fast.next !=null){
//            fast=fast.next.next;
//            slow=slow.next;
//            if(fast==slow){
//                ListNode temp=slow;
//                do{
//                    temp=temp.next;
//                    size++;
//                }while (temp!=slow);
//                return size;
//            }
//        }
//        return 0;
//    }
//    public ListNode detectCycle(ListNode head){
//        ListNode fast=head;
//        ListNode slow=head;
//        int length=0;
//        while (fast!=null &&fast.next !=null){
//            fast=fast.next.next;
//            slow=slow.next;
//            if(fast==slow){
//                length=length(slow);
//                break;
//            }
//        }
//        if(length==0){
//            return null;
//        }
//        ListNode f=head;
//        ListNode s=head;
//
//        while (length>0){
//            s=s.next;
//            length--;
//        }
//        while (f!=s){
//            f=f.next;
//            s=s.next;
//        }
//        return s;
//    }

    ////////////////////////////////////////////////////////////////////

    public boolean isHappy(int n){
        int slow=n;
        int fast=n;
        do {
            slow=Square(Square(slow));
            fast=Square(Square(Square(fast)));
        }while (slow!=fast);
        if(slow==1){
            return true;
        }
        return false;
    }
    private int Square(int number){
        int ans=0;
        while (number>0){
            int reminder=number%10;
            ans=ans+reminder*reminder;
            number/=10;
        }
        return ans;
    }
    ////////////////////////////////////////////////////////////////////
//    876.MIDDLE OF THE LINKED LIST
//    CREATE 2 POINTER AND MOVE POINTER 1-1STEP AND 2-2STEP WHEN 2ND POINTER REACH END 1ST POINTER IS IN MIDDLE
    public Node middleNode(Node head) {
        Node first=head;
        Node second=head;
        while(second!=null && second.next!=null){
            first=first.next;
            second=second.next.next;
        }
        return first;
    }
    ////////////////////////////////////////////////////////////////////
//    148.SORT LIST
 //WE NEED  GETMIDDLE,MERGE,ANOTHER ANS
    public Node sortList(Node head) {
        if(head==null || head.next==null){
            return head;
        }
        Node middle=middleNode(head);
        Node left=sortList(head);
        Node right=sortList(middle);
     return merge(left,right);
    }
    public Node merge(Node left,Node right){
        Node dummy=new Node();
        Node tail=dummy;//Add new Node in tail
        while (left !=null && right !=null){
            if(left.value<right.value){
                tail.next=left;
                left=left.next;
            }else {
                tail.next=right;
                right=right.next;
            }
            tail=tail.next;
        }
        if (left != null) {
            tail.next = left;
        } else {
            tail.next = right;
        }
        return dummy.next;
    }
    ////////////////////////////////////////////////////////////////////
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode l3=new ListNode(0);
//        int carry=0;
//        ListNode head=l3;
//        while(l1!=null && l2!=null){
//            int value=l1.val+l2.val+carry;
//            carry=value/10;
//            l3.next=new ListNode(value%10);
//            l1=l1.next;
//            l2=l2.next;
//            l3=l3.next;
//        }
//        while(l1!=null){
//            int value=l1.val+carry;
//            carry=value/10;
//            l3.next=new ListNode(value%10);
//            l1=l1.next;
//            l3=l3.next;
//        }
//        while(l2!=null){
//            int value=l2.val+carry;
//            carry=value/10;
//            l3.next=new ListNode(value%10);
//            l2=l2.next;
//            l3=l3.next;
//        }
//        if(carry!=0){
//            l3.next=new ListNode(carry);
//        }
//        return head.next;
//    }
    ////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        Linked_List_Interview list=new Linked_List_Interview();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.display();
//        list.insertPaarticular(7,3);
////        list.display();
//        Linked_List_Interview list1=new Linked_List_Interview();
//        list1.insertLast(1);
//        list1.insertLast(1);
//        list1.insertLast(1);
//        list1.insertLast(2);
//        list1.insertLast(4);
//        list1.insertLast(4);
//        list1.display();
//        list1.removeDuplicate();
//        list1.display();
//        Linked_List_Interview first=new Linked_List_Interview();
//        Linked_List_Interview second=new Linked_List_Interview();
//        first.insertLast(1);
//        first.insertLast(2);
//        first.insertLast(4);
//        second.insertLast(1);
//        second.insertLast(3);
//        second.insertLast(4);
//        Linked_List_Interview ans=Linked_List_Interview.merge(first,second);
//        ans.display();
//        Linked_List_Interview happy=new Linked_List_Interview();
//        System.out.println(happy.isHappy(19));
    }
}
