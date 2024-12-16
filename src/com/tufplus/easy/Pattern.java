package com.tufplus.easy;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Pattern {

//    N = 5
//                    *
//                   ***
//                  *****
//                 *******
//                *********

    public static void main(String[] args) {
//        createPyramid(9);
//        createPyramidA(4);
//        createPyramid2(4);
//        createReversePyramid2(4);
//        bothFrontReversePyramid(4);
//        sidePyramid(5);
//        braShape(9);
//        squareStar(4);
//        braShapeStar(4);
//        printRoundNumber(5);
//        printDCBA(4);
//        newPattern(9);
//        primeNumber(36);
//        System.out.println(reverseString("Satyam"));
//    	patternCode360(3);
    	takeInputPrintPattern();
    }
    
    static void takeInputPrintPattern() {
    	Scanner sc = new Scanner(System.in);
    	int input = sc.nextInt();
    	int[] inputArray = new int[input];
    	
    	for (int i = 0; i < input; i++) {
    		inputArray[i] = sc.nextInt();
		}
    	
    	for (int i : inputArray) {
    		patternCode360(i);
		}
    }

//    String
    public static String reverseString(String s) {
        //your code goes here
        int i = 0;
        int j = s.length() - 1;
        String newString = "";
        return Pattern.reverse(s, newString, j);
    }

    public static String reverse(String s, String newString, int j) {

        if ( 0 >= j ) {
            return newString + s.charAt(0);
        }



        char temp = s.charAt(j);
        newString += temp;
//        int[] nums = new int[0];
//        int sum  = nums.length;

        return reverse(s, newString, j - 1);
    }


//    Vector<Character>
//    public static Vector<Character> reverseString(Vector<Character> s) {
//        //your code goes here
//        int i = 0;
//        int j = s.size() - 1;
//
//        Pattern.reverse(s, i, j);
//        return s;
//    }
//
//    public static void reverse(Vector<Character> s, int i, int j) {
//
//        if ( i >= j ) {
//            return;
//        }
//
//        char temp = s.get(i);
//        s.set(i, s.get(j));
//        s.set(j, temp);
//
//        reverse(s, i + 1, j - 1);
//    }

    public int[] divisors(int n) {

        ArrayList<Integer> arr = new ArrayList<>();
        int sqrtN = (int) Math.sqrt(n);

        for ( int i = 1; i <= sqrtN; i++) {

            if ( n % i == 0 ) {
                arr.add(i);
            }

            if ( i != n/i ) {
                arr.add( n/i );
            }
        }

        // Convert the list to an array
        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = (int) arr.get(i);
        }

        return ans;
    }
    
    
    static void patternCode360(int n) {
    	
    	int r = 1;
    	
    	for (int c = 1; c <= n; c++) {

    	//space
    	for (int i = c; i < n; i++) {
			System.out.print(" ");
		}
    	
    	// number
    	for (int i = 1; i <= c; i++) {
			System.out.print(r);
			r++;
			if ( r > 9 ) {
				r = 1;
			}
		}
    	System.out.println();
    	
    	}	
    }

    private static void primeNumber(int n) {
        if ( n == 0 ) {
            System.out.println("not prime");
        }

        for (int i = 2; i < Math.sqrt(n); i = i+2) {

            if ( n%i == 0 ) {
                System.out.println("not prime");
            }
        }
        System.out.println("prime");
    }

    private static void newPattern(int n) {

        //top
        for (int i = 1; i <= n; i++) {

            //first star
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }

            //space
            for (int k = 0; k < 2 * i - 2; k++) {
                System.out.print(" ");
            }

            //second star
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }
//            for (int j = 1, m = i; j <= i; j++, m--) {
//                System.out.print("*");
//            }

            System.out.println();
        }

        //down
        for (int i = 1; i <= n; i++) {

            //first star
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            //space
            for (int k = 1; k <= (2 * n) - 2*i; k++) {
                System.out.print(" ");
            }
            //second star
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printDCBA(int n) {
        int character = 'D';
        for (int i = 0; i < n; i++) {
            character = character - i;
            for (int j = 0; j <= i; j++) {
                System.out.print((char)character);
                character++;
            }
            character--;
            System.out.println();
        }
    }

    private static void printRoundNumber(int n) {
//        5 5 5 5 5 5 5 5 5
//        5 4 4 4 4 4 4 4 5
//        5 4 3 3 3 3 3 4 5
//        5 4 3 2 2 2 3 4 5
//        5 4 3 2 1 2 3 4 5
//        5 4 3 2 2 2 3 4 5
//        5 4 3 3 3 3 3 4 5
//        5 4 4 4 4 4 4 4 5
//        5 5 5 5 5 5 5 5 5
        for (int i = 0; i < n*2-1; i++) {
            for (int j = 0; j < n*2-1; j++) {
                int top = i;
                int left = j;
                int bottom = (2*n - 2) - i;
                int right = (2*n - 2) - j;
                int minimumVal = n-Math.min(Math.min(top, left), Math.min(bottom, right));
                System.out.print(minimumVal);
            }
            System.out.println();
        }


    }

    private static void braShapeStar(int n) {

            for (int i = 1; i <= n; i++) {

                //first side
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }

                //space
                for (int k = 1; k <= (2 * n) - (i) * 2; k++) {
                    System.out.print(" ");
                }

                //second side
                for (int j = 1, m = i; j <= i; j++, m--) {
                    System.out.print("*");
                }

                System.out.println();
            }
    }

    private static void squareStar(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void createPyramidA(int n) {

        for (int i = 1; i <= n; i++) {

            char c = 'A';
            //space
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }

            //ABC
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print(c);
                if (j <= (2*i-1)/2) {
                    c++;
                } else {
                    c--;
                }
            }
            System.out.println();
        }
    }

    private static void braShape(int n) {

        for (int i = 1; i <= n; i++) {

            //first side
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            //space
            for (int k = 1; k <= (2 * n) - (i) * 2; k++) {
                System.out.print(" ");
            }

            //second side
            for (int j = 1, m = i; j <= i; j++, m--) {
                System.out.print(m);
            }

            System.out.println();
        }

    }

    private static void createPyramid(int n) {
        int i = n;
        int x = n;
        for (int j = 1; j <= n; j++,x++) {
            for (int k = 1; k <= x; k++) {
                if (k >= i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            i--;
            System.out.println();
        }
    }

    public static void createPyramid2(int n) {
        for (int i = 1; i <= n; i++) {

            //space
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }

            //star
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void createReversePyramid2(int n) {
        for (int i = n; i >= 1; i--) {

            //space
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }

            //star
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void bothFrontReversePyramid(int n) {

        for (int i = 1; i <= n; i++) {

            //space
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }

            //star
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = n; i >= 1; i--) {

            //space
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }

            //star
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void sidePyramid(int n) {
        int h = 1;
        for (int i = 1; i < 2*n; i++) {
            if (i <= n) {
                //upper stars
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
            } else {
                //lower stars
                for (int j = 1; j <= (i-(2*h)); j++) {
                    System.out.print("*");
                }
                h++;
            }
            System.out.println();
        }

    }

}
