import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean[] verticalChk;
    static boolean[][] chk;
    static int answer;
    public static boolean diagonalChk(int row, int col) {
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chk[i][j]) return false;
        }

        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (chk[i][j]) return false;
        }

        return true;
    }
    public static void dfs(int row) {
        if (row == N) {
            answer++;
            return;
        }
        for (int col = 0; col < N; col++) {
            if (!verticalChk[col] && diagonalChk(row, col)) {
                verticalChk[col] = true;
                chk[row][col] = true;
                dfs(row + 1);
                chk[row][col] = false;
                verticalChk[col] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        verticalChk = new boolean[N];
        chk = new boolean[N][N];
        // 첫 행에 아무데나 놓는다.
        for (int col = 0; col < N; col++) {
            // 현재 행 값을 파라미터로 전달해줘야한다
            // 놓은 열에는 더이상 말을 놓을 수 없다고 체크해준다.
            verticalChk[col] = true;
            // 좌표에 현재 위치를 체크해준다
            chk[0][col] = true;
            dfs(1);
            chk[0][col] = false;
            verticalChk[col] = false; // 경우의 수를 찾아야 하니까 원복 해준다.
        }
        System.out.println(answer);
    }
}