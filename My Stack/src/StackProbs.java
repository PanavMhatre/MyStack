import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StackProbs {
	public static Stack<Integer> makeStack(int[] nums){
		Stack<Integer> stack = new Stack<>();
		for(int num:nums) {
			stack.push(num);
		}
		return stack;
	}
	
	public static Stack<Integer> doubleUp(Stack<Integer> nums){

		Stack<Integer> stack = new Stack<>();
		Stack<Integer> newStack = new Stack<>();
		while(!nums.isEmpty()) {
			stack.add(nums.pop());
		}
		while(!stack.isEmpty()) {
			int removedElement = stack.pop();
			newStack.push(removedElement);
			newStack.push(removedElement);
		}
		return newStack;
	}
	
	public static Stack<Integer> posAndNeg(Stack <Integer> nums){

		Stack<Integer> negStack = new Stack<>();
		Stack<Integer> returnStack = new Stack<>();
		Stack<Integer> posStack = new Stack<>();
		while(!nums.isEmpty()) {
			posStack.push(nums.peek());
			negStack.push(nums.peek());
			nums.pop();
		}
		while(!negStack.isEmpty()) {
			if(negStack.peek()<0)
				returnStack.push(negStack.peek());
			negStack.pop();
			
		}
		while(!posStack.isEmpty()) {
			if(posStack.peek()>=0)
				returnStack.push(posStack.peek());
			posStack.pop();
			
		}
		return returnStack;
	}

	public static Stack<Integer> shiftByN(Stack <Integer> nums, int n){
		Stack<Integer> returnStack = new Stack<>();
		Stack<Integer> storedStack = new Stack<>();
		Stack<Integer> theReversedStack = new Stack<>();
		
		while(!nums.isEmpty()) {
			theReversedStack.push(nums.peek());
			nums.pop();
		}
		for(int i = 0;i<n;i++) {
			storedStack.push(theReversedStack.pop());
		}
		System.out.println(storedStack.toString());
		while(!theReversedStack.isEmpty()) {
			returnStack.push(theReversedStack.pop());
		}
		for(Integer num:storedStack) {
			returnStack.push(num);
		}
		return returnStack;
	}
	public static String reverseVowels(String str){

		char[] arrayLoop = str.toCharArray();
		ArrayList<Character> list_name = new ArrayList<>(Arrays.asList('a','e','i','o','u'));		
		String returnString = "";
		Stack<Character> vowels = new Stack<>();
		for(char c: arrayLoop) {
			if( list_name.contains(c)) {
				vowels.push(c);
			}
		}
		for(char c: arrayLoop) {
			if(list_name.contains(c)) {
				returnString += vowels.pop();
			}else {
				returnString += c;
			}
		}
		return returnString;
	}
	
	public static boolean bracketBalance(String s) {
		Stack<String> stack = new Stack<String>();
		if(s.length()%2==0) {
			for(int i=0;i<s.length()/2;i++) {
				stack.push(s.substring(i,i+1));
			}
			System.out.println(stack);
			for(int i = s.length()/2 + 1;i<s.length();i++) {
				if(stack.pop()!=s.substring(i,i+1))
					return false;
			}
			return true;
		}
		return false;
	}
}
