package t_SlidingWindow_n_TwoPointer;

//1358. Number of Substrings Containing All Three Characters
//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

public class t6_Number_of_Substrings_Containing_All_Three_Characters {
    public static void main(String[] args) {

    }

    public static int numberOfSubstrings(String s) {

        int[] freq = new int[3]; // for 'a','b','c'
        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {

            freq[s.charAt(right) - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {

                count += (s.length() - right);  // 🔥 magic line

                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return count;
    }
}
