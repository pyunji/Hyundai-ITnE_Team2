package algorithm.boj.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1654 {
    static int[] lanWire;
    static int k,n;
    static public boolean check(long x) {
        long cnt = 0;
        for (int i = 0; i < k; i++) {
            cnt += lanWire[i] / x;
        }
        if (cnt >= n) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        k = Integer.parseInt(line[0]);
        n = Integer.parseInt(line[1]);
        lanWire = new int[k];
        for(int i=0;i<k;i++) {
            lanWire[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lanWire);

        long st = 1;
        long en = 0x7fffffff;   //2^31-1
        while(st<en) {
            long mid = (st+en+1)/2;
            if(check(mid)) st = mid;
            else en = mid-1;
        }
        System.out.println(st);
    }
}
