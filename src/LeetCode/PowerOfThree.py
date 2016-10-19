'''
326. Power of Three  QuestionEditorial Solution  My Submissions
Total Accepted: 68284
Total Submissions: 176519
Difficulty: Easy
Given an integer, write a function to determine if it is a power of three.
'''

#ToDo: I did not think of this solution myself, therefore it needs revisit

#The bit manipulation solution which works for powerOfTwo and powerOfFour does not work here


class Solution(object):
    def isPowerOfThree(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if (n==0):
            return False
        return(pow(3,65)%n==0)


sol=Solution()
sol.isPowerOfThree(10)