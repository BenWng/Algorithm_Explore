'''342. Power of Four  QuestionEditorial Solution  My Submissions
Total Accepted: 41133
Total Submissions: 112160
Difficulty: Easy
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.'''





class Solution(object):
    def isPowerOfFour(self, num):
        """
        :type num: int
        :rtype: bool
        """
        binaryOfN = list(bin(num))
        del binaryOfN[0]
        del binaryOfN[0]
        isPowerOfFour = False
        if(len(binaryOfN)%2!=1):
            return False
        for i in range(0, len(binaryOfN)):
            if i == 0 and binaryOfN[i] == '1':
                isPowerOfFour = True
            elif i != 0 and binaryOfN[i] != '0':
                isPowerOfFour = False
        return isPowerOfFour




sol=Solution()
print(sol.isPowerOfFour(8))