class Solution(object):
    def increasingTriplet(self, nums):
        i=0
        temp_list=[]
        for i in range(len(nums)):
            if (len(nums[i:]) >= 3):
                if(len(temp_list)==3):

                    temp_list=[]
                else:
                    temp_list.append(nums[i:(i+3)])
                    print(temp_list)
        
        flag=False
        for i in range(len(temp_list)):
            if temp_list[i][0]< temp_list[i][1] < temp_list[i][2]:
                flag = True
        return flag
    
s = Solution()
print(s.increasingTriplet([5,4,3,2,1]))