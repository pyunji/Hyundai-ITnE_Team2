import java.util.*;
class Solution {
    // 나한테 진 애들 담기
    // losers = [[], [2], [5], [2], [3, 2], []]
    List<Integer>[] losers;
    
    // 나를 이긴 애들
    // winners = [[], [], [4, 3, 1], [4], [], [2]]
    List<Integer>[] winners;
    int[] chk;
    Queue<Integer> q = new LinkedList<>();
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        losers = new ArrayList[n+1];
        winners = new ArrayList[n+1];
        chk = new int[n+1];

        for(int i = 0; i < n + 1; i++) {
            losers[i] = new ArrayList<>();
            winners[i] = new ArrayList<>();
        }
        
        for(int[] result : results) {
            losers[result[0]].add(result[1]);
            winners[result[1]].add(result[0]);
        }
        
        for(int i = 1; i <= n; i++) {
            int count = 0;
            
            q.add(i);
            // 나(i)보다 순위 높은애들 탐색
            while(!q.isEmpty()) {
                int node = q.poll();
                for(int winner : winners[node]) {
                    if(chk[winner] != i) {
                        q.add(winner);
                        chk[winner] = i; // 내가(i) 탐색했다고 표시
                        count++;
                    }
                }
            }
            
            q.add(i);
            // 나(i)보다 순위 낮은애들 탐색
            while(!q.isEmpty()) {
                int node = q.poll();
                for(int loser : losers[node]) {
                    if(chk[loser] != i) {
                        q.add(loser);
                        chk[loser] = i; // 내가(i) 탐색했다고 표시
                        count++;                            
                    }
                }
            }
            if(count == n-1) answer++;
        }
        return answer;
    }
}