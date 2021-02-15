package ssafy_algo_0215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_6808_규영이카드게임 {
    static int winCase = 0;
    static int loseCase = 0;
    static int[] arr1; //규영이 카드
    static int[] arr2; //인영이 카드
    static boolean[] visited;
    static int depth=9;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TestCase = Integer.parseInt(br.readLine());
 
 
        for(int tc = 1; tc <= TestCase; tc++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            arr1 = new int[9];
            arr2 = new int[9];
            visited = new boolean[19];
 
            for(int i = 0; i < 9; i++) {
                arr1[i] = Integer.parseInt(stk.nextToken());
                visited[arr1[i]] = true;
            }
 
            for(int i = 1, idx = 0; i <= 18; i++) {
                if(!visited[i]) {
                    arr2[idx] = i;
                    idx++;
                }
            }
 
            Logic(0, 0, 0);
            System.out.println("#"+tc+" "+winCase+" "+loseCase+"\n"); 
            
            winCase = 0;
            loseCase = 0;
        }
 
        br.close();
    }
    //sumA => 규영이 점수 합
    //sumB => 인영이 점수 합
    private static void Logic(int cnt, int sumA, int sumB) {
        if(depth == cnt) {
            if(sumA > sumB) winCase++;
            else if(sumA < sumB) loseCase++;
            return;
        }
 
        for(int j = 0; j < 9; j++) {
            int numB = arr2[j];
            if(!visited[numB]) {
                visited[numB] = true;
                if(arr1[cnt] > numB) {
                    Logic(cnt + 1,  sumA + arr1[cnt] + numB, sumB);
                } else {
                    Logic(cnt + 1,  sumA, sumB + arr1[cnt] + numB);
                }
                visited[numB] = false;
            }
        }
 
        return;
    }
}

// 1~ 18장의 카드.
// 9장씩 나눈다.
// 9라운드 게임
// 한장씩 카드 비교
// 높은수 사람 = 두 사람 카드의 합 점수 +
// 낮은사람 = 0점
//총점이 같으면 무승부
// 규영이 9장의 카드 숫자가 주어진다.
// 규영이 카드 순서가 고정된다면, 규영이가 이기는 경우와 지는경우는 총 몇가지인가
