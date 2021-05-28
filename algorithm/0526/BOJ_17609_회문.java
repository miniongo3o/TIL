package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_17609_회문 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			int answer=1;
			String str=br.readLine();
		}
	}
	public static int check(String str) {
		
		// 그냥 체크 -> 회문이면 0 
		// 체크 했을 때 하나 뺴고 돌렸을때 회문이면 1
		// 다 안되면 2 
		
		
		if(doPelin(str)==true) {
			return 0;
		}else if(doPsudoPelin(str)==true) {
			return 1;
		}else {
			return 2;
		}
		
	}
	private static boolean doPsudoPelin(String str) {
		int start=0;
		int end=str.length()-1;
		
		while(start<=end) {
			if(str.charAt(start)==str.charAt(end)) {
				start++;
				end--;
			}else {
				return doPelin(str.substring(start+1,end+1))||doPelin(str.substring(start,end));
			}
		}
		
		
		return false;
	}
	private static boolean doPelin(String str) {
		
		int start=0;
		int end=str.length()-1;
		
		while(start<=end) {
			if(str.charAt(start)==str.charAt(end)) {
				start++;
				end--;
			}else {
				return false;
			}
		}
		return true;
		
	}
}
