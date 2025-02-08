# A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.
#
# Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.
# MEDIUM

class Solution:
    def maxWidthRamp(self, nums):
        stack = []

        length = len(nums)

        for index in range(length - 1, -1, -1):
            if not stack or nums[index] > nums[stack[-1]]:
                stack.append(index)

        answer = 0

        for index in range(length):
            while stack and nums[index] <= nums[stack[-1]]:
                nextIndex = stack.pop(-1)
                answer = max(answer, nextIndex - index)

        return answer


ques = [999,999,999,996,994,994,994,993,993,990,990,990,987,987,986,985,984,983,983,983,982,981,980,979,979,979,978,977,975,975,974,972,972,971,971,970,969,968,968,967,967,966,966,924,966,963,962,960,959,958,956,956,956,956,956,951,951,951,948,946,946,943,941,941,938,937,936,936,932,931,930,929,505,928,927,927,925,923,923,920,919,919,918,916,914,914,914,911,911,910,908,908,905,904,902,473,900,900,900,899,899,899,898,897,897,897,896,895,892,891,890,889,888,888,887,887,884,884,883,880,880,880,879,878,878,878,876,875,875,874,873,871,869,868,867,866,865,864,862,862,861,858,856,851,850,849,849,849,846,846,845,845,845,844,844,842,840,840,838,838,837,836,833,833,833,831,830,829,829,828,827,827,827,826,824,821,820,817,815,815,812,812,811,810,810,810,808,807,805,804,804,802,802,802,802,801,800,406,799,797,797,795,795,795,793,793,792,792,790,786,786,786,785,785,783,783,781,780,779,778,777,775,774,774,773,773,772,771,771,770,769,769,847,767,767,767,764,764,764,762,761,759,758,757,755,755,753,751,751,751,750,748,748,747,746,746,745,745,742,742,740,740,740,740,737,734,727,726,725,724,723,722,721,720,719,719,718,717,717,716,715,715,714,713,713,713,713,713,711,708,706,702,699,698,697,696,696,695,693,693,693,692,689,687,687,687,684,684,684,683,682,681,681,681,680,679,679,677,677,675,672,671,671,671,670,670,667,667,666,666,665,664,664,664,663,663,663,662,662,659,659,659,658,654,653,653,649,648,647,647,646,644,639,637,637,636,635,631,631,629,629,628,628,628,628,704,625,625,621,620,618,618,615,612,610,610,610,610,609,609,606,605,602,601,601,601,600,598,597,594,593,593,591,589,585,585,584,583,583,582,581,580,579,579,579,578,578,577,576,576,575,574,574,573,572,570,569,568,567,566,565,565,563,563,563,561,561,561,560,559,558,556,554,551,548,546,545,544,543,542,541,541,537,533,533,532,531,531,529,528,525,523,523,522,521,521,520,519,514,513,512,511,510,510,508,507,507,507,503,501,500,499,497,494,494,492,491,491,489,487,487,486,485,485,484,483,483,482,482,480,480,480,480,479,479,478,478,478,477,477,477,476,475,473,472,470,470,468,468,466,463,462,462,462,461,460,460,459,459,458,456,454,453,450,876,449,449,448,447,446,444,443,443,442,442,441,441,440,439,439,438,437,436,434,432,431,431,430,428,428,428,425,424,424,422,421,421,420,419,419,419,418,418,417,416,415,414,412,411,411,410,409,409,408,408,408,407,405,405,404,404,402,400,399,398,396,396,396,395,395,395,390,389,388,387,387,383,381,381,381,380,380,379,379,379,379,377,376,375,374,374,374,374,373,373,373,372,372,370,369,369,368,366,365,363,361,360,359,359,357,356,356,356,354,352,351,349,348,348,347,346,346,345,342,342,339,338,337,337,336,335,334,333,331,330,330,329,328,328,327,327,326,324,324,323,321,321,320,320,318,318,317,316,316,315,314,313,312,310,308,308,307,307,306,306,303,302,299,299,297,295,294,294,293,293,292,289,289,287,287,285,283,280,277,276,272,272,272,271,270,270,268,268,267,266,265,265,263,262,262,261,259,258,257,257,256,256,255,254,251,251,250,250,250,249,247,247,247,243,242,242,239,239,238,236,235,235,232,232,231,230,230,230,229,228,227,225,224,223,221,220,218,218,217,217,217,216,216,214,214,211,210,209,208,207,204,199,199,198,198,198,196,196,196,196,195,195,193,191,191,190,188,186,185,181,180,179,178,178,177,176,174,173,173,171,170,170,170,170,169,169,730,168,166,165,165,163,159,159,158,157,156,155,152,152,151,150,148,146,144,144,143,143,143,141,140,140,138,132,131,130,130,129,128,128,127,126,126,125,121,120,119,118,118,115,114,114,114,114,113,112,112,112,111,110,110,107,106,106,106,105,105,102,102,98,97,96,96,96,93,92,91,91,90,89,89,88,88,88,88,87,85,85,81,80,80,79,78,78,78,78,78,77,76,75,74,74,57,74,72,72,71,70,70,69,69,69,68,68,68,68,7,65,61,61,60,59,59,59,58,56,55,54,53,53,53,52,52,52,51,51,51,50,50,48,48,48,47,47,46,45,44,42,38,38,37,36,36,34,34,33,33,33,32,32,32,32,31,31,30,29,29,28,27,26,26,22,22,21,18,17,17,17,16,14,14,14,13,11,11,11,10,9,8,8,7,4,2,0,0]
obj = Solution()
print(f"ANS: {obj.maxWidthRamp([9,8,1,0,1,9,4,0,4,1])}")
# print(f"ANS: {obj.maxWidthRamp([6,0,8,2,1,5])}")
print(f"ANS: {obj.maxWidthRamp(ques)}")