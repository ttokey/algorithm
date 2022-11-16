package programmers.practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BargainEvent_131127Test {
    BargainEvent_131127 bargainEvent_131127 = new BargainEvent_131127();

    @Test
    public void test() {
        //given
        String[] wants = {"banana", "apple", "rice", "pork", "pot"], [3, 2, 2, 2, 1], ["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int expect = 3;

        //when
        int result = bargainEvent_131127.solution(wants, number, discount);
        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

}