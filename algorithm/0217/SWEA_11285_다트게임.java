package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class SWEA_11285_다트게임 {
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            int result = 0;
             
            for(int i = 0; i < N; i++){
                String[] text = br.readLine().split(" ");
                int x = Integer.parseInt(text[0]);
                int y = Integer.parseInt(text[1]);
                 
                for(int j = 2; j <= 11; j++) {
                    double r = Math.sqrt(x * x + y * y);
                    if(r > 200d) break;
                    if(r == 0) {
                        result += 10;
                        break;
                    }
                    if(r > (double)(20 * (11 - j))) {
                        result += j - 1;
                        break;
                    }
                     
                }
            }
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}