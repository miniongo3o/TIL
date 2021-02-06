package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2007 {
	public static void main(String[] args) throws  NumberFormatException,IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		for(int i=1;i<=n;i++) {
			String str=br.readLine();
			
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
