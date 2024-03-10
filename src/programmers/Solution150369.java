package programmers;

// 2023 KAKAO BLIND RECRUITMENT - 택배 배달과 수거하기
// https://school.programmers.co.kr/learn/courses/30/lessons/150369
public class Solution150369 {

    public static void main(String[] args) {
        System.out.println(solution(4, 5, new int[] {1, 0, 3, 1, 2}, new int[] {0, 3, 0, 4, 0}));
        System.out.println(solution(2, 7, new int[] {1, 0, 2, 0, 1, 0, 2}, new int[] {0, 2, 0, 1, 0, 2, 0}));
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliver = 0;
        int pickup = 0;

        for (int i = n - 1; i >= 0; i--) {
            // i번째 집에 배달/수거 박스가 없으면 방문하지 않아도 됨
            if (deliveries[i] == 0 && pickups[i] == 0) {
                continue;
            }

            // 같은 집을 몇번 왔다갔다해야하는지 횟수를 구함
            int count = 0;
            while (deliver < deliveries[i] || pickup < pickups[i]) {
                count++;
                deliver += cap;
                pickup += cap;
            }
            // 아래 계산 후 deliver, pickup에 남아있는 값은 같은 집을 몇번 오가는 중에 트럭에 남은 공간을 의미
            // 다음 집 횟수 구하는데 이용 됨
            deliver -= deliveries[i];
            pickup -= pickups[i];
            answer += (long) (i + 1) * count * 2;
        }

        return answer;
    }
}
