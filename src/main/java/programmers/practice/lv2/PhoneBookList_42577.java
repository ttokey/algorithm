package programmers.practice.lv2;

import java.util.HashSet;
import java.util.Set;

public class PhoneBookList_42577 {
    public boolean solution(String[] phone_book) {
        Set<Integer> lengthSet = new HashSet<>();
        for (String phoneNum : phone_book) {
            lengthSet.add(phoneNum.length());
        }
        for (int length : lengthSet) {
            Set<String> phoneNumSet = new HashSet<>();
            for (String phoneNum : phone_book) {
                if (phoneNum.length() == length) {
                    phoneNumSet.add(phoneNum);
                }
            }
            for (String phoneNum : phone_book) {
                if (phoneNum.length() > length) {
                    String phoneNumSubString = phoneNum.substring(0, Math.min(length, phoneNum.length()));
                    if (phoneNumSet.contains(phoneNumSubString)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
