
import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2005 {
	public static void main(String[] args) {
		
			
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			
			for(int T=1;T<=n;T++) {
				int cnt=sc.nextInt();
				long[][] arr=new long[cnt][cnt];
				
				for(int i=0;i<cnt;i++) {
					for(int j=0;j<=i;j++) {
						if(i==j||j==0||j==i) {
							//1인경우들 : 벽에닿아있는경우
							arr[i][j]=1;
						}else {
							arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
						}
						
					}
				}

	            System.out.println("#"+T);
				for(int m=0;m<cnt;m++) {
					for(int l=0;l<cnt;l++) {
						if(arr[m][l]!=0) {
							System.out.print(arr[m][l]+" ");
						}
						
					}
					System.out.println();
				}
			
			}				
		}
	}