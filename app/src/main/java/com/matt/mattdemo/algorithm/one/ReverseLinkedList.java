package com.matt.mattdemo.algorithm.one;

import com.matt.mattdemo.algorithm.Node;

/**
 *
 */
public class ReverseLinkedList {

    public static Node reverseNode(Node head) {
        Node next = null;
        Node pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node reverseNode(Node head, int from, int to) {
        if (from >= to) {
            return head;
        }
        Node start = head;
        Node sysHead = start;
        Node reversePreNode = null;
        Node reverseStartNode = null;
        Node reverseEndNode = null;
        int index = 0;
        while (sysHead != null) {
            if (index == from) {
                reverseStartNode = sysHead;
                reverseEndNode = sysHead;
                break;
            }
            reversePreNode = sysHead;
            sysHead = sysHead.next;
            index++;
        }
        if (index != from){
            return head;
        }

        Node next = null;
        Node pre = null;
        index--;
        while (reverseStartNode != null) {
            if(index == to){
                break;
            }
            next = reverseStartNode.next;
            reverseStartNode.next = pre;
            pre = reverseStartNode;
            reverseStartNode = next;
            index++;
        }

        if(reversePreNode == null){
            start = pre;
        }else{
            reversePreNode.next = pre;
        }
        reverseEndNode.next = next;
        return start;
    }

    private static Node mergeNode(Node l1, Node l2) {
        Node head = null;
        if(l1 == null){
            return l2;
        }
        if(l2== null){
            return l1;
        }
        if(l1.value <= l2.value){
            head = l1;
            l1 = l1.next;
        }else{
            head = l2;
            l2 = l2.next;
        }
        Node temp = head;
        while (l1 != null && l2 != null) {
            if(l1.value<=l2.value){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1 == null){
            temp.next = l2;
        }
        if(l2 == null){
            temp.next = l1;
        }
        return head;
    }

    private static boolean compare(boolean defaultV,int v1,int v2){
        return defaultV;
    }


    public static void main(String... args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arrayOne = { 6, 7, 8, 9, 10};
        Node head = null;
        Node next = null;
        Node start = null;
        if (array.length == 0) {
            return;
        }
        start = new Node(array[0]);
        head = start;
        for (int i = 1; i < array.length; i++) {
            next = new Node(array[i]);
            head.next = next;
            head = next;
        }
        head.next = null;


        System.out.println("正常链表：");
        Node sysHead = start;
        while (sysHead != null) {
            System.out.print(sysHead.value + ",");
            sysHead = sysHead.next;
        }


        System.out.println();
        System.out.println("反转链表：");
        Node reverseHead = start;
        reverseHead = reverseNode(reverseHead);
        Node reverseIndexHead = reverseHead;
        while (reverseHead != null) {
            System.out.print(reverseHead.value + ",");
            reverseHead = reverseHead.next;
        }

        System.out.println();
        System.out.println("反转链表：从m--》n");
        reverseIndexHead = reverseNode(reverseIndexHead,0,10);
        Node mergeStartNode = reverseIndexHead;
        while (reverseIndexHead != null) {
            System.out.print(reverseIndexHead.value + ",");
            reverseIndexHead = reverseIndexHead.next;
        }


        //合并
        System.out.println();
        System.out.println("合并有序链表：");
        Node headOne = null;
        Node nextOne = null;
        Node startOne = null;
        if (arrayOne.length == 0) {
            return;
        }
        startOne = new Node(arrayOne[0]);
        headOne = startOne;
        for (int i = 1; i < arrayOne.length; i++) {
            nextOne = new Node(arrayOne[i]);
            headOne.next = nextOne;
            headOne = nextOne;
        }
        headOne.next = null;


        mergeStartNode = mergeNode(mergeStartNode,startOne);
        while (mergeStartNode != null) {
            System.out.print(mergeStartNode.value + ",");
            mergeStartNode = mergeStartNode.next;
        }


    }


}
