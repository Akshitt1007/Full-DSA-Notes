package u_Greedy;


//455. Assign Cookies
//https://leetcode.com/problems/assign-cookies/description/

import java.util.Arrays;

/*

    In Greedy Algorithm:

        Our main approach is to make a locally optimal choice
        (smallest or largest element based on the problem)
        and trust that it contributes toward the globally optimal answer.

        We assume that the decision taken at the current step
        is the best possible decision and we do not reconsider
        or backtrack later.

        Greedy works on the idea:

            "Take the best choice available right now."

        In many assignment, matching, scheduling, or optimization
        problems, we usually begin by sorting the array.

        Why sort?

            - Sorting places elements in a structured order.
            - Smallest elements come first.
            - Largest elements come last.
            - It becomes easier to make optimal choices.

        Example:

            If a problem asks to satisfy minimum requirements,
            assigning the smallest valid element first avoids
            wasting larger values unnecessarily.

            Likewise, if maximum profit or larger values are needed,
            we may process from the larger side.

        Important:

            Greedy does NOT always work.

            Before applying Greedy, always ask:

            "If I make this choice now,
             will it still lead to the correct final answer?"

        Common Greedy pattern:

            1. Sort the input (if needed)
            2. Make the best choice at current step
            3. Move forward
            4. Never revisit previous decisions

*/
public class g1_Assign_Cookies {
    public static void main(String[] args) {

    }
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        int i = 0;
        int j = 0;

        while( i < g.length && j < s.length ){

            if( s[j] >= g[i] ){
                count++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }

        return count;

    }
}
