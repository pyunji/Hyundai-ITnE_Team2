import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> adj = null;
    static int[] dist = new int[20002];
    static final int INF = 987654321;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();  
    
    static public class Pair implements Comparable<Pair>{
        int cost;
        int idx;
        public Pair(int cost,int idx) {
            this.cost = cost;
            this.idx = idx;
        }
        @Override
        public int compareTo(Pair p) {
            if(this.cost<p.cost) return -1;
            else return 1;
        }
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        adj = new ArrayList<>();
    
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<Integer>());
        
        //양방향 인접 표시
        for(int i=0;i<edge.length;i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    
        Arrays.fill(dist,INF);
        
        dist[1] = 0;
        pq.add(new Pair(0,1));
        
        while(!pq.isEmpty()) {
            Pair cur = pq.poll();
            int c_cost = cur.cost;
            int c_idx = cur.idx;
            
            if(c_cost>dist[c_idx]) continue;
            
            for(int nxt : adj.get(c_idx)) {
                int ncost = c_cost+1;
                if(dist[nxt]>ncost){
                    dist[nxt] = ncost;
                    pq.add(new Pair(ncost, nxt));
                }
            }
        }
        int max_num = 0;
        for(int i=2;i<=n;i++) {
            if(dist[i]==INF) continue;
            max_num = Math.max(max_num, dist[i]);
        }
        
        for(int i=2;i<=n;i++) {
            if(dist[i]==max_num) answer++;
        }
        
        
        return answer;
    }
}