package t_SlidingWindow_n_TwoPointer;

//1004. Max Consecutive Ones III
//https://leetcode.com/problems/max-consecutive-ones-iii/description/

public class t3_Max_Consecutive_Ones_III {
    public static void main(String[] args) {

    }

    public static int longestOnes(int[] nums, int k) {

        int left = 0;
        int right = 0;

        int maxLongest = Integer.MIN_VALUE;
        int currLongest = 0;

        int xero = 0;

        while( right < nums.length ){

            if( nums[right] == 0 ){
                xero++;
            }

            while( xero > k ){

                if( nums[left] == 0 ){
                    xero--;
                }

                currLongest--;
                left++;

            }

            currLongest++;
            right++;

            if( currLongest > maxLongest ){
                maxLongest = currLongest;
            }
        }

        return maxLongest;
    }

}
