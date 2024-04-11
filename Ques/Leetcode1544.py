class Solution(object):
    def makeGood(self, s):
        new_stack = []
        if s:  
            new_stack.append(s[0])  
            for i in range(1, len(s)): 
                if new_stack and s[i].lower() == new_stack[-1].lower():
                    if (s[i].isupper() and new_stack[-1].islower()) or (new_stack[-1].isupper() and s[i].islower()):
                        new_stack.pop()  
                    else:
                        new_stack.append(s[i]) 
                else:
                    new_stack.append(s[i])  

        result = "".join(new_stack)
        return result
