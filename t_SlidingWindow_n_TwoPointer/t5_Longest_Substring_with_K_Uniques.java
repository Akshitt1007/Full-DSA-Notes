package t_SlidingWindow_n_TwoPointer;


//Longest Substring with K Uniques
//https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1


import java.util.HashMap;
import java.util.HashSet;

public class t5_Longest_Substring_with_K_Uniques {
    public static void main(String[] args) {

    }

    // With Hashmap
    public int longestKSubstr_I( String s, int k ){

        HashMap< Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        int count = 0;
        int maxLength = Integer.MIN_VALUE;

        while( right < s.length() ){

            char x = s.charAt(right);

            if( map.containsKey(x) ){
                map.put( x, map.get(x) + 1);
            }
            else{
                map.put( x, 1 );
            }


            while( map.size() > k ){

                char y = s.charAt(left);

                map.put( y, map.get(y)-1 );

                if( map.get(y) == 0 ){
                    map.remove(y);
                }

                count --;
                left++;
            }

            right++;
            count++;

            maxLength = Math.max( count, maxLength );
        }

        if( map.size() != k ){
            return -1;
        }
        else{
            return maxLength;
        }
    }

    // 2. Without HashMap.
    public int longestKSubstr(String s, int k) {

        int[] feq = new int[26];
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;

        int maxLength = Integer.MIN_VALUE;
        int currLength = 0;

        while( right < s.length() ){

            char x = s.charAt(right);

            set.add(x);
            feq[x - 'a']++;
            // To convert the character into the numeric value
            // that we would be storing in 0-25 array
            // a - 0
            // y - 24

            while( set.size() > k ){

                char y = s.charAt(left);

                feq[y - 'a']--;

                if (feq[y - 'a'] == 0) {
                    set.remove(y);
                }

                currLength--;
                left++;
            }


            right++;
            currLength++;

            if( currLength > maxLength ){

                maxLength = currLength;
            }
        }

        if( set.size() == k ){
            return maxLength;
        }
        else{
            return -1;
        }
    }


}
