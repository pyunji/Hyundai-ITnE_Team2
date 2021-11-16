package present.boj_4803;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] chk;
    static boolean flag;
    
    static void dfs(int beforeNode, int curNode) {
        for (int child : graph[curNode]) {
            if (chk[child]) {
                if (child != beforeNode) {
                    flag = false;
                }
            } else {
                chk[child] = true;
                dfs(curNode, child);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = 0;
        while (true) {
            caseNum++;
            String firstLine = br.readLine();
            if (firstLine.equals("0 0")) break;

            StringTokenizer st = new StringTokenizer(firstLine);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            graph = new ArrayList[n + 1];
            chk = new boolean[n + 1];
            for (int i = 0; i < n + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            int treeCnt = 0;
            for (int i = 1; i <= n; i++) {
                if (!chk[i]) {
                    chk[i] = true;
                    flag = true;
                    dfs(0, i);
                    if (flag) treeCnt++;
                }
            }

            System.out.print("Case " + caseNum + ": ");
            if(treeCnt == 0) {
                System.out.println("No trees.");
            } else if (treeCnt == 1) {
                System.out.println("There is one tree.");
            } else {
                System.out.println("A forest of " + treeCnt + " trees.");
            }
        }
    }
}
