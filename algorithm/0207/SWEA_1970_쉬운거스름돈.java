package SWEA;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1970 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		int[] arr= {50000,10000,5000,1000,500,100,50,10};
		
		
		
		for(int i=0;i<N;i++) {
			int price=sc.nextInt();
			int[] result=new int[8];
			
			for(int j=0;j<8;j++) {
				result[j]=price/arr[j];
				price=price%arr[j];
			}
			System.out.println("#"+(i+1));
			for(int x:result) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
