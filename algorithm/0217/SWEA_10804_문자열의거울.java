package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class SWEA_10804_문자열의거울 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=n;t++) {
			StringBuilder sb=new StringBuilder();
			
			char[] arr=br.readLine().toCharArray();
			sb.append("#"+t+" ");
			for(int i=arr.length-1;i>=0;i--) {
				switch(arr[i]) {
				case 'b':
					sb.append("d");
					break;
					
				case 'd':
					sb.append("b");
					break;
					
				case 'p':
					sb.append("q");
					break;
					
				case 'q':
					sb.append("p");
					break;
				}
				
			}
			System.out.println(sb);
					
		}
	}
}


	