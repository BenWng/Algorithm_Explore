/**
 * Created by ben on 5/12/16.
 */

/**Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

    For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 */



var integerBreak = function(n) {
    if (n==2){
        return 1;
    }
    if (n==3){
        return 2;
    }

    var C=new Array(n+1);
    C[0]=1;
    for (var x=1;x<=n;x++){
        var max=-Infinity;
        for (var s=1;s<=x;s++){
            max=(s*C[x-s]>max)?s*C[x-s]:max;
        }
        C[x]=max;
    }
    return C[n];
};

console.log(integerBreak(3));