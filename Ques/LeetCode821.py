class Solution(object):
    def shortestToChar(self, s, c):
        i = 0 
        j = 0
        ans = []
        while j < len(s):
            count = 0  # Initialize count outside the loop
            if s[j] == c:
                while i != j:
                    i += 1
                    count += 1
                ans.append(count)
            else:
                ans.append(count)  # Append count even if s[j] != c
            j += 1
        return ans
