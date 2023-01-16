package programmers.practice.lv1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonalInfoExpireDate_150370Test {
    PersonalInfoExpireDate_150370 personalInfoExpireDate_150370 = new PersonalInfoExpireDate_150370();

    @Test
    public void test() {
        //given
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] expect = {1, 3};

        //when
        int[] result = personalInfoExpireDate_150370.solution(today, terms, privacies);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}