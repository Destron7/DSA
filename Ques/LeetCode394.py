class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        for char in s:
            if char == ']':
                cur_str = ''
                while stack[-1] != '[':
                    cur_str = stack.pop() + cur_str
                stack.pop()
                cur_num = ''
                while stack and stack[-1].isdigit():
                    cur_num = stack.pop() + cur_num
                stack.append(cur_str * int(cur_num))
            else:
                stack.append(char)
        return "".join(stack)
