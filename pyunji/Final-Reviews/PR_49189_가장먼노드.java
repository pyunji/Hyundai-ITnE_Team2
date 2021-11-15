import java.util.*;

class Solution {
    Queue<Integer> q = new LinkedList<>();
    int[] chk;
    List<Integer>[] arr;
    public int solution(int n, int[][] edge) {
        arr = new ArrayList[n+1];
        chk = new int[n+1];
        for(int i = 0; i < n+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            arr[a].add(b);
            arr[b].add(a);
        }
        
        chk[1] = 1;
        q.add(1);
        
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 0; i < arr[node].size(); i++) {
                int neighbor = arr[node].get(i);
                if(chk[neighbor] == 0) {
                    chk[neighbor] = chk[node] + 1;
                    q.add(neighbor);
                }
            }
        }

        Arrays.sort(chk);
        int maxValue = chk[chk.length - 1];
        int answer = 0;
        for(int i = 0; i < chk.length; i++) {
            if(chk[i] == maxValue) answer++;
        }
        return answer;
    }
}