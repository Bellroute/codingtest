package programmers;

import java.util.Stack;

public class Solution77886 {

    public static String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            answer[i] = replace(s[i]);
            System.out.println(answer[i]);
        }

        return answer;
    }

    private static String replace(String x) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < x.length(); i++) {
            if (stack.size() < 2) {
                stack.push(x.charAt(i));
                continue;
            }

            if (x.charAt(i) == '0') {
                char second = stack.pop();
                char first = stack.pop();

                if (first == '1' && second == '1') {
                    count++;
                    continue;
                }

                stack.push(first);
                stack.push(second);
            }

            stack.push(x.charAt(i));
        }

        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        str.reverse();

        int lastIndex = str.lastIndexOf("0");
        for (int i = 0; i < count; i++) {
            str.insert(lastIndex + 1, "110");
            lastIndex += 3;
        }

        return str.toString();
    }

    public static void main(String[] args) {
        solution(new String[]{"1110"});
        solution(new String[]{"100111100"});
        solution(new String[]{"0111111010"});
    }
}