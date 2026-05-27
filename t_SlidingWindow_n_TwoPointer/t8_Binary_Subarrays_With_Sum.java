package t_SlidingWindow_n_TwoPointer;


// Binary Subarrays With Sum
// https://leetcode.com/problems/binary-subarrays-with-sum/description/

// Pattern 3: count subarray whose sum is equals to K

public class t8_Binary_Subarrays_With_Sum {
    public static void main(String[] args) {

    }

    public int numSubarraysWithSum(int[] nums, int goal) {

        return chck(nums, goal) - chck(nums, goal-1);
    }

    public int chck( int[]arr, int k ){

        if( k < 0 ){
            return 0;
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;

        while( right < arr.length ){
            sum += arr[right];

            while( sum > k ){
                sum -= arr[left];
                left++;
            }

            count += ( right - left) + 1;
            right++;
        }

        return count;
    }
}

    /*
       CORE IDEA: Why we do chck(k) - chck(k-1)

       We cannot directly count subarrays with sum == k using sliding window.
       So we do something smarter:

       👉 Count all subarrays with sum ≤ k
       👉 Count all subarrays with sum ≤ (k - 1)
       👉 Subtract them

       This leaves only subarrays where sum == k
       --------------------------------------------

       📦 Think in groups:

       chck(k) contains:
         sum = 0, 1, 2, ..., k-1, k

       chck(k-1) contains:
         sum = 0, 1, 2, ..., k-1

       Subtract:

         chck(k) - chck(k-1)
       = (0..k-1, k) - (0..k-1)
       = only k
       --------------------------------------------

       🧪 Example:

       nums = [1, 0, 1, 0, 1], k = 2

       All subarrays:
       [1], [1,0], [1,0,1], [1,0,1,0], ...

       Now:

       chck(2) → counts ALL subarrays with sum ≤ 2
                includes sums: 0, 1, 2
                total = 14

       chck(1) → counts ALL subarrays with sum ≤ 1
                includes sums: 0, 1
                total = 10

       Subtract:

       14 - 10 = 4

       👉 These 4 are exactly the subarrays where sum == 2:

       [1,0,1]      (0-2)
       [1,0,1,0]    (0-3)
       [0,1,0,1]    (1-4)
       [1,0,1]      (2-4)
       --------------------------------------------

       🪶 Intuition:

       Instead of finding exact matches directly (hard),
       we:
         1. Count a bigger range (≤ k)
         2. Remove the smaller range (≤ k-1)

       👉 What remains is exactly k
       --------------------------------------------

       ⚠️ Edge Case:

       When k = 0 → we call chck(-1)
       No subarray can have sum ≤ -1

       So we must handle:
       if (k < 0) return 0;
    */