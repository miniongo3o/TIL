public class SWEA_1859 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			long max = 0;
			long sum = 0;
			
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}

			

			for (int j = n - 1; j >= 0; j--) {
				if (arr[j] > max) {
					// max보다 큰 값 등장 : 손해
					max = arr[j];
				} else {
					// max 유지
					sum += max - arr[j];
				}
			}
			System.out.println("#" + (i) + " " + sum);
		}

			
	}
}
