class Solution(object):
    def isSubsequence(self, s, t):
        if len(s) == 0:
            return True
        elif len(s) > len(t):
            return False
        else:
            j = 0
            i = 0
            while i < len(s) and j < len(t):
                if s[i] == t[j]:
                    i += 1
                j += 1

            return i == len(s)
s = Solution()
print(s.isSubsequence("","ahbgdc"))