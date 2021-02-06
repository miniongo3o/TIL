
import java.util.Scanner;

//8
//0 1 0 1 0 0 0 1
//2
//1 3
//2 3

// 남학생은 1. 받은 숫자 배수들을 반전시킨다.
// 여학생은 2. 받은 숫자를 중심으로 좌우의 대칭에서 가장 많이 포함된것들을 반전. 없으면 본인숫자만 반전
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		int cnt = sc.nextInt();
		for (int i = 0; i < cnt; i++) {
			int gender = sc.nextInt();
			int pos = sc.nextInt();
			// 남자
			if (gender == 1) {
				for (int j = pos; j <= n; j += pos) {
					arr[j] = (arr[j] == 0) ? 1 : 0;
				}

			} else {
				// 여자
				// 시작이거나 끝, 혹은 양옆이 다르면 본인만 바꾼다.
				if ( (pos == 1 || pos == n) || arr[pos - 1] != arr[pos + 1]) {
					arr[pos] = (arr[pos] == 0) ? 1 : 0;
				} else {
					int left = pos - 1;
					int right = pos + 1;
					arr[pos] = (arr[pos] == 0) ? 1 : 0;
					while (left > 0 && right <= n) {
						if (arr[left] == arr[right]) {
							arr[left] = (arr[left] == 0) ? 1 : 0;
							arr[right]=(arr[right] == 0) ? 1 : 0;
							--left;
							++right;
						}
						else {
							break;
						}
					}
				}

			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i]+" ");
			if(i%20==0) {
				System.out.println();
			}
				}
	}
}
