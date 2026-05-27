package u_Greedy;

import java.util.Arrays;

//435. Non-overlapping Intervals
//https://leetcode.com/problems/non-overlapping-intervals/description/?source=submission-noac

public class g8_Non_Overlapping_Intervals {
    public static void main(String[] args) {

    }

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort( intervals, (a, b) -> a[1]-b[1] );

        int count = 1;
        int prevEnd = intervals[0][1];

        for( int i=1; i<intervals.length; i++ ){

            int start = intervals[i][0];
            int end = intervals[i][1];

            if( start >= prevEnd ){
                prevEnd = end;
                count++;
            }
        }

        return intervals.length - count;
    }
}
