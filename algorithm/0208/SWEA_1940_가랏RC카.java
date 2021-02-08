package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1940_가랏RC카 {
    static int  how;
    static int  speed;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int N = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= N; t++) {
 
            int order = Integer.parseInt(br.readLine());
            int sum = 0;
            int nowSpeed = 0;
            for (int i = 0; i < order; i++) {
                String[] str = br.readLine().split(" ");
                if (str.length != 1) {
                     how = Integer.parseInt(str[0]);
                     speed = Integer.parseInt(str[1]);
                }else {
                    how=0;
                }
                if (how == 0) {
                    sum += nowSpeed;
                } else if (how == 1) {
                    nowSpeed += speed;
                    sum += nowSpeed;
                } else {
                    if (nowSpeed < speed) {
                        nowSpeed = 0;
                    } else {
                        nowSpeed -= speed;
                        sum += nowSpeed;
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}