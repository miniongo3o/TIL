import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		for (int T = 1; T <= num; T++) {
			char[] str = br.readLine().toCharArray();
			int len = str.length;
			int center = len / 2;
			int answer=1;
			if (len % 2 == 0) {
				// 짝수인경우
				int center2 = center - 1;
				for (int i = 0; i <= center2; i++) {
					if (str[center2-i] != str[center+i]) {
						answer=0;
						break;
					}
				}
				

			} else {
				// 홀수인경우
				for (int i = 1; i <= center; i++) {
					if (str[center - i] != str[center + i]) {
						answer=0;
						break;
					}
				}
			}
			System.out.println("#"+T+" "+answer);

		}
	}
}
