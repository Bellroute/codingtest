package programmers;

import java.util.HashMap;
import java.util.Map;

// 2024 KAKAO WINTER INTERNSHIP - 도넛과 막대 그래프
// https://school.programmers.co.kr/learn/courses/30/lessons/258711
public class Solution258711 {

    private Map<Integer, int[]> graph;

    public int[] solution(int[][] edges) {
        int[] answer = {0, 0, 0, 0};

        graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            countToGraph(from, 0);
            countToGraph(to, 1);
        }

        int[] counts;
        for(Integer key : graph.keySet()) {
            counts = graph.get(key);

            if (counts[0] >= 2 && counts[1] == 0) { // 나가는 간선은 2개 이상 있는데 들어오는 간선 0개 -> 생성된 정점
                answer[0] = key;
            } else if (counts[0] == 0 && counts[1] > 0) { // 들어오는 간선은 있는데 나가는 간선이 없는 경우 -> 막대 그래프
                answer[2]++;
            } else if (counts[0] >= 2 && counts[1] >= 2) { // 나가는 간선, 들어오는 간선이 2개 이상인 경우 -> 8자 그래프
                answer[3]++;
            }
        }

        // 생선된 정점에 연결된 노드 갯수(=총 그래프 갯수)에서 막대와 8자 그래프 갯수를 뺌
        answer[1] = graph.get(answer[0])[0] - answer[2] - answer[3];

        return answer;
    }

    private void countToGraph(int node, int code) { // code = 0 : 나가는 것, 1 : 들어오는 것
        int[] counter = graph.getOrDefault(node, new int[] {0, 0}); // 배열[0] : 해당 노드에서 나간 갯수, 배열[1] : 해당 노드에 들어온 갯수
        counter[code]++;
        graph.put(node, counter);
    }
}
