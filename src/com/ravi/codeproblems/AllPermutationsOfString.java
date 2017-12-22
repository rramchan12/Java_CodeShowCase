package com.ravi.codeproblems;

public class AllPermutationsOfString {
	public static void main(String[] args) {
		String str = "ABC";
		int n = str.length();
		AllPermutationsOfString permutation = new AllPermutationsOfString();
		permutation.permute(str, 0, n - 1);
		
	
	}
	
	
	public static void permute(String inputString, int l, int r){
		if (l==r)
			System.out.println(inputString);
		else{
			for (int i=l; i<=r; i++){
				String permuteString = swap(inputString, l, i);
				permute(permuteString, l+1, r);
				permuteString = swap(inputString, l, i);
				
			}
		}
	}
	

	public static String swap(String inputString, int i, int j){
	    char[] inputStringArr = inputString.toCharArray();
	    char temp = inputStringArr[j];
	    inputStringArr[j] = inputStringArr[i];
	    inputStringArr[i] = temp;
	    		
		return new String(inputStringArr);
	}

}
