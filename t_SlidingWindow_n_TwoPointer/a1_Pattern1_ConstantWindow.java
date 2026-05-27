package t_SlidingWindow_n_TwoPointer;

/*
================================================================================
	                      TWO POINTER & SLIDING WINDOW - NOTES
================================================================================

	Two Pointer and Sliding Window problems do not follow a single fixed template.
	The approach must be molded according to each question.

	However, there are some commonly asked patterns that serve as a foundation,
	and most other questions have similarities with these patterns.

--------------------------------------------------------------------------------
	PATTERN 1 — CONSTANT WINDOW
--------------------------------------------------------------------------------

	Definition:
	    When the window size (k) is already given and remains fixed throughout.
	    The start (s) and end (e) pointers always maintain the same distance.

	Example:
	    arr = [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ],   k = 3

	Problem:
	    Find the maximum sum of a consecutive subarray of size k.

	Approach:

	    Step 1 — Calculate the sum of the first window (index 0 to k-1):

	              s     e
	        arr = [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ]
	        sum = 1 + 2 + 3 = 6
	        max = 6

	    Step 2 — Slide the window forward (end++ , start++) until end reaches the last index:

	                 s     e
	        arr = [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ]

	        Instead of recalculating the entire window sum each time (which hurts time complexity),
	        we use the previous sum and adjust it:

	            new sum = previous sum - arr[start - 1] + arr[end]
	                    = 6 - 1 + 4
	                    = 9

	        Update max if new sum > max.

	    Step 3 — Repeat Step 2 until the window reaches the end of the array.

	Key Insight:
	    Recalculating the full subarray sum every slide = O(n * k) time.
	    Using the add/remove trick keeps it at O(n) time, O(1) space.

 */
public class a1_Pattern1_ConstantWindow {
    public static void main(String[] args) {


        int[] arr = { -1, 2, 3, 4, -10, 7, 10, 19, -13 };

        int size = 3;


        System.out.println( maxSum( arr, size) );
    }

    public static int maxSum(int[] arr, int k ){
        // Edge case checks
        if( arr == null || arr.length == 0 ){
            System.out.println("Array is empty or null");
            return -1;
        }
        if( k > arr.length ){
            System.out.println("Window size is greater than array length");
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int sum = calculate( arr, k );

        max = sum;
        int start = 0;
        int end = k - 1;

        while( end < arr.length - 1 ){
            sum -= arr[start];
            start++;
            end++;
            sum += arr[end];

            if( sum > max ){
                max = sum;
            }
        }
        return max;
    }

    public static int calculate(int[] arr, int k ){
        int sum = 0;
        for( int i=0; i<k ; i++ ){
            sum = sum + arr[i];
        }
        return sum;
    }
}
