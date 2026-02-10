"""
472. Concatenated Words
Hard
Topics
premium lock icon
Companies
Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.

A concatenated word is defined as a string that is comprised entirely of at least two shorter words (not necessarily distinct) in the given array.



Example 1:

Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
"dogcatsdog" can be concatenated by "dog", "cats" and "dog";
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
Example 2:

Input: words = ["cat","dog","catdog"]
Output: ["catdog"]


Constraints:

1 <= words.length <= 104
1 <= words[i].length <= 30
words[i] consists of only lowercase English letters.
All the strings of words are unique.
1 <= sum(words[i].length) <= 105
"""

import functools


class Solution:
    def findAllConcatenatedWordsInADict(self, words: list[str]) -> list[str]:
        words = set(words)

        @functools.lru_cache
        def search(s):
            for i in range(1, len(s)):
                if s[:i] in words:
                    tail = s[i:]
                    if search(tail) or tail in words:
                        return True

            return False

        return [word for word in words if search(word)]


word_list = [
    "cat",
    "cats",
    "catsdogcats",
    "dog",
    "dogcatsdog",
    "hippopotamuses",
    "rat",
    "ratcatdogcat",
]

# word_list = ["a", "b", "ab", "abc"]

obj = Solution()
answer = obj.findAllConcatenatedWordsInADict(words=word_list)
print(answer)
