class Solution(object):
    def mergeAlternately(self, word1, word2):
        list1 = list(word1)
        list2 = list(word2)
        result = ""

        for i in range(len(list1)):
            if i < len(list2):
                result += list1[i] + list2[i]
            else:
                result += list1[i]
        result += ''.join(list2[len(list1):])

        return result
