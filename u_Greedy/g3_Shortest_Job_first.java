package u_Greedy;


//https://www.geeksforgeeks.org/problems/shortest-job-first/1
//Shortest Job First

import java.util.Arrays;

public class g3_Shortest_Job_first {
    public static void main(String[] args) {

    }

    static int solve(int bt[]) {

        int time = 0;
        int totalTime = 0;

        Arrays.sort( bt );


        for( int i=0; i<bt.length; i++ ){

            if( i != bt.length-1 ){
                time += bt[i];
                totalTime += time;
            }


        }

        int avgTime = totalTime/bt.length;

        return avgTime;
    }
}
