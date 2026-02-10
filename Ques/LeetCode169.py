"""
169. Majority Element
Easy
Topics
premium lock icon
Companies
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space?
"""


class Solution:
    def majorityElement(self, nums: list[int]) -> int:
        freq_num = dict()
        for num in nums:
            if num not in freq_num.keys():
                freq_num[num] = 1
            else:
                freq_num[num] += 1

        max = 0
        max_key = -1
        for key in freq_num.keys():
            if freq_num[key] > max and freq_num[key] > n / 2:
                max_key = key
        return max_key

obj = Solution()
obj.majorityElement([2, 2, 1, 1, 1, 2, 2])
