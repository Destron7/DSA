import math


class Solution(object):
    def minEatingSpeed(self, piles, h):
        l, r = 1, max(piles)
        res = r
        while l <= r:
            k = (l + r) // 2
            hours = 0

            for pile in piles:
                hours += math.ceil(pile / k)

            if hours <= h:
                res = min(k, res)
                r = k - 1
            else:
                l = k + 1

        return res


obj = Solution()
print(obj.minEatingSpeed([30, 11, 23, 4, 20], 5))
