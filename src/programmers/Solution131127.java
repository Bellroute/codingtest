package programmers;

import java.util.HashMap;
import java.util.Map;

public class Solution131127 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> discountItemsFor10Days = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            discountItemsFor10Days.put(discount[i], discountItemsFor10Days.getOrDefault(discount[i], 0) + 1);
        }

        int start = 0;
        while (start <= discount.length - 10) {
            boolean isAble = true;
            for (int i = 0; i < want.length; i++) {
                if (discountItemsFor10Days.getOrDefault(want[i], 0) != number[i]) {
                    isAble = false;
                    break;
                }
            }

            if (isAble) {
                answer++;
            }

            if (start == discount.length - 10) {
                break;
            }

            if (discountItemsFor10Days.containsKey(discount[start])) {
                discountItemsFor10Days.put(discount[start], discountItemsFor10Days.get(discount[start]) - 1);
            }
            discountItemsFor10Days.put(discount[start + 10], discountItemsFor10Days.getOrDefault(discount[start + 10], 0) + 1);
            start++;
        }

        return answer;
    }
}
