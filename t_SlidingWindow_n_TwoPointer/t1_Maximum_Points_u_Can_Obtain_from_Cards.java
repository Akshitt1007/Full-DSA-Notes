package t_SlidingWindow_n_TwoPointer;

//1423. Maximum Points You Can Obtain from Cards
//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

public class t1_Maximum_Points_u_Can_Obtain_from_Cards {
    public static void main(String[] args) {

    }

    /*
    Here we have to only take element consecutively from left and right
    We can't take anything from mid.

    1. Therefore, we will first take all the 4 element from the left and store it
    2. after that we will start removing from the left and adding from the far start(end of array)
    3. Pattern 1, Questions

     */
    public static int maxScore(int[] arr, int k) {

        int currSum = calculate( arr, k );

        int max = currSum;

        int left = k-1;
        int right = arr.length-1;

        while( left >= 0 ){

            currSum = currSum - arr[left];
            left--;
            currSum = currSum + arr[right];
            right--;

            if( currSum > max ){
                max = currSum;
            }
        }

        return max;
    }

    public static int calculate( int[] arr, int k ){
        int sum = 0;
        for( int i=0; i<k; i++ ){
            sum = sum + arr[i];
        }
        return sum;
    }
}
