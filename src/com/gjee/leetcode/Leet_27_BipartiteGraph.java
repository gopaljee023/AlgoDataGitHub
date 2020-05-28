package com.gjee.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet_27_BipartiteGraph {

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
		// TODO Auto-generated method stub

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
