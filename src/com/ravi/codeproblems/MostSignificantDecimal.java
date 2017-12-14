package com.ravi.codeproblems;

/*The decimal zip of two non negative integer A and B is an integer C
 * As follows 
 * 
 * If A = 1234, B = 567 C=1526374
 * If A = 567, B = 1234 C= 5162734
 * ie First Decimal of C = First Digit of A
 * 	  Second Decimal of C = First Digit of B and so on... 
 */
public class MostSignificantDecimal {
	
	static int getMostSignificantDecimal(int A, int B){
		String A_str = new Integer(A).toString();
		String B_str = new Integer(B).toString();
		String C_str = "";
		int A_str_len = A_str.length();
		int B_str_len = B_str.length();
		char a_or_b; 
		int higher_len = 0;
		int lower_len = 0;
		
		if (A_str_len >= B_str_len) {
			higher_len = A_str_len;
			lower_len = B_str_len;
			a_or_b = 'A';
		}
		else{
			higher_len = B_str_len;
			lower_len = A_str_len;
			a_or_b = 'B';
		}
		 
		for (int i=0; i <lower_len; i++){
			C_str =C_str + A_str.charAt(i);
			C_str =C_str + B_str.charAt(i);
		}
		//Not really required as we start from lower_len to the end of the string
		int sub_str_len = higher_len - lower_len  ;
		if (a_or_b == 'A')
			C_str = C_str +A_str.substring(lower_len);
		else
			C_str = C_str +B_str.substring(lower_len);
		
		
		return Integer.parseInt(C_str);
	}

	
	public static void main(String[] args) {
		int one = 1234;
		int two = 456;
		System.out.println(new String(Integer.toString(one).substring(1,1)));
		
		System.out.println(MostSignificantDecimal.getMostSignificantDecimal(one, two));
	}
}
