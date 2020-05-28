package com.gjee.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet_10_TownJudge {

	int total ;
	public int findJudge(int N, int[][] trust) {

		total = N;
		int[] judges = new int[N+1];
		Arrays.fill(judges, 1); //assume all are judges

		//Everybody (except for the town judge) trusts the town judge.
		for(int[] row:trust) {
			judges[row[0]]=0;
		}

		return isEveyoneTrusting(judges,trust);

	}

	private int isEveyoneTrusting(int[] judges,int[][] trust) {

		List<Integer> pjudges = new ArrayList<>();
		for(int i=1;i<judges.length;i++) {
			if(judges[i]==1) {
				pjudges.add(i);
			}
		}

		int count =0;
		Map<Integer,Integer> map = new HashMap<>();
		for(Integer j:pjudges) {
			for(int[] row:trust) {
				int _2nd = row[1];
				if(_2nd == j) {
					map.put(row[0],_2nd);
				}
			}
			if(map.size()==total-1) {
				return j;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*
 * 
 *  Find the Town Judge
Solution
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.



Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3


Constraints:

1 <= N <= 1000
0 <= trust.length <= 10^4
trust[i].length == 2
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N
 */
