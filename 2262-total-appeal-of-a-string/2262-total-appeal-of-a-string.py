
        
class Solution(object):
    def appealSum(self, s):
        """
        :type s: str
        :rtype: int
        """
        result = curr = 0
        lookup = [-1]*26
        for i, c in enumerate(s):
            result += (i-lookup[ord(c)-ord('a')])*(len(s)-i)
            lookup[ord(c)-ord('a')] = i
        return result
        