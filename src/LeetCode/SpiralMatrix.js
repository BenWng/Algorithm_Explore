/**
 * Created by ben on 5/10/16.
 */


/**
 * 54. Spiral Matrix
 *  Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 */


/**
 * @param {number[][]} matrix
 * @return {number[]}
 */



var spiralOrder = function(matrix) {

    if(matrix[0]===undefined){
        return [];
    }


    var Imin = 0;
    var Jmin = 0;
    var Imax = matrix.length - 1;
    var Jmax;
    if (matrix[0]!==undefined) {
         Jmax= matrix[0].length - 1;
    }
    var result = [];
    var i = 0;
    var j = 0;
    while (Jmax >= Jmin && Imax >= Imin) {
        while (j <= Jmax) {
            result.push(matrix[i][j]);
            if (j == Jmax) {
                Imin++;
                break;
            }
            else {
                j++;
            }
        }
        if(Jmax<Jmin|| Imax<Imin){break;}
        i++;

        while (i <= Imax) {
            result.push(matrix[i][j]);
            if (i == Imax) {
                Jmax--;
                break;
            }
            else {
                i++;
            }
        }
        if (Jmax<Jmin|| Imax<Imin) break;
        j--;

        while (j >= Jmin) {
            result.push(matrix[i][j]);
            if (j == Jmin) {
                Imax--;
                break;
            }
            else {
                j--;
            }
        }
        if(Jmax<Jmin|| Imax<Imin){break;}
        i--;

        while (i >= Imin) {
            result.push(matrix[i][j]);
            if (i == Imin) {
                Jmin++;
                break;
            }
            else {
                i--;
            }
        }
        if(Jmax<Jmin|| Imax<Imin){break;}
        j++;
    }

    return result;
};


console.log(spiralOrder([]));
console.log(spiralOrder([[2]]));
console.log(spiralOrder([[2,3]]));
console.log(spiralOrder([[2],[3]]));
console.log(spiralOrder([[ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ]]));