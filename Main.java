package edu.elon.algorithms;

/**REGRADE
 *   Implementation of printFlip() method and insertion of n==2 branch fixes problems I first experienced
 *
 *    BaguenaudierPuzzle
 *    A recursive solution that works for any positive value of n.
 *
 *    Big-O --> This is Exponential: O(2^n)
 *    Recurrence Relation --> M(n) = M(n-1) + 2M(n-2)+1
 *
 *
 *    (n): #of_Moves, --> (1): 1, (2): 2, (3): 5, (4): 10, (5): 21, (6): 42, (7): 85, (8): 170, (9): 341,
 *                          (10): 682, (11): 1365, (12): 2730, (13): 5461, (14): 10922, (15): 21845,
 *                              (16): 43690, (17): 87381 (18): 174762, (19): 349525, (20): 699050
 *
 * The function performs (2^(n+1) - 2)/3 when even && (2^(n+1) - 1)/3 when odd
 *
 *    @author CaelinBahner
 */


import java.util.Scanner;


public class Main {

    static int moves;
    static int [] state;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        System.out.println("Your n value is: " + n);
        state = new int[n];

        for (int i = 0; i < n; i++) {
            state[i] = 1;
            //System.out.print(state[i]);
        }
        solve(n);

        System.out.println("\nTotal moves: " + moves);

    }
        //
        public static void solve(int n){
            //base case 1
            if(n == 0){
 //               System.out.println("Trace bc1");
                flip(n);
                printFlip();
                moves += 1;
            } else if(n == 1) {
 //               System.out.println("Trace bc2");
                flip(0);
                //System.out.println(n + " --> ");
                printFlip();
                moves += 1;
            }//end of base cases

            else if (n == 2) {

                int cnt = 0;
                while(cnt < 2) {

                    flip(cnt);
                    //System.out.println(n + " --> ");
                    printFlip();
                    System.out.println();
                    moves += 1;
                    cnt++;
                }

            }
            else{
 //               System.out.println("Trace sE");
                solve(n - 1);
                solve(n - 2);
                flip(n-1);
                //System.out.println(n + " --> ");
                printFlip();
                System.out.print("\n");
                moves= moves+1;
                solve(n - 2);
            }

        }

        public static void flip (int i){
            if (state[i] == 0) {
                state[i] = 1;
            }
            else {
                state[i] = 0;
            }

        }
        public static void printFlip() {

            for (int i = 0; i < state.length-1; i++) {
                System.out.print(state[i]);
            }
            System.out.println();
        }




}


