package u_Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

public class g6_Job_Sequencing_Problem {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> jobSequencing( int[] deadline, int[] profit) {

        ArrayList<int[]> list = new ArrayList<>();

        for(int i=0; i<deadline.length; i++){
            list.add(new int[]{deadline[i], profit[i]});
        }

        Collections.sort(list, (a, b)->b[1]-a[1]);

        int maxDeadline=0;

        for(int x=0; x<deadline.length; x++){
            maxDeadline=Math.max(maxDeadline,x);
        }

        int hash[]=new int[maxDeadline+1];

        Arrays.fill(hash,-1);

        int count=0;
        int pt=0;

        for(int i=0; i<list.size(); i++){

            int dl=list.get(i)[0];
            int prof=list.get(i)[1];

            while(dl>0){

                if(hash[dl]==-1){

                    hash[dl]=prof;

                    pt+=prof;

                    count++;

                    break;
                }

                dl--;
            }
        }

        ArrayList<Integer> ans=new ArrayList<>();

        ans.add(count);
        ans.add(pt);

        return ans;
    }
}
