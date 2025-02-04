package com.codingninjas.string;

public class CountPallindrone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int gg = countNumberOfPalindromeWords("refer aios      atv we sbdfcdkb ata i   u sdhsd oo qwenr xsd fgf");
		System.out.println(gg);
	}
	
	public static int countNumberOfPalindromeWords(String s) {
        // Write your code here!
        String[] strArr = s.split(" ");
        int count = 0;

        for ( int i = 0; i < strArr.length; i++ ) {
        	if ( strArr[i] == "" ) {
        		continue;
        	}
            Boolean b = checkPallin(strArr[i]);

            if (b) {
            	++count;
            }

        }

        return count;
    }

    public static Boolean checkPallin(String curr) {

        StringBuffer s = new StringBuffer(curr);
        StringBuffer ne = s.reverse();
        return curr.toLowerCase().equals(ne.toString().toLowerCase());
    }

}
