''''231. Power of Two  QuestionEditorial Solution  My Submissions
Total Accepted: 102366
Total Submissions: 264848
Difficulty: Easy
Given an integer, write a function to determine if it is a power of two.'''''


class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        binaryOfN=list(bin(n))
        del binaryOfN[0]
        del binaryOfN[0]
        isPowerOfTwo=False
        for i in range(0,len(binaryOfN)):
            if i==0 and binaryOfN[i]=='1':
                isPowerOfTwo=True
            elif i!=0 and binaryOfN[i]!='0':
                isPowerOfTwo=False
        return isPowerOfTwo







sol=Solution()
print(sol.isPowerOfTwo(32))