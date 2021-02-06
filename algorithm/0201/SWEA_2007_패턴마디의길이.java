package SWEA;

import java.util.Scanner;

public class SWEA_2007 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			String str=sc.next();
			
			for(int j=1;j<str.length();j++) {
				String temp=str.substring(0, j);
				if(temp.equals(str.substring(j,j+temp.length()))) {
					System.out.println("#"+i+" "+temp.length());
					break;
				}
			}
		}
		
	}
}
