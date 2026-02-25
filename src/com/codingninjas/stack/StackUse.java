package com.codingninjas.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackUse {

	public static void main(String[] args) throws Exception {
		

//		stackUsingArray();
//		stackUsingLL();
		System.out.println(balanceOutParenthesis("{()}"));
		reverseStackProblem();
		
//		bracketRedundantProblem2();
//		boolean s = canBeValid(")(","00");
//		System.out.println(s);
		
//		stackusingQueue();
		
	}
	
	private static void stackusingQueue() throws StackEmptyException {
		
		StackUsingQueue stack = new StackUsingQueue();
		stack.push(0);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		
		stack.print();
		
		System.out.println(stack.pop());
		stack.print();
		
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
		
	}

	private static void reverseStackProblem() {

		Stack<Integer> stack = new Stack<Integer>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);
		stack.add(5);
		System.out.println(stack);
		
		Stack<Integer> helper = new Stack<Integer>();
		Stack<Integer> result = reverseStackUsingHelperStack(stack, helper);
		System.out.println(result);
		System.out.println(result.pop());
		System.out.println(result);
		
	}
	
	private static void bracketRedundantProblem2() {
		boolean result = bracketRedundant();
		System.out.println(result);
		
	}
	

	public static void stackUsingArray() throws StackEmptyException {
		
		StackUsingArray stack = new StackUsingArray();
		stack.push(10);
		System.out.println(stack.top());
		stack.pop();
		stack.push(20);
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
		stack.print();
		stack.push(20);
		stack.push(20);
		stack.push(20);
		
		stack.print();
		System.out.println(stack.size());
		
	}
	
	public static void stackUsingLL() throws StackEmptyException {
		
		StackUsingLL<Integer> stack = new StackUsingLL<Integer>();
		stack.push(10);
		System.out.println(stack.top());
		stack.push(20);
		System.out.println(stack.top());
		stack.push(30);
		System.out.println(stack.top());
		stack.print();
		System.out.println(stack.pop());
		stack.print();
		System.out.println(stack.top());
		System.out.println(stack.top());
		
	}
	
	public static boolean canBeValid(String s, String locked) {
		
		int n = s.length();
		int countOne = 0;
		
		for (int i = 0; i < locked.length(); i++) {
			if ( locked.charAt(i) == '1' ) {
				countOne = countOne + 1;
			}
		}
		
		if ( n%2 != 0 ) return false;
		
		Pairr<Stack<Character>, Boolean> ps = balanceOutParenthesisPairr(s);
		
		
		if ( ps.s ) {
			return true;
		}
		
		System.out.println(ps.f.size());
		System.out.println(countOne);
		
		if (ps.f.size()/2 <= countOne) {
			return true;
		}

		return false;
        
    }
	
	public static Pairr<Stack<Character>, Boolean> balanceOutParenthesisPairr(String s ) {

//		String s = "{()}";
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '{' || s.charAt(i) == '}' || s.charAt(i) == '(' || s.charAt(i) == ')'
					|| s.charAt(i) == '[' || s.charAt(i) == ']') {

				if (!stack.isEmpty()) {

					if (stack.peek() == map.get(s.charAt(i))) {
						stack.pop();
						continue;
					} 
					
					else if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
						stack.push(s.charAt(i));
						continue;
					}
				}

				// first element only / non matching
				stack.push(s.charAt(i));
			}
		}
		
		System.out.println(stack);
		
		return new Pairr<>(stack, stack.isEmpty());
	}
	
	public static boolean balanceOutParenthesis(String s ) {

//		String s = "{()}";
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '{' || s.charAt(i) == '}' || s.charAt(i) == '(' || s.charAt(i) == ')'
					|| s.charAt(i) == '[' || s.charAt(i) == ']') {

				if (!stack.isEmpty()) {

					if (stack.peek() == map.get(s.charAt(i))) {
						stack.pop();
						continue;
					} 
					
					else if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
						stack.push(s.charAt(i));
						continue;
					}
				}

				// first element only / non matching
				stack.push(s.charAt(i));
			}
		}
		
		System.out.println(stack);
		
		return stack.isEmpty();
	}
	
	public static Stack<Integer> reverseStackUsingHelperStack(Stack<Integer> stack, Stack<Integer> helper) {
		
		if ( stack.size() == 1 || stack.size() == 0 ) {
			return stack;
		}
		
		int saveElement = stack.pop();
		Stack<Integer> smallStack = reverseStackUsingHelperStack(stack, helper);
		
		while ( !smallStack.isEmpty() ) {
			helper.add(smallStack.pop());
		}
		
		if ( smallStack.isEmpty() ) {
			smallStack.add(saveElement);
		}
		
		while ( !helper.isEmpty() ) {
			smallStack.add(helper.pop());
		}
		
		return smallStack;
	}
	
	public static boolean bracketRedundant() {
		
		// bracket with no data is redundant
		// example (a + b) is not 
		// ((a+b)) is redundant
//		String s = "(a+b)";
		String s = "((b*c)*(a/b))"; // No
//		(a*b+(c/d)) No
		
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

		Stack<Character> stack = new Stack<Character>();
		int count = 0;

		for (int i = 0; i < s.length(); i++) {

			if ( s.charAt(i) != '}'  && s.charAt(i) != ')'  && s.charAt(i) != ']' ) {
				stack.push(s.charAt(i));
			} 
			
			else {
				// ) } ]
				count = 0;
				
				while ( stack.peek() != map.get(s.charAt(i)) ) {
					count++;
					stack.pop();
				}
				
				if (stack.peek() == map.get(s.charAt(i))) {
					stack.pop();
				}
				
				stack.add('e');
//				System.out.println("count : "+ count);
				if ( count <= 1 ) {
					return true;
				}
			}
			
			System.out.println(stack);
			
		}
		
		return false;
	}
}
 