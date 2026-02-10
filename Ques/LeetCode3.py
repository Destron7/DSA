def lengthOfLongestSubstring(s):
    """
    :type s: str
    :rtype: int
    """
    max_length = 0
    unique_chars = list()

    for char in s:
        if char in unique_chars:
            index = unique_chars.index(char)
            unique_chars = unique_chars[index + 1 :]

        unique_chars.append(char)
        max_length = max(max_length, len(unique_chars))

    return max_length


print(lengthOfLongestSubstring("abcabcbb"))
print(lengthOfLongestSubstring("pwwkew"))
print(lengthOfLongestSubstring("au"))
print(lengthOfLongestSubstring(""))
print(lengthOfLongestSubstring(" "))
print(lengthOfLongestSubstring("dvdf"))
