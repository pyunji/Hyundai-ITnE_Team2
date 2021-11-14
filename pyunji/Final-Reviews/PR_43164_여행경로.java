/*
 * using DFS
 * 10m 소요
 */
// 1. 시작 노드가 정해져있는 경우의 문제이다.
// 2. 경우의 수가 여러개
import java.util.*;
class Solution {
    boolean[] chk;
    int N;
    List<String> paths = new ArrayList<>();
    // count, 경로 저장, 출발지, 도착지
    public void dfs(String start, int count, String path, String[][] tickets) {
        if(count == N) {
            paths.add(path);
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(!chk[i] && tickets[i][0].equals(start)) {
                chk[i] = true;
                dfs(tickets[i][1], count + 1, path + " " + tickets[i][1], tickets);
                chk[i] = false;
            }
        }
    }
    
    public String[] solution(String[][] tickets) {
        N = tickets.length;
        chk = new boolean[N];
        dfs("ICN", 0, "ICN", tickets);
        Collections.sort(paths);
        
        return paths.get(0).split(" ");
    }
}