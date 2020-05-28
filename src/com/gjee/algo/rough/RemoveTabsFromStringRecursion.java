package com.gjee.algo.rough;

public class RemoveTabsFromStringRecursion {

	public String remove(String sent,int i) {
		if(i==0) {
			if(sent.charAt(i)!=' ' && sent.charAt(i) == '\t') {
				return sent.charAt(i)+"";
			}
			else
				return "";
		}
		String result ="";
		if(sent.charAt(i)!=' ' && sent.charAt(i) == '\t') {
			return sent.charAt(i)+remove(sent,i+1);
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
