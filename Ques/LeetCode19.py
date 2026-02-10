"""17. Letter Combinations of a Phone Number
Medium
Topics
premium lock icon
Companies
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.




Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9']."""

import itertools


class Solution:
    def letterCombinations(self, digits: str) -> list[str]:
        if len(digits) == 0:
            return []

        char_dict = {
            "2": list("abc"),
            "3": list("def"),
            "4": list("ghi"),
            "5": list("jkl"),
            "6": list("mno"),
            "7": list("pqrs"),
            "8": list("tuv"),
            "9": list("xyz"),
        }

        i = 0
        answer = char_dict[digits[i]]

        while (len(digits) > 1) and ((i + 1) < len(digits)):
            for oc in answer:
                for ic in char_dict[digits[i + 1]]:
                    print(oc + ic)
                    answer.append((oc + ic))
            i += 1
            print(answer        return 


"""
For permutations we'll use itertools.permutations module
"""

sol = Solution()
print(sol.letterCombinations("34"))

# print(type(list("abc")))
# print(list("abc"))
