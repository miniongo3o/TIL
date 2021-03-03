package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9839_최고의쌍 {
	static int arr[];
	static int idx, n, max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int t = 1; t <= N; t++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[n];
			idx = 0;
			while (st.hasMoreTokens()) {
				arr[idx++] = Integer.parseInt(st.nextToken());
			}
			max=-1;
			comb(0, 0, 1);
			sb.append("#"+t+" "+max+"\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

	private static void comb(int toSelect, int start, int mox) {
		if (toSelect == 2) {
//			int num = selected[0] * selected[1];
			// 한자리수는 그자체로 return.
			if (mox < 10) {
				max = Math.max(max, mox);
				return;
			}

			// 한자리수가 아니면, 각자리수가 연속되는 수인지 확인
			String str = Integer.toString(mox);

			for (int i = 0; i < str.length() - 1; i++) {
				if (str.charAt(i) + 1 != str.charAt(i + 1)) {
					return;
				}
			}
			max = Math.max(max, mox);
			return;

		}

		for (int i = start; i < n; i++) {
			if(mox*arr[i]<max)continue;
			comb(toSelect+1,i+1,mox*arr[i]);
		}
	}
}
