/**
 * Created by Ben_Big on 6/11/16.
 */


/**
 * 164. Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */


// ToDo: the commented out code is what I thought out originally, the bucket sort idea is from leetcode, it therefore needs revisit


var maximumGap=function(nums){
    var n=nums.length;
    if (n<=1){
        return 0;
    }
    var MaxMin=findMaxMin(nums);
    var Max=MaxMin[0];
    var Min=MaxMin[1];
    var gap=Math.ceil((Max-Min)/(n-1));
    //bucket sort
    var bucketArray=new Array(n);
    for (var i=0;i<n;i++){
        var k=Math.floor((nums[i]-Min)/gap);
        if (bucketArray[k]===undefined){
            bucketArray[k]=new Array(2);
            bucketArray[k][0]=nums[i];
            bucketArray[k][1]=nums[i];
        }
        else if(nums[i]<bucketArray[k][0]){
            bucketArray[k][0]=nums[i];
        }
        else if(nums[i]>bucketArray[k][1]){
            bucketArray[k][1]=nums[i];
        }
    }
    var sortedArray=new Array;
    for (var i=0;i<n;i++){
        if (bucketArray[i]!==undefined){
            sortedArray.push(bucketArray[i][0]);
            sortedArray.push(bucketArray[i][1]);
        }
    }
    return findGap(sortedArray);
}


var findMaxMin=function(nums){
    var Max=-Infinity;
    var Min=Infinity;
    for (var i=0;i<nums.length;i++){
        if (nums[i]>Max){
            Max=nums[i];
        }
        if (nums[i]<Min){
            Min=nums[i];
        }
    }
    return [Max,Min]
}


var findGap=function(sortedArray){
    var maxGap=0;
    for (var i=0;i<sortedArray.length-1;i++){
        var temp=sortedArray[i+1]-sortedArray[i];
        maxGap=temp>maxGap?temp:maxGap;
    }
    return maxGap;
}

console.log(maximumGap([3,8,0,19]));
console.log(maximumGap([2,9999999]));
console.log(maximumGap([3,1,8888]));
console.log(maximumGap([1,1,1,1,1,5,5,5,5,5]));

/*
var maximumGap = function(nums) {
    if (nums.length<=1){
        return 0;
    }
    var MaxMin=findMaxMin(nums);
    var Max=MaxMin[0];
    var Min=MaxMin[1];
    var sortedArr=countSort(nums,Max,Min);
    return findGap(sortedArr);
};

var findMaxMin=function(nums){
    var Max=-Infinity;
    var Min=Infinity;
    for (var i=0;i<nums.length;i++){
        if (nums[i]>Max){
            Max=nums[i];
        }
        if (nums[i]<Min){
            Min=nums[i];
        }
    }
    return [Max,Min]
}


var countSort=function(nums,Max,Min){
    var countArr=(new Array(Max-Min+1)).fill(0);
    var result=(new Array(nums.length)).fill(0);
    var resultPointer=0;
    for(var i=0;i<nums.length;i++){
        countArr[nums[i]-Min]++;
    }
    for(var j=0;j<countArr.length;j++){
        var count=countArr[j];
        for (var k=0;k<count;k++){
            result[resultPointer]=j;
            resultPointer++;
        }
    }
    return result;
}


var findGap=function(sortedArray){
    var maxGap=0;
    for (var i=0;i<sortedArray.length-1;i++){
        var temp=sortedArray[i+1]-sortedArray[i];
        maxGap=temp>maxGap?temp:maxGap;
    }
    return maxGap;
}






//Test findMaxMin
console.log(findMaxMin([1,2,3,4,5,6,7]));//expecting [7,1]

//Test findGap
console.log(findGap([1,3,6,7,18]));//expecting 11

//Test countSort
console.log(countSort([1,3,6,7,18],18,1));

//Test maximumGap
console.log(maximumGap([3,8,0,19]));//expecting 11

//Test maximumGap
console.log(maximumGap([2,9999999]));
*/


