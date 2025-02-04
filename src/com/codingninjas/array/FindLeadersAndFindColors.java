package com.codingninjas.array;

import java.util.ArrayList;
import java.util.Collections;

public class FindLeadersAndFindColors {

    public static void main(String[] args) {
        System.out.println("Satyam FindUnique");
        
        
//        int arr[] = {1,2,3,4,5};
        
//        Arrays.sort(arr);
        
        ArrayList<Integer> ae = new ArrayList<Integer>();
        ae.add(-2);
        ae.add(9);
        ae.add(10);
        ae.add(-7);
        ae.add(-1);
        ae.add(0);
        ae.add(-3);
//        int arr[] = {-2,9,10,-7,-1,0,-3 };
        ae = findLeaders(ae, 7);
        System.out.println(ae);
    }
    
    public static ArrayList<Integer> findLeaders(ArrayList<Integer> elements, int n) {
		// Write your code here.
		ArrayList<Integer> answer = new ArrayList<>(n);

		if ( n == 1 ) {
			answer.add(elements.get(elements.size()-1));
			return answer;
		}
		
		if ( n != 0 ) {
			answer.add(elements.get(n-1));
		}

		for( int i = n-2; i>=0; i--) {
			if ( elements.get(i) > elements.get(i+1)) {
				answer.add(elements.get(i));
			}
		}

		Collections.reverse(answer);

		return answer;
	}
}
