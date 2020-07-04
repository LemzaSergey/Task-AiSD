package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class LogicWorkJava {

    public static <T> Queue<Integer> sortingWithConservationOrder(Queue<Integer> queue) throws Exception {

        Queue<Integer> tempPositive = new LinkedList<>();
        Queue<Integer> tempZero = new LinkedList<>();
        Queue<Integer> tempNegative = new LinkedList<>();

        int temp;

        while (queue.peek() != null) {
            temp = queue.poll();
            if (temp < 0) {
                tempNegative.add(temp);
            }
            if (temp == 0) {
                tempZero.add(temp);
            }
            if (temp > 0) {
                tempPositive.add(temp);
            }
        }
        while (tempNegative.peek() != null) {
            queue.add(tempNegative.poll());
        }
        while (tempZero.peek() != null) {
            queue.add(tempZero.poll());
        }
        while (tempPositive.peek() != null) {
            queue.add(tempPositive.poll());
        }

        return queue;
    }
}
