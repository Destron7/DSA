/*349. Intersection of Two Arrays
Easy

C
intersection
. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000 */

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode349 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = { 1, 2, 2, 1 }, nums2 = { 2, 2 };
        System.out.println(Arrays.toString(sol.intersection(nums1, nums2)));
    }
}

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> intersect = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] && !intersect.contains(nums1[i])) {
                    intersect.add(nums1[i]);
                }
            }
        }
        int[] ans = new int[intersect.size()];
        for (int i = 0; i < intersect.size(); i++) {
            ans[i] = intersect.get(i);
        }
        return ans;
    }
}