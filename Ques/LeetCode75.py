class Solution(object):

    def canPlaceFlowers(self, flowerbed, n):

        if (flowerbed[0] == 0 and flowerbed[1] == 0):
            n -= 1
        if (flowerbed[len(flowerbed) - 1] == 0
                and flowerbed[len(flowerbed) - 2] == 0):
            n -= 1
        for i in range(1, len(flowerbed) - 1):
            if (flowerbed[i - 1] == 0 and flowerbed[i + 1] == 0
                    and flowerbed[i] != 1):
                n -= 1
                flowerbed[i] = 1

        if (n == 0):
            return True
        else:
            return False


S = Solution()
print(S.canPlaceFlowers([0, 0, 1, 0, 1], 1))
