class Solution(object):
    def backspaceCompare(self, s, t):
        list1 = list(s)
        new_stack1 = []
        list2 = list(t)
        new_stack2 = []
        
        for i in range(len(list1)):
         
            if list1[i] == '#':
                if new_stack1:  
                    new_stack1.pop()
            else:
                new_stack1.append(list1[i])
                
        for i in range(len(list2)):
     
            if list2[i] == '#':
                if new_stack2:
                    new_stack2.pop()
            else:
                new_stack2.append(list2[i])
        print(new_stack1)
        print(new_stack2)
        return new_stack1==new_stack2