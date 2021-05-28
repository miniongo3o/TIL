package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		permu(1,new int[n+1],new boolean[n+1]);
	}

	static int n;

	public static void permu(int select, int selected[], boolean[] visit) {
		if (n+1 == select) {
			for(int i=1;i<=n;i++) {
				System.out.print(selected[i]+" ");
			}
			System.out.println();

			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				selected[select] = i;
				permu(select + 1, selected, visit);
				visit[i] = false;
			}
		}

	}
}
