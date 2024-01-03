/*
 * BASEBALL GAME
 * You are keeping the scores for a baseball game with strange rules. At the
 * beginning of the game, you start with an empty record.
 * 
 * You are given a list of strings operations, where operations[i] is the ith
 * operation you must apply to the record and is one of the following:
 * 
 * An integer x.
 * Record a new score of x.
 * '+'.
 * Record a new score that is the sum of the previous two scores.
 * 'D'.
 * Record a new score that is the double of the previous score.
 * 'C'.
 * Invalidate the previous score, removing it from the record.
 * Return the sum of all the scores on the record after applying all the
 * operations.
 * 
 * The test cases are generated such that the answer and all intermediate
 * calculations fit in a 32-bit integer and that all operations are valid.
 */

import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (String operation : operations) {
            if (operation.equals("D")) {
                int tempNo = stack.peek() * 2;
                stack.push(tempNo);
            } else if (operation.equals("C")) {
                stack.pop();
            } else if (operation.equals("+")) {
                int tempNo = stack.pop();
                int newNo = tempNo + stack.peek();
                stack.push(tempNo);
                stack.push(newNo);
            } else {
                stack.push(Integer.parseInt(operation));
            }
        }

        for (int score : stack) {
            sum += score;
        }
        return sum;
    }
}

public class LeetCode682 {
}