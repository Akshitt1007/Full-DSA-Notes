package c_Arrays;

import java.util.ArrayList;
import java.util.Arrays;

//56. Merge Intervals
//https://leetcode.com/problems/merge-intervals/description/

public class x19_Merge_Intervals {
    public static void main(String[] args) {



    }

    public int[][] merge(int[][] distance) {

        ArrayList<int[]> list = new ArrayList<>();

        for( int i=0; i< distance.length; i++ ){
            Arrays.sort(( distance[i] ) );
        }

        Arrays.sort(distance,(a,b) -> Integer.compare(a[0], b[0]));

        for( int i=0; i<distance.length; i++ ){
            int x = distance[i][0];
            int y = distance[i][1];

            list.add( new int[]{x,y} );
        }

        int idx = 0;

        while( idx!= list.size()-1 ){

            int a = list.get(idx)[0];
            int b = list.get(idx)[1];

            int x = list.get(idx + 1)[0];
            int y = list.get(idx + 1)[1];

            if( b >= x ){
                if( b > y  ){
                    list.remove(idx);
                    list.remove(idx);
                    list.add(idx, new int[]{a, Math.max(a, b)});
                }
                else {
                    list.remove(idx);
                    list.remove(idx);
                    list.add(idx, new int[]{a, Math.max(a, y)});
                }
            }
            else{
                idx++;
            }
        }

        int[][] result = list.toArray(new int[list.size()][]);


        return result;
    }
}
