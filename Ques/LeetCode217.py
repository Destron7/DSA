"""
217. Contains Duplicate
Easy
Topics
premium lock icon
Companies
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.

Example 2:

Input: nums = [1,2,3,4]

Output: false

Explanation:

All elements are distinct.

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]

Output: true



Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
"""

from collections import Counter


class Solution:
    def containsDuplicate(self, nums: list[int]) -> bool:
        nums.sort()
        i = 0
        while i < len(nums) - 1:
            if nums[i] == nums[i + 1]:
                return True
        return False

    def containsDuplicate2(self, nums: list[int]) -> bool:
        freq_dict = Counter(nums)
        if max(freq_dict.values()) == 1:
            return False
        return False


obj = Solution()
print(
    obj.containsDuplicate(
        [
            7,
            10,
            5,
            5,
            6,
            6,
            4,
            10,
            5,
            4,
            9,
            4,
            9,
            6,
            5,
            9,
            6,
            3,
            6,
            5,
            6,
            7,
            7,
            4,
            9,
            9,
            10,
            5,
            8,
            1,
            8,
            3,
            2,
            7,
            5,
            10,
            1,
            8,
            5,
            8,
            4,
            3,
            6,
            4,
            9,
            4,
            2,
            8,
            3,
            2,
            2,
            1,
            5,
            6,
            3,
            2,
            6,
            1,
            8,
            6,
            2,
            9,
            1,
            4,
            5,
            10,
            8,
            5,
            10,
            5,
            10,
            1,
            4,
            8,
            3,
            6,
            4,
            10,
            9,
            1,
            1,
            1,
            2,
            2,
            9,
            6,
            6,
            8,
            1,
            9,
            2,
            5,
            5,
            2,
            1,
            8,
            5,
            2,
            3,
            10,
        ]
    )
)
