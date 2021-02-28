
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int l,r;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int[] arr=new int[m];
		int answer=0;
		String[] temp=br.readLine().split(" ");
		for(int i=0;i<m;i++) {
			arr[i]=Integer.parseInt(temp[i]);
		}
		
		for(int i=1;i<m-1;i++) {
			l=0;
			r=0;
			
			for(int j=0;j<i;j++) {
				l=Math.max(l, arr[j]);
			}
			
			
			for(int j=i+1;j<m;j++) {
				r=Math.max(r, arr[j]);
			}
			
			if(arr[i]<l&&arr[i]<r) {
				answer+=Math.min(l, r)-arr[i];
				
			}
		}
		System.out.println(answer);
		
	}
}
