package programmers.practice.lv2;

//
//1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
//2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
//3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
//4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
//5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
//6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
//7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

//[입출력 예]
//no	new_id	result
//예1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
//예2	"z-+.^."	"z--"
//예3	"=.="	"aaa"
//예4	"123_.def"	"123_.def"
//예5	"abcdefghijklmn.p"	"abcdefghijklmn"


// -_. ~!@#$%^&*()=+[{]}:?,<>/

import java.util.Locale;

public class RecommandNewId {
    public String solution(String new_id) {
        String answer = step1(new_id);
        answer = step2(answer);
        answer = step3(answer);
        answer = step4(answer);
        answer = step5(answer);
        answer = step6(answer);
        answer = step7(answer);

        return answer;
    }

    //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    public String step1(String input) {
        return input.toLowerCase(Locale.ROOT);
    }

    //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    public String step2(String input) {
        String reg = "[~|!|@|#|\\$|%|\\^|&|\\*|\\(|\\)|=|\\+|\\[|{|\\]|\\}|:|\\?|,|<|>|\\/]";
        input = input.replaceAll(reg, "");
        return input;
    }

    //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    public String step3(String input) {
        input = input.replaceAll("\\.+", ".");
        return input;
    }

    //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    public String step4(String input) {
        if (!input.isEmpty() && input.charAt(0) == '.') {
            input = input.substring(1, input.length());
        }
        if (!input.isEmpty() && input.charAt(input.length() - 1) == '.') {
            input = input.substring(0, input.length() - 1);
        }

        return input;
    }

    //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    public String step5(String input) {
        if (input.isEmpty()) {
            return "a";
        }
        return input;
    }

    //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
    //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    public String step6(String input) {
        if (input.length() >= 16) {
            input = input.substring(0, 15);
            if (input.charAt(14) == '.') {
                input = input.substring(0, 14);
            }
        }
        return input;
    }

    //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
    public String step7(String input) {
        while (input.length() <= 2) {
            input = input.concat(String.valueOf(input.charAt(input.length() - 1)));
        }
        return input;
    }
}
