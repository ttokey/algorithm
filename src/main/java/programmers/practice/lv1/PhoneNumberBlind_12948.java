package programmers.practice.lv1;

public class PhoneNumberBlind_12948 {
    public String solution(String phone_number) {
        return phone_number.replaceAll("\\d(?=\\d{4})", "*");
    }
}
