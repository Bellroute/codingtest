package boj;

import java.util.Scanner;

// [골드5] A와 B 2
// https://www.acmicpc.net/problem/12919
public class Solution12919 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        int answer = search(s, t) ? 1 : 0;
        System.out.println(answer);
    }

    private static boolean search(String s, String t) {
        if (s.length() == t.length()) {
            return s.equals(t);
        }

        if (t.charAt(t.length() - 1) == 'A') {
            boolean isAble = search(s, t.substring(0, t.length() - 1));

            if (isAble) {
                return true;
            }
        }

        if (t.charAt(0) == 'B') {
            return search(s, new StringBuilder(t).reverse().substring(0, t.length() - 1));
        }
        return false;
    }

    // 시간 초과 나는 코드
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String S = scanner.nextLine();
//        String T = scanner.nextLine();
//
//        boolean isAble = search(S, T);
//
//        appendA(S);
//        appendBAndReverse(S);
//
//        int answer = isAble ? 1 : 0;
//        System.out.println(answer);
//    }
//
//    private static String appendA(String word) {
//        return word + "A";
//    }
//
//    private static String appendBAndReverse(String word) {
//        return new StringBuilder(word)
//            .append("B")
//            .reverse()
//            .toString();
//    }
//
//    private static boolean search(String S, String T) {
//        if (S.length() == T.length()) {
//            return S.equals(T);
//        }
//
//        return search(appendA(S), T) || search(appendBAndReverse(S), T);
//    }
}
