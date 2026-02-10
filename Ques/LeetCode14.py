"""
14. Longest Common Prefix
Easy
Topics
premium lock icon
Companies
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.
"""


class Solution:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        lengths = [len(x) for x in strs]
        check_str = strs[lengths.index(min(lengths))]
        prefix = ""
        i = 0
        char_equal = True
        while i < len(check_str) and char_equal:
            for s in strs:
                if s[i] != check_str[i]:
                    char_equal = False
            if char_equal == True:
                prefix += check_str[i]
            else:
                break
            i += 1
        return prefix


sol = Solution()
# print(sol.longestCommonPrefix(["reflower", "flow", "flight"]))
print(sol.longestCommonPrefix(["flower", "flow", "flight"]))
# print(sol.longestCommonPrefix(["dev", "devil", "delon"]))
