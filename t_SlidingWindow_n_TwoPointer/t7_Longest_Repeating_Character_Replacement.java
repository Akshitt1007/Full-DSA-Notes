package t_SlidingWindow_n_TwoPointer;

// 424 Longest Repeating Character Replacement
// https://leetcode.com/problems/longest-repeating-character-replacement/description/

public class t7_Longest_Repeating_Character_Replacement {
    public static void main(String[] args) {

    }
    public static int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int left = 0;
        int right = 0;

        int maxLength = 0;
        int length = 0;
        int maxFreq = 0;

        while( right < s.length() ){

            char x = s.charAt(right);

            freq[ x - 'A']++;

            maxFreq = Math.max( maxFreq, freq[ x - 'A'] );

            length++;

            while( length - maxFreq > k ){

                char y = s.charAt(left);

                freq[ y - 'A']--;

                maxFreq = 0;
                for( int i=0; i<26; i++ ){
                    maxFreq = Math.max( maxFreq, freq[i] );
                }

                left++;
                length--;
            }

            if( length - maxFreq <= k ){
                maxLength = Math.max( length, maxLength);
            }

            right++;
        }

        return maxLength;
    }
}
