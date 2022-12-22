package programmers.practice.lv2;

//1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
//2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
//3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
//  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
//4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
//  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
//  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
//  4-3. ')'를 다시 붙입니다. 
//  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
//  4-5. 생성된 문자열을 반환합니다.

import java.util.Stack;

public class BracketChange_60058 {
    public String solution(String p) {
        return doStep(p);
    }

    public String doStep(String w) {
        StringBuilder sb = new StringBuilder();
        //step1
        if (step1(w)) {
            return w;
        }
        //step2
        String[] step2String = step2(w);
        if (isCorrect(step2String[0])) {
            //step3
            sb.append(step2String[0])
                    .append(doStep(step2String[1]));
        } else {
            //step4
            sb.append("(")
                    .append(doStep(step2String[1]))
                    .append(")")
                    .append(step4(step2String[0]));
        }
        return sb.toString();
    }

    //  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
    public String step4(String input) {
        char[] inputChar = input.substring(1, input.length() - 1).toCharArray();
        for (int i = 0; i < inputChar.length; i++) {
            if (inputChar[i] == '(') {
                inputChar[i] = ')';
            } else {
                inputChar[i] = '(';
            }
        }
        return String.valueOf(inputChar);

    }

    public boolean isCorrect(String input) {
        Stack<Character> bracketStack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char nowChar = input.charAt(i);
            if (nowChar == '(') {
                bracketStack.push(input.charAt(i));
            } else if (!bracketStack.isEmpty()) {
                bracketStack.pop();
            } else {
                return false;
            }
        }
        return bracketStack.isEmpty();
    }

    public boolean step1(String input) {
        return input.isEmpty();
    }

    public String[] step2(String w) {
        String[] result = new String[2];
        char[] chars = w.toCharArray();
        int open = 0;
        int close = 0;
        for (int i = 0; i < w.length(); i++) {
            if (chars[i] == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                result[0] = w.substring(0, i + 1);
                result[1] = w.substring(i + 1);
                break;
            }
        }
        return result;
    }
}
