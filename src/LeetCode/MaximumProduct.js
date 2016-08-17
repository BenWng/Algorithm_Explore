/**
 * Created by Ben_Big on 7/9/16.
 */

/**152. Maximum Product (needs revisit)

Difficulty: Medium

Find the contiguous subarray within an array (containing at least one number) which has the largest product.
    For example, given the array [2,3,-2,4],
    the contiguous subarray [2,3] has the largest product = 6
 */

//ToDo: this problem needs revisit


var maxProductForward=function(nums){
    var max=0;
    var min=0;
    var result=0;
    var allProductFlag=true;//true means max is the product of all the elements beforehand, or max and min are both 0
    if(nums.length==1){
        return nums[0];
    }

    for (var i=0;i<nums.length;i++){
        if (allProductFlag && nums[i]!=0){
            if (nums[i]>0){
                max=Math.max(max*nums[i],nums[i]);
                min=min;
                allProductFlag=true;
            }
            if (nums[i]<0){
                max=max;
                min=Math.min(max*nums[i],nums[i]);
                allProductFlag=false;
            }
        }
        else if (!allProductFlag && nums[i]!=0){
            if (nums[i]>0){
                max=Math.max(max,nums[i]);
                min=min*nums[i];
                allProductFlag=false;
            }
            if (nums[i]<0){
                max=min*nums[i];
                min=0;
                allProductFlag=true;
            }
        }
        else {
            max=0;
            min=0;
            allProductFlag=true;
        }

        result=Math.max(result,max);

    }
    return result;
}



var maxProductReverse=function(nums){
    var max=0;
    var min=0;
    var result=0;
    var allProductFlag=true;//true means max is the product of all the elements beforehand, or max and min are both 0
    if(nums.length==1){
        return nums[0];
    }

    for (var i=nums.length-1;i>-1;i--){
        if (allProductFlag && nums[i]!=0){
            if (nums[i]>0){
                max=Math.max(max*nums[i],nums[i]);
                min=min;
                allProductFlag=true;
            }
            if (nums[i]<0){
                max=max;
                min=Math.min(max*nums[i],nums[i]);
                allProductFlag=false;
            }
        }
        else if (!allProductFlag && nums[i]!=0){
            if (nums[i]>0){
                max=Math.max(max,nums[i]);
                min=min*nums[i];
                allProductFlag=false;
            }
            if (nums[i]<0){
                max=min*nums[i];
                min=0;
                allProductFlag=true;
            }
        }
        else {
            max=0;
            min=0;
            allProductFlag=true;
        }

        result=Math.max(result,max);

    }
    return result;
}


maxProduct=function(nums){
    return Math.max(maxProductForward(nums),maxProductReverse(nums));
}


console.log(maxProduct([2,3,-4,5,-6,-7,2]));//expecting 720
console.log(maxProduct([2,0,4,-8]));//expecting 4
console.log(maxProduct([0,0,0]));//expecting 0
console.log(maxProduct([-5]));//expecting -5
console.log(maxProduct([3,-1,4]));//expecting 4
console.log(maxProduct([5,-5]));//expecting 5

/*partitioning at the last negative number - forward algorithm
 partitioning at the last negative number - reverse algorithm
 */

console.log(maxProduct([2,-5,-2,-4,3]));//expecting 24