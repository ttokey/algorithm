package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BiggerNumber_42746Test {
    BiggerNumber_42746 biggerNumber_42746 = new BiggerNumber_42746();

    @Test
    public void test() {
        //given
        int[] numbers = {6, 10, 2};
        String expect = "6210";
        //when
        String result = biggerNumber_42746.solution(numbers);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    public void test3() {
        //given
        int[] numbers = {1, 11, 110, 1110};
        String expect = "1111101110";
        //when
        String result = biggerNumber_42746.solution(numbers);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    public void test2() {
        //given
        String num1 = "98798797";
        String num2 = "987";
        //1이 크면 -1 , 2가 크면 1
        int expect = -1;
        //when
        int result = biggerNumber_42746.compare(num1, num2);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}