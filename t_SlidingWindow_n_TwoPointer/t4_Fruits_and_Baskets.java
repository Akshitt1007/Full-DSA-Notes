package t_SlidingWindow_n_TwoPointer;
import java.util.HashMap;
import java.util.HashSet;

//904. Fruit Into Baskets
//https://leetcode.com/problems/fruit-into-baskets/description/

public class t4_Fruits_and_Baskets {
    public static void main(String[] args) {

    }

    // With HashMap
    public static int totalFruit_I( int[] fruits ){

        HashMap<Integer, Integer> map = new HashMap<>();

        int right = 0;
        int left = 0;

        int count = 0;
        int maxCount = Integer.MIN_VALUE;

        while( right < fruits.length ){

            int x = fruits[right];

            // map.put( x, map.getOrDefault(x, 0) + 1 );

            if( map.containsKey(x) ){
                map.put( x, map.get(x) + 1);
            }
            else{
                map.put( x, 1);
            }

            while( map.size() > 2 ){

                int num = fruits[left];

                // decrease frequency
                map.put(num, map.get(num) - 1);

                // remove if it becomes 0
                if (map.get(num) == 0) {
                    map.remove(num);
                }

                left++;
                count--;
            }

            count++;
            right++;

            if( count > maxCount ){
                maxCount = count;
            }
        }

        return maxCount;
    }

    // 2. Without HashMaps
    public int totalFruit(int[] fruits) {

        HashSet<Integer> hs = new HashSet<>();
        int[] freq = new int[50000];

        int left = 0;
        int right = 0;

        int maxLength = Integer.MIN_VALUE;
        int currLength = 0;

        while( right < fruits.length ){

            hs.add( fruits[right] );
            freq[fruits[right]]++;
            // Increasing the freq

            while( hs.size() > 2 ){

                freq[fruits[left]]--;
                if(freq[fruits[left]] == 0 ){
                    hs.remove(fruits[left]);
                }

                currLength--;
                left++;
            }

            currLength++;
            right++;

            if( currLength > maxLength ){
                maxLength = currLength;
            }

        }
        return maxLength;
    }
}
