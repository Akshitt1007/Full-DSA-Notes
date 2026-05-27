package u_Greedy;


// https://leetcode.com/problems/lemonade-change/
// 860. Lemonade Change

public class g2_Lemonade_Change {
    public static void main(String[] args) {

    }

    // My Method
    public static boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;
        int twoTen = 0;

        for( int i=0; i<bills.length; i++ ){

            int bill = bills[i];

            if( bill == 5 ){
                five++;
            }

            if( bill == 10 ){

                if( five > 0 ){
                    ten++;
                    five--;
                }
                else{
                    return false;
                }
            }

            if( bill == 20 ){

                if( five > 0 && ten > 0 ){
                    twoTen ++;
                    five--;
                    ten--;
                }
                else if ( five >= 3 ){
                    five = five - 3;
                    twoTen++;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    // Striver Method
}
