package com.gjee.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet_27_BipartiteGraph {

	//video: https://youtu.be/0ACfAqs8mm0
		boolean isBipatrite(List<Integer>[] adj, int N, int node, int[] color){

			Deque<Integer> q = new ArrayDeque<>();
			q.push(node);
			color[node]=1;

			while(!q.isEmpty()){
				int curr = q.getFirst();
				q.remove();

				for(int ele:adj[curr]){
					if(color[ele]==color[curr]) //odd cycle
						return false;
					if(color[ele]==-1){
						color[ele] = 1- color[curr];
						q.push(ele);
					}
				}
			}
			return true;
		}
		public boolean possibleBipartition(int N, int[][] dislikes) {
			ArrayList<Integer>[] adj = new ArrayList[N+1];

			// initializing 
			for (int i = 0; i < N+1; i++) { 
				adj[i] = new ArrayList<Integer>(); 
			} 
			for(int i=0;i<dislikes.length;++i){
				adj[dislikes[i][0]].add(dislikes[i][1]);
				adj[dislikes[i][1]].add(dislikes[i][0]);//??
			}

			int []color = new int[N+1];
			Arrays.fill(color,-1);
			for(int i=1;i<=N;++i){
				if(color[i]==-1){
					if(!isBipatrite(adj,N,i,color)){
						return false;
					}
				}
			}

			return true;
		}
	

    public static void main(String[] args) {
	
    	Leet_27_BipartiteGraph  o = new Leet_27_BipartiteGraph();

		int[][] arr0 =

			{{4,7},{4,8},{5,6},{1,6},{3,7},{2,5},{5,8},{1,2},{4,9},{6,10},{8,10},{3,6},{2,10},{9,10},{3,9},{2,3},{1,9},{4,6},{5,7},{3,8},{1,8},{1,7},{2,4}};
		System.out.println("expecting: true->"+o.possibleBipartition(10, arr0));
		int[][] arr = {{1,2},{1,3},{2,3}};

		System.out.println("expecting: false->"+o.possibleBipartition(3, arr));

		int[][] arr2 = {{1,2},{2,3},{3,4},{4,5},{1,5}};
		System.out.println("expecting: false->"+o.possibleBipartition(5, arr2));

		int[][] arr3 = {{1,2},{1,3},{2,4}};
		System.out.println("expecting: true->"+o.possibleBipartition(4, arr3));

	}

}

/*
 * Possible bipartision:
 * 
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.



Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false


Note:

1 <= N <= 2000
0 <= dislikes.length <= 10000
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].
 */

