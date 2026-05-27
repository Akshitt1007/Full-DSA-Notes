package c_Arrays;

import java.util.List;

//https://www.hackerrank.com/contests/adsawithjava/challenges/the-birthday-bar/problem

public class x20_Subarray_Division {
    public static void main(String[] args) {

    }

    public static int birthday(List<Integer> s, int block_sum, int block_size) {

        int count = 0;

        for( int i=0; i<s.size(); i++ ){

            int temp_sum = 0;
            int size = 0;

            for( int j=i; j<s.size(); j++ ){

                if (size < block_size) {

                    temp_sum += s.get(j);
                    size++;

                    if (size == block_size) {
                        if (temp_sum == block_sum) {
                            count++;
                        }
                        break;
                    }
                }

            }
        }

        return count;

    }
}
