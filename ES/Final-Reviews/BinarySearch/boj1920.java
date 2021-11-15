package algorithm.boj.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] line = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        line = br.readLine().split(" ");
        for(int i=0;i<m;i++) {
            int x = Integer.parseInt(line[i]);
            int idx = Arrays.binarySearch(arr,x);
            if(idx<0) System.out.println(0);
            else System.out.println(1);
        }
    }
}
