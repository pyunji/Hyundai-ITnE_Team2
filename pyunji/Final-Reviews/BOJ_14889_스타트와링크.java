package present.boj_14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] chk;
    static List<Integer> team1 = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void cal(int idx, int count) {
        if (count == N / 2) {
            int team1Power = 0;
            int team2Power = 0;
            for (int i = 0; i < team1.size(); i++) {
                for (int j = i + 1; j < team1.size(); j++) {
                    int player1 = team1.get(i);
                    int player2 = team1.get(j);

                    team1Power += arr[player1][player2] + arr[player2][player1];
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (!chk[i] && !chk[j]) {
                        team2Power += arr[i][j] + arr[j][i];
                    }
                }
            }

            answer = Math.min(answer, Math.abs(team1Power - team2Power));

            return;
        }
        for (int i = idx; i < N; i++) {
            chk[i] = true;
            team1.add(i);
            cal(i+1, count + 1);
            team1.remove(team1.size() - 1);
            chk[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        chk = new boolean[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cal(0, 0);

        System.out.println(answer);
    }
}