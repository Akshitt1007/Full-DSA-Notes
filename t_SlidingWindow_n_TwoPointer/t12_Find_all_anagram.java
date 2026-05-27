package t_SlidingWindow_n_TwoPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//438. Find All Anagrams in a String
//https://leetcode.com/problems/find-all-anagrams-in-a-string/

public class t12_Find_all_anagram {
    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> lst = new ArrayList<>();

        int right = 0;
        int left = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for( int i=0; i<p.length(); i++ ){
            char ch = p.charAt(i);
            map.put( ch, map.getOrDefault(ch,0)+1 );
        }
        int count = p.length();

        while( right < s.length() ){

            char ch = s.charAt(right);

            if( map.containsKey(ch) ){
                if(map.get(ch)>0){
                    count--;
                }
                map.put(ch,map.get(ch)-1);
            }

            while( right - left >= p.length() ){

                char l = s.charAt(left);

                if(map.containsKey(l)){

                    if(map.get(l)>=0){
                        count++;
                    }
                    map.put(l,map.get(l)+1);
                }
                left++;
            }

            if( count == 0 ){
                lst.add( left);
            }
            right++;

        }
        return lst;
    }
}
