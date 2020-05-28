package com.gjee.algo.rough;

public class Knapsack01 {

	//here wt[],val[] are outside of this funtion
	int []wt;
	int [] val;
	//time complexity (O(2^n)
	//Method1 Approach 1
	public  int knapsackM1A1(int n,int capacity) {

		if(n==0 ||capacity<=0)
			return 0;

		if(wt[n-1]>capacity) { //current weight is more so, rely on n-1 item.. ie without this item)
			return knapsackM1A1(n-1,capacity);
		}
		//nth item included;

		int current_item_selected_val = val[n-1]+knapsackM1A1(n-1, capacity-wt[n-1]);
		int current_item_not_selected_val= knapsackM1A1(n-1,capacity);

		return Math.max(current_item_selected_val, current_item_not_selected_val);

	}

	//Method1 ..Approach 2
	//recursive solution with input passed as method parameter
	//time complexity(O(n^2)
	public  int knapsackWithM1A2(int n,int capacity,int[]wt, int[] val) {

		if(n==0 ||capacity<=0)
			return 0;

		if(wt[n-1]>capacity) { //current weight is more so, rely on n-1 item.. ie without this item)
			return knapsackWithM1A2(n-1,capacity,wt,val);
		}
		//nth item included;

		int current_item_selected_val = val[n-1]+knapsackWithM1A2(n-1, capacity-wt[n-1],wt,val);
		int current_item_not_selected_val= knapsackWithM1A2(n-1,capacity,wt,val);

		return Math.max(current_item_selected_val, current_item_not_selected_val);

	}

	//Method2 .. approach 2 .. Top down apprach(cache delcaration is global]
	//time complexity : O(nC)
	//Space complexity : O(nC)
	//int[][]cache = new int[wt.length+1][capacity+1];
	int[][]cache; //set before calling knapsackWithM2A1

	public int knapsackWithM2A1(int n,int capacity) {

		if(n==0 || capacity<=0) { //n==0 means O  item selected.
			return 0;
		}
		if(cache[n][capacity]!=0)
			return cache[n][capacity];

		if(wt[n-1]>capacity) { //current weight is more so, rely on n-1 item.. ie without this item)
			return cache[n][capacity] = knapsackWithM2A1(n-1,capacity);
		}

		int current_item_selected_val = val[n-1]+knapsackWithM2A1(n-1, capacity-wt[n-1]);
		int current_item_not_selected_val= knapsackWithM2A1(n-1,capacity);

		return cache[n][capacity] = Math.max(current_item_selected_val, current_item_not_selected_val);

	}

	//Method2 .. apprach 2..Top down approach(cache passed as Metod parameter)
	//time complexity : O(nC)
	//Space complexity : O(nC)
	public int knapsackWithM2A2(int n,int capacity,int[][] cache) {

		if(n==0 || capacity<=0) { //n==0 means O  item selected.
			return 0;
		}
		if(cache[n][capacity]!=0)
			return cache[n][capacity];

		if(wt[n-1]>capacity) { //current weight is more so, rely on n-1 item.. ie without this item)
			return cache[n][capacity] = knapsackWithM2A2(n-1,capacity,cache);
		}

		int current_item_selected_val = val[n-1]+knapsackWithM2A2(n-1, capacity-wt[n-1],cache);
		int current_item_not_selected_val= knapsackWithM2A2(n-1,capacity,cache);

		return cache[n][capacity] = Math.max(current_item_selected_val, current_item_not_selected_val);

	}



//Method3: Bottom up Approach:
	public int knapsackWithM3(int n,int capacity) {
		
		
		int [][] dp = new int[n+1][capacity+1];
		
		for(int i=0;i<=n;i++) {
			for(int w=0;w<capacity;w++) {
				if(i==0 || w==0){
					dp[i][w]=0;
				}
				else if(wt[i-1]>w) {
					dp[i][w]= dp[i-1][w];
				}
				else {
					dp[i][w]=Math.max(val[i-1]+dp[i-1][w-wt[i-1]],dp[i-1][w]);
				}
			}
		}
		System.out.println(dp);
		return dp[n][capacity];
	}

}

