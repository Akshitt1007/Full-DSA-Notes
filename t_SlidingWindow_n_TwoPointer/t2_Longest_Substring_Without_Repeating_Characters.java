package t_SlidingWindow_n_TwoPointer;


//3. Longest Substring Without Repeating Characters
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/


import java.util.HashSet;

public class t2_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {

    }

    public static int lengthOfLongestSubstring(String arr){

        HashSet<Character> set = new HashSet<>();

        int maxLength = 0;

        int currLength = 0;

        int right = 0;
        int left = 0;

        while( right < arr.length() ){

            char x = arr.charAt(right);

            while( set.contains(x) ){
                set.remove( arr.charAt(left) );
                left++;
                currLength--;
            }

            set.add( x );
            currLength++;
            right++;

            if( currLength > maxLength ){
                maxLength = currLength;
            }

        }

        return maxLength;
    }
}
