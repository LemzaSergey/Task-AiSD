package com.company;

import ru.vsu.cs.util.ArrayUtils;

import java.lang.reflect.Array;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        MyListNode<Integer> head = null;

        head = new MyListNode<>(5);
        head = new MyListNode<>(3, head);
        head = new MyListNode<>(1, head);

        // MyListUtils.forEach(head, node -> System.out.println(node.getValue()));

        MyDoublyLinkedListNode<Integer> headD = null;

        headD = new MyDoublyLinkedListNode<>(7, null, null);
        headD = new MyDoublyLinkedListNode<>(9, headD, headD);
        headD = new MyDoublyLinkedListNode<>(4, headD, headD);
        headD = new MyDoublyLinkedListNode<>(2, headD, null);


        MyDoublyLinkedListNode temp;
        //MyListUtils.NodeByIndex(headD, 1);
        //MyListUtils.insertAfter(headD.getNext(), 0);
        //MyListUtils.insertAfter(headD, 0);
        //MyListUtils.insertBefore(MyListUtils.NodeByIndex(headD, 1), 6);
        temp = headD;
        for (int i = 0; i < MyListUtils.getSize(headD); i++) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }


        System.out.println(MyListUtils.NodeByIndex(headD, 0).getValue());
        System.out.println(MyListUtils.NodeByIndex(headD, 1).getValue());
        System.out.println(MyListUtils.NodeByIndex(headD, 2).getValue());
        System.out.println(MyListUtils.NodeByIndex(headD, 3).getValue());
        System.out.println(MyListUtils.NodeByIndex(headD, 4).getValue());
        System.out.println(MyListUtils.NodeByIndex(headD, 5).getValue());
        System.out.println(MyListUtils.NodeByIndex(headD, 6).getValue());
        System.out.println(MyListUtils.NodeByIndex(headD, 7).getValue());
        System.out.println(MyListUtils.NodeByIndex(headD, 8).getValue());
        System.out.println(MyListUtils.NodeByIndex(headD, 9).getValue());




        // MyListNode<Integer> fead = MyListUtils.converterMyDoublyLinkedListNodeToMyListNode(headD);

        // MyListUtils.forEach(fead, node -> System.out.println(node.getValue()));


        //System.out.println(headD.getValue());
        //System.out.println(headD.getNext());
        //System.out.println(headD.getPrev());

        //Integer[] arrO = MyListUtils.toArray(fead);
        //int[] arr;
        //arr = ArrayUtils.toPrimitive(arrO);
        //System.out.println( arr[0]);

    }
}
