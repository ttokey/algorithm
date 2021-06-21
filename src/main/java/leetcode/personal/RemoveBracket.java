package leetcode.personal;
/*
example 1.
        input "apple(nice(verygood())"
        output "applenice(verygood())"
        exaple 2.
        input "hi(niceto(meet)you))"
        output "hi(niceto(meet)you)"
        exaple 3.
        input "()()()((())"
        output "()()()(())"
exaple 4.
        input "()()()())(())"
        output ")"

 */

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class RemoveBracket {
    public static String removeBracket(String word) {
        List<Character> wordList = new ArrayList<>();
        Stack<Integer> openBracket = new Stack<>();
        List<Integer> removeBracket = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            wordList.add(c);
            if (c == '(') {
                openBracket.add(i);
            }
            if (c == ')') {
                if (openBracket.empty()) {
                    removeBracket.add(i);
                } else {
                    openBracket.pop();
                }
            }
        }
        removeBracket.addAll(openBracket);
        removeBracket.sort(Comparator.naturalOrder());
        for (int i = removeBracket.size() - 1; i >= 0; i--) {
            wordList.remove(removeBracket.get(i).intValue());
        }
        StringBuilder sb = new StringBuilder();
        for (char c : wordList) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String output = removeBracket("()()()())(())");
        System.out.println("result : " + output);
        System.out.println("expect : ()()()()(())");
    }

    public static String removeBracket2(String word) {
        List<Character> wordList = new ArrayList<>();
        List<Pair<Character, Integer>> bracketList = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            wordList.add(c);
            if (c == '(' || c == ')') {
                bracketList.add(new Pair<>(c, i));
            }
        }
        boolean isFinished = true;
        while (isFinished) {
            isFinished = false;
            boolean wasOpen = false;
            for (int i = 0; i < bracketList.size(); i++) {
                if (bracketList.get(i).getKey() == '(') {
                    wasOpen = true;
                }
                if (wasOpen && bracketList.get(i).getKey() == ')') {
                    bracketList.remove(i);
                    bracketList.remove(i - 1);
                    i = i - 2;
                    wasOpen = false;
                    isFinished = true;
                }
            }
        }
        for (int i = bracketList.size() - 1; i >= 0; i--) {
            int rem = bracketList.get(i).getValue();
            wordList.remove(rem);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : wordList) {
            sb.append(c);
        }
        return sb.toString();
    }
}
