class Solution(object):
    def removeDuplicateLetters(self, s):
        stack = []
        count=0
        stack.append(s[0])
        for i in range(1,len(s)):
            new_string=s[(i+1):]
            print("new_sring ",new_string) 
            if(s[i]!=stack[count]):
                if(ord(stack[count])>ord(s[i])):
                    if(new_string.rfind(stack[count])!=-1):
                        while count >= 0 and ord(stack[count]) > ord(s[i]):
                            print("pop ", stack.pop())
                            count -= 1
                            
                        print("append 1 ",s[i])
                        stack.append(s[i])
                        count+=1
                    else:
                        print("append 2", s[i])
                        stack.append(s[i])
                        count+=1
                else:
                    try:
                       stack.index(s[i])
                    except:  # noqa: E722
                        print("append 3 ", s[i])
                        stack.append(s[i])
                        count+=1
            else:
                continue
            print(stack)
        result ="".join(stack)
        return result


print(Solution.removeDuplicateLetters('hello',"abacb"))