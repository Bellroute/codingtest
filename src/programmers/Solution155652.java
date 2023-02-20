package programmers;

public class Solution155652 {

    public static String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        for (String alphabet : skip.split("")) {
            alphabets = alphabets.replace(alphabet, "");
        }

        for (String alphabet : s.split("")) {
            int next = alphabets.indexOf(alphabet) + index;
            answer.append(alphabets.charAt(next % alphabets.length()));
        }

        return answer.toString();
    }
}
