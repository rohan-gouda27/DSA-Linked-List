package com.rohan.Linked_List_Interview;

public class LinlkedList {
    private ListNode head;
    private ListNode tail;
    private int size;

    public LinlkedList() {
        this.size = 0;
    }

public class ListNode {
      int val;
      ListNode next;
      ListNode() {

      }
      ListNode(int val) {
       this.val = val;
      }
      ListNode(int val, ListNode next) {
       this.val = val; this.next = next;
      }
      }
    public void insertLast(int val) {
        ListNode node=new ListNode(val);
        node.next=head;
        head=node; //head always point to first
        if(tail==null){//only one node is there
            tail=head;
        }
        size++;
    }
    public void display(){
        if(head==null){
            return;
        }
        ListNode temp=head;
        while (temp!=null){
            System.out.print(temp.val+"-> ");
            temp=temp.next;
        }
        System.out.println("End");
    }
    public void insertFirst(int value){
        ListNode node =new ListNode(value);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
            size++;
        }
    }

    //206.REVERSE A LINKED LIST

    public void recursionReverse(ListNode node){
        if(node==tail){
            head=tail;
            return;
        }
        recursionReverse(node.next);
        tail.next=node;
        tail=node;
        tail.next=null;
    }
//IN PLACE REVERSE
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode next = head.next;
            ListNode curr = head;

            while(curr != null)
            {

                curr.next = prev;//IT IS JUST POINTING TOWARDS BACK
                prev = curr;
                curr = next;
                if(next!=null){
                    next=next.next;
                }
            }
            return prev;
        }

        //DELETE MIDDLE NODE
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null) {
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(prev!=null){
            prev.next=slow.next;
        }
        return head;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    142. Linked List Cycle II
public class Solution {
    public int length(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        int length=0;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                ListNode temp=slow;
                do {
                    temp=temp.next;
                    length++;
                }while (temp!=slow);
                return length;
            }
        }
        return 0;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        int length=0;
        while(fast !=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                length=length(slow);
                break;
            }
        }
        if(length==0){
            return null;
        }
//     FIND THE SATRT NODE
        ListNode f=head;
        ListNode s=head;
        while (length>0){
            s=s.next;
            length--;
        }
//        KEEP MOVING BOTH FORWARD AND THEY MEET AT ONE POINT THAT IS THE ANSWER
        while (f!=s){
            f=f.next;
            s=s.next;
        }
        return s;
    }
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
public ListNode middle(ListNode head) {
    ListNode first=head;
    ListNode second=head;
    while(second!=null && second.next!=null){
        first=first.next;
        second=second.next.next;
    }
    return first;
}

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    234. Palindrome Linked List
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode present=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow;
        ListNode reverse=reverseList(mid);
        ListNode reversedNode=reverse;
        while (head !=null && reverse !=null){
            if(head.val!=reverse.val){
                break;
            }
            head=head.next;
            reverse=reverse.next;
        }
        reverseList(reversedNode);
    return head==null|| reverse==null;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    143. REORDER LIST
//    1-2-1-2-1-2  FROM REVERSER
//    FIND MID ,REVERSE AFTER MID
    public ListNode middleNode(ListNode head) {
        ListNode first=head;
        ListNode second=head;
        while(second!=null && second.next!=null){
            first=first.next;
            second=second.next.next;
        }
        return first;
    }
    public void reorderList(ListNode head){
        ListNode mid=middleNode(head);
        ListNode h2=reverseList(mid);
        ListNode h1=head;
        while (h1!=null &&h2!=null){
            ListNode temp=h1.next;
            h1.next=h2;
            h1=temp;

            temp=h2.next;
            h2.next=h1;
            h2=temp;
        }
}
    public static void main(String[] args) {
        LinlkedList list=new LinlkedList();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.display();
//        list.recursionReverse();

    }
}