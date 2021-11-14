import java.util.*;

class Solution {
    static int n ;
    static ArrayList<String> list = new ArrayList<>();        
    static boolean[] isused;
    
    static void func(int num, String pre, String answer, String[][] ticket) {
        if(num==n){
            list.add(answer);
            return;
        }
        for(int i=0;i<n;i++) {
            if(isused[i]) continue;
            if(!ticket[i][0].equals(pre)) continue;
            isused[i] = true;
            func(num+1, ticket[i][1],answer+" "+ticket[i][1], ticket);
            isused[i] = false;
        }
        return;
    }
    
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        isused = new boolean[tickets.length];
        
        func(0,"ICN","ICN",tickets);
        
        Collections.sort(list);
        
        String[] answer = list.get(0).split(" ");
        
        return answer;
    }
    
}