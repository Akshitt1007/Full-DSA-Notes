package t_SlidingWindow_n_TwoPointer;


// 992. Subarrays with K Different Integers
// https://leetcode.com/problems/subarrays-with-k-different-integers/description/
public class t10_Subarrays_with_K_Different_Integers {
    public static void main(String[] args) {

    }


    public int subarraysWithKDistinct(int[] nums, int k) {
        return count( nums, k) - count(nums,k-1);
    }

    /*
       * Doing it with hashMap is okay
       * But we are using the function like remove, put and many more
       * which in built have a lot of loops
       * Which will result in increased Time Complexity
       * Therefore we used Hash Array instead of HashMap
     */
    // public int count( int[]nums, int k ){

    //     int left = 0;
    //     int right = 0;

    //     int count = 0;

    //     HashMap<Integer, Integer> map = new HashMap<>();

    //     while( right < nums.length ){

    //         int x = nums[right];

    //         if( map.containsKey(x) ){
    //             map.put( x, map.get(x) + 1);
    //         }
    //         else{
    //             map.put( x, 1);
    //         }

    //         while( map.size() > k ){

    //             int y = nums[left];

    //             map.put( y, map.get(y) - 1);
    //             if( map.get(y) == 0 ){
    //                 map.remove( y);
    //             }
    //             left++;
    //         }
    //         count += (right - left) + 1;
    //         right++;
    //     }
    //     return count;
    // }
    public int count( int[]nums, int k ){

        int left = 0;
        int right = 0;

        int[] hash = new int[ nums.length + 1];

        int count = 0;
        int chck = 0;

        while( right < nums.length ){

            int x = nums[right];

            if( hash[x] == 0 ){
                chck++;
            }
            hash[x]++;

            while( chck > k ){
                int y = nums[left];

                hash[y]--;
                if( hash[y] == 0 ){
                    chck--;
                }

                left++;
            }

            count += (right - left) + 1;
            right++;
        }

        return count;
    }
}
