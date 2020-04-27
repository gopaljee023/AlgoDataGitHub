

public class LCSwithRecursion {

	public static void main(String[] args) {
	  
		System.out.println(longestCommonSubsequence("abcde","ace"));
	    System.out.println(longestCommonSubsequence("pmjghexybyrgzczy","hafcdqbgncrcbihkd"));
        
	}


	public static int longestCommonSubsequence(String text1, String text2) {
		return LCS(0,0,text1,text2) ;
	}

	public static int LCS(int i,int j, String text1, String text2){
		if(text1.length()==i || text2.length() == j)
			return 0;
		else if(text1.charAt(i) == text2.charAt(j)){
			return 1+ LCS(i+1,j+1,text1,text2);
		}
		else{
			return max(LCS(i+1,j,text1,text2) , LCS(i,j+1,text1,text2));
		}
	}

	static int max(int a, int b){ return a>b?a:b;

	}
}


/*
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.

input:		
"pmjghexybyrgzczy"
"hafcdqbgncrcbihkd"

output: timelimit
 */