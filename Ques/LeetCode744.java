public class LeetCode744 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.nextGreatestLetter(new char[] { 'a', 'c', 'g', 'h', 'z' }, 'a'));
    }
}

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return letters[start % letters.length];
    }
}