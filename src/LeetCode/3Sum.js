/**
 * Created by Ben_Big on 10/25/16.
 */
/*15. 3Sum   QuestionEditorial Solution  My Submissions
Total Accepted: 155317
Total Submissions: 764535
Difficulty: Medium
Contributors: Admin
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

    Note: The solution set must not contain duplicate triplets.

    For example, given array S = [-1, 0, 1, 2, -1, -4],

    A solution set is:
    [
        [-1, 0, 1],
        [-1, -1, 2]
    ]
*/


//The following code definitely works, and the time complexity is acceptable O(n^2), it is rejected by leetcode, because the arrays in the result array are in different order from the standard solution.


/*
var uniqueNums=[];
var hashWhoseValueIsCount={};
var hashWhoseValueIsArray={};
var result=[];


var addToHashCountingOccurrence=function(nums){
    for (var i in nums) {
        var num=nums[i];
        if (num in hashWhoseValueIsCount) {
            hashWhoseValueIsCount[num]++;
        }
        else {
            hashWhoseValueIsCount[num] = 1;
            uniqueNums.push(num);
        }
    }
}

var cal2Sum=function(){
    for (var i=0;i<uniqueNums.length;i++){
        if (hashWhoseValueIsCount[uniqueNums[i]]>1){
            hashWhoseValueIsArray[uniqueNums[i]*2]=[[uniqueNums[i],uniqueNums[i]]];
        }
        for (var j=i+1;j<uniqueNums.length;j++){
            var sum=uniqueNums[i]+uniqueNums[j];
            if (sum in hashWhoseValueIsArray){
                hashWhoseValueIsArray[sum].push([uniqueNums[i],uniqueNums[j]]);
            }
            else{
                hashWhoseValueIsArray[sum]=[[uniqueNums[i],uniqueNums[j]]];
            }
        }
    }
}

var cal3Sum=function(){
    for (var sum in hashWhoseValueIsArray){
        if (-sum in hashWhoseValueIsCount){
            for (var i in hashWhoseValueIsArray[sum]){
                var twoSum=hashWhoseValueIsArray[sum][i];
                if (twoSum.indexOf(-sum)>-1){
                    if (sum!==0 && hashWhoseValueIsCount[-sum]>1){
                        var newThreeSum=twoSum.slice();
                        newThreeSum.push(-sum);
                        removeDuplicate(newThreeSum)
                        result.push(newThreeSum);
                    }
                    else if(sum===0 && hashWhoseValueIsCount[0]>=3){
                        result.push([0,0,0]);
                    }

                }
                else{
                    var newThreeSum=twoSum.slice();
                    sum!==0?newThreeSum.push(-sum):newThreeSum.push(0);
                    removeDuplicate(newThreeSum);
                    result.push(newThreeSum);
                }
            }
        }
    }
}

var removeDuplicate=function(arr){
    var arr1=[arr[0],arr[1]];
    var arr2=[arr[1],arr[2]];
    var arr3=[arr[0],arr[2]];
    var subArr=[arr1,arr2,arr3];
    for (var i=0;i<subArr.length;i++){
        var sum=subArr[i][0]+subArr[i][1];
        if (sum in hashWhoseValueIsArray) {
            var combinationArray = hashWhoseValueIsArray[sum];
            for (var j = 0; j < combinationArray.length; j++) {
                var currentCombination=combinationArray[j].sort();
                var soughtCombination=subArr[i].sort();
                if (currentCombination[0]=== soughtCombination[0] &&
                    currentCombination[1]=== soughtCombination[1]) {
                    combinationArray.splice(j, 1);
                }
            }
        }
    }


}


var threeSum = function(nums) {
    addToHashCountingOccurrence(nums.sort());
    cal2Sum();
    cal3Sum();
    return result;
};


console.log(threeSum([-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]));*/

//ToDo: The following method is from Leetcode, it is much simpler than mine

var threeSum=function(nums){
    nums.sort(function(a,b){
        return a-b;
    });
    var result=[];
    var i=0;
    while(i<nums.length){
        tempI=nums[i];
        var j=i+1;
        var k=nums.length-1;
        while(j<k){
            if (nums[i]+nums[j]+nums[k]<0){
                var temp=nums[j];
                j++;
                if (nums[j]===temp){
                    j++;
                }
            }
            else if (nums[i]+nums[j]+nums[k]>0){
                var temp=nums[k];
                k--;
                if (nums[k]===temp){
                    k--;
                }
            }
            else{
                result.push([nums[i],nums[j],nums[k]]);
                var tempJ=nums[j];
                var tempK=nums[k];
                j++;
                k--;
                while(nums[k]===tempK){
                    k--;
                }
                while (nums[j]===tempJ){
                    j++;
                }
            }
        }
        while(nums[i]===tempI){
            i++;
        }
    }
    return result;
};

console.log(threeSum([-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]));