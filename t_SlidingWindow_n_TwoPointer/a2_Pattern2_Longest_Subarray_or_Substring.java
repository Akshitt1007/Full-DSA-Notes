package t_SlidingWindow_n_TwoPointer;

/*
	--------------------------------------------------------------------------------
	PATTERN 2 — LONGEST SUBARRAY / SUBSTRING WITH GIVEN SUM
	--------------------------------------------------------------------------------

	Definition:
	    When the window size is NOT fixed.
	    We need to find the longest subarray or substring that satisfies a condition.
	    The window expands and shrinks dynamically.

	Example:
	    arr = [ 2, 7, 1, 5, 10 ],   sum = 14

	Problem:
	    Find the length of the longest subarray whose sum is less than or equal to the given sum.

	Approach:

	    Step 1 — Start with both left and right at index 0.
	              Expand the window by adding arr[right] to currSum, then move right++.

	              l
	              r
	        arr = [ 2, 7, 1, 5, 10 ]
	        currSum = 0,  maxLength = 0

	    Step 2 — After expanding, if currSum exceeds the target sum,
	              shrink the window from the left:

	                  currSum = currSum - arr[left]
	                  left++

	              Keep shrinking until currSum <= sum.

	    Step 3 — Once the window is valid, calculate current length:

	                  currLength = right - left
	                  (right is already incremented, so no +1 needed)

	              Update maxLength if currLength > maxLength.

	    Step 4 — Repeat Steps 1-3 until right reaches the end of the array.

	Trace:

	    arr = [ 2, 7, 1, 5, 10 ],   sum = 14

	    right=1  left=0  currSum=2   window=[2]        length=1  maxLength=1
	    right=2  left=0  currSum=9   window=[2,7]      length=2  maxLength=2
	    right=3  left=0  currSum=10  window=[2,7,1]    length=3  maxLength=3
	    right=4  left=1  currSum=13  window=[7,1,5]    length=3  maxLength=3  (shrink: 13+5=18 > 14, remove 2)
	    right=5  left=4  currSum=10  window=[10]       length=1  maxLength=3  (shrink until valid)

	    Result = 3  ✅  (window [ 7, 1, 5 ])

	Key Insight:
	    The window is not fixed — it grows from the right and shrinks from the left.
	    Always expand first, then shrink, then calculate length.
	    Since right++ happens before length calculation, use (right - left) not (right - left + 1).

*/
public class a2_Pattern2_Longest_Subarray_or_Substring {
    public static void main(String[] args) {


        int[] arr = { 2, 7, 1, 5, 10 };

        int sum = 14;

        System.out.println( maxLength( arr, sum ) );
    }

    public static int maxLength( int[]arr, int sum ){

        int maxLength = 0;

        int left = 0;
        int right = 0;

        int currSum = 0;

        while( right < arr.length ){

            currSum = currSum + arr[right];
            right++;

            while( currSum > sum ){
                currSum = currSum - arr[left];
                left++;
            }

            int currLength = (right - left) ;

            if( currLength > maxLength ){
                maxLength = currLength;
            }
        }

        return maxLength;
    }
}
