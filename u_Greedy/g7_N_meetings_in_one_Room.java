package u_Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


//https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
public class g7_N_meetings_in_one_Room {
}


class Meeting{
    int start;
    int end;
    public Meeting(int s, int e){
        this.start=s;
        this.end=e;
    }
}

class Solution {

    public int maxMeetings(int start[], int end[]) {

        List<Meeting> meetings = new ArrayList<>();

        for(int i=0; i<start.length; i++){
            meetings.add(new Meeting(start[i],end[i]));
        }

        meetings.sort(Comparator.comparingInt(m -> m.end));

        int count = 1;

        int endTime = meetings.get(0).end;

        for( int i=1; i<start.length; i++ ){

            int st = meetings.get(i).start;
            int ed = meetings.get(i).end;

            if( st > endTime ){
                endTime = ed;
                count++;
            }
        }

        return count;
    }
}

