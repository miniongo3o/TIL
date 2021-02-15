package algo_hw;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_3040_백설공주난쟁이 {
	static int [] arr;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		arr=new int[9];
		for(int i=0;i<9;i++) {
			arr[i]=sc.nextInt();
		}
		comb(0,new int[7],0);
	}
	
	private static void comb(int select,int[] selected,int startIdx) {
		if(select==7) {
			int sum=0;
			for(int i=0;i<7;i++) {
				sum+=selected[i];
			}
			if(sum==100){
				Arrays.sort(selected);
				for(int i=0;i<7;i++) {
					System.out.println(selected[i]);
				}
			}
			return;
		}
		
		
		for(int i=startIdx;i<9;i++) {
			selected[select]=arr[i];
			comb(select+1,selected,i+1);
		}
	}
		
}
