package t_SlidingWindow_n_TwoPointer;


//1248. Count Number of Nice Subarrays
//https://leetcode.com/problems/count-number-of-nice-subarrays/description/

public class t9_Count_Number_of_Nice_Subarrays {
    public static void main(String[] args) {

    }

    public int numberOfSubarrays(int[] nums, int k) {
        return countOdd(nums, k) - countOdd( nums, k-1);
    }

    public int countOdd( int[] arr, int k ){

        int left = 0;
        int right = 0;

        int count = 0;
        int oddCount = 0;

        while( right < arr.length ){

            if( arr[right] % 2 != 0 ){
                oddCount++;
            }

            while( oddCount > k ){

                if( arr[left] % 2 != 0 ){
                    oddCount --;
                }
                left++;
            }

            count += (right - left) + 1;
            right++;
        }

        return count;
    }
}
