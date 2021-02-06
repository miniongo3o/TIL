package SWEA;

import java.util.Scanner;

public class SWEA_1926 {
	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			
			if(i<10) {
				if(i%3==0) {
					System.out.print("-"+" ");
				}else {
					System.out.print(i+" ");
				}
				
			}else if(i<100) {
				String str="";
				if( (i/10)%3==0 ) {
					str+="-";
				}
				
				if( (i%10)!=0 && (i%10)%3==0  ) {
					str+="-";
				}
				
				if(str.length()!=0) {
					System.out.print(str+" ");
				}else {
					System.out.print(i+" ");
				}
				
				
			}else {
				int a,b,c;
				int cnt=0;
				a=i/100;
				b=(i/10)%10;
				c=i%10;
				if(c%3==0&&(i%10)!=0)cnt++;
				if(b%3==0&&(i/10)%10!=0)cnt++;
				if(a%3==0)cnt++;
				
				if(cnt==0) {
					System.out.print(i+" ");
				}else {
					String str="";
					for(int k=0;k<cnt;k++) {
						str+="-";
					}
					System.out.print(str+" ");
				}
				
				
				
			}
			
			
		}
		
	}
}
