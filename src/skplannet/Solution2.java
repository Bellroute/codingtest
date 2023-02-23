package skplannet;

import java.util.Arrays;

public class Solution2 {

    private int[] parent;

    public int[] solution(int[] p, int[] b) {
        int[] answer = new int[b.length];

        parent = new int[p.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < p.length; i++) {
            if (p[i] == -1) {
                continue;
            }
            union(p[i], i);
        }

        for (int i = 0; i < b.length; i++) {
            int target = b[i];
            if (p[target] != -1) {
                continue;
            }

            answer[i] = (int) Arrays.stream(parent).filter(x -> x == target).count();
        }

        return answer;
    }

    public int find(int a) {
        if (parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
    }
}
