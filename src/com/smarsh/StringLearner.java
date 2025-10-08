package com.smarsh;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * StringLearner.java
 * 
 * Description: [Add class description here]
 * 
 * @author satyamsahu
 * @since 06-Sep-2025
 */
public class StringLearner {

	public static void main(String[] args) {

//		StringLearner a = new StringLearner();
		
		char[] ch1= {'a','r','a','t','a','n','a'};
		String str4=new String(ch1, 1, 5);
		System.out.println(str4);
		
		byte[] b={65,66,67,68,69,70};
		String str5=new String(b);
		System.out.println(str5);
		byte[] b1={65,66,67,68,69,70};
		String str6=new String(b1,2,4);
		System.out.println(str6);
		
		
		// StringBuffer
//		StringBuffer sb = new StringBuffer("sravyainfotech");
//		System.out.println(sb);
		
		
		
		String str="ratan";
		str.concat("soft");
		System.out.println(str);
		//mutability class (modifications on existing content possible)
		StringBuffer sb = new StringBuffer("anu");
		sb.append("soft");
		System.out.println(sb);
		
		
		StringBuffer sb1 = new StringBuffer("students");
		StringBuffer sb2 = new StringBuffer("students");
		System.out.println(sb1==sb2); //reference comparison false
		System.out.println(sb1.equals(sb2)); //reference comparison false
		
		
//		StringBuffersb=new StringBuffer("rattaiah");
		System.out.println(sb);
		System.out.println(sb.delete(1,3));
		System.out.println(sb);
		System.out.println(sb.deleteCharAt(1));
		System.out.println(sb.reverse());
		sb.append("Satyam");
		sb.insert(0, "Hi ");
		System.out.println(sb);
		
		sb.replace(0,2,"oy");
		System.out.println(sb);
		
		
		
		
		
		
		//
		String str22="hi ratan w r u wt bout anushka";
		StringTokenizer st = new StringTokenizer(str22);//split the string with by default (space symbol)
		while (st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}
		//used our string to split giver String
		String str1 = "hi,rata,mf,sdfsdf,ara"; //StringTokenizer(str1,",");
//		while (st.hasMoreElements()) {
//			StringTokenizer st1 = new StringTokenizer(str1,",");
//			System.out.println(st1.nextElement());
//		}
		
		String[] strArray = str1.split(",");
		
		Arrays.stream(strArray).forEach(s-> System.out.println(s));
		
	}
}
