package t_SlidingWindow_n_TwoPointer;


import java.util.HashMap;

//2461. Maximum Sum of Distinct Subarrays With Length K
//https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/

public class t11_Maximum_Sum_of_Distinct_Subarrays_With_Length_K {

    public static void main(String[] args) {
    }

    public long maximumSubarraySum(int[] nums, int k) {

        int left = 0;
        int right = 0;

        long max = 0;
        long sum = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        while(right < nums.length){

            int x = nums[right];
            sum += x;

            map.put(x, map.getOrDefault(x,0)+1);

            while(right - left + 1 > k){

                int y = nums[left];
                sum -= y;

                map.put(y, map.get(y)-1);

                if(map.get(y)==0){
                    map.remove(y);
                }

                left++;
            }


            if( right - left == k-1 ){
                if( map.size() == k ){

                    if( sum > max ){
                        max = sum;
                    }
                }
            }
            right++;
        }

        return max;
    }
}
