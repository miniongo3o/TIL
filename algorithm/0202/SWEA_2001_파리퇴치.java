
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int test_case=sc.nextInt();
		
		for(int T=0;T<test_case;T++) {
			
			
			int n=sc.nextInt();
			int m=sc.nextInt();
			int[][] arr=new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
			int max=-1;
			for(int i=0;i<=n-m;i++) {
				for(int j=0;j<=n-m;j++) {
					int sum=0;
					for(int k=0;k<m;k++) {
						for(int l=0;l<m;l++) {
							sum+=arr[i+k][j+l];
						}
					}
					if(sum>max)max=sum;
				}
			}
			
			System.out.println("#"+(T+1)+" "+max);
		}
	}
}