package u_Greedy;

// 55. Jump Game I
//https://leetcode.com/problems/jump-game/
public class g4_Jump_Game_I {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {

        int maxIndex = 0;

        for( int i=0; i<nums.length; i++ ){

            int maxJump = nums[i];

            if( maxIndex < i ){
                return false;
            }

            if( maxJump + i > maxIndex ){
                maxIndex = maxJump + i;
            }
        }
        return true;
    }
}
	/*
		LAYMAN EXPLANATION:

		Think of standing on stones across a river.

		i          -> current stone position
		nums[i]    -> maximum jump power at this stone
		maxIndex   -> farthest stone reachable so far

		We do NOT actually jump.

		We only keep asking:

		"How far can I reach till now?"

		As we move through the array, we keep expanding
		our reachable area.

		If someday current position becomes greater than
		maxIndex, it means:

		We reached a place that was never reachable.

		Game over -> return false


		-------------------------------------------------

		SHORT DRY RUN

		Input:

		[2,3,1,1,4]


		Start:

		maxIndex = 0


		i = 0

		jump = 2

		reach = 0 + 2 = 2

		maxIndex = 2


		i = 1

		1 <= 2 ✓

		jump = 3

		reach = 1 + 3 = 4

		maxIndex = 4


		i = 2

		2 <= 4 ✓


		i = 3

		3 <= 4 ✓


		i = 4

		4 <= 4 ✓


		End reached

		return true


		-------------------------------------------------

		MEMORY TRICK:

		Keep expanding reachable boundary.

		If current index goes outside boundary
		=> return false
	*/
