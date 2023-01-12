package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HIndex_42747Test {
    HIndex_42747 hIndex_42747 = new HIndex_42747();

    @Test
    public void test() {
        //given
        int[] citations = {3, 0, 6, 1, 5};
        int expect = 3;
        //when
        int result = hIndex_42747.solution(citations);
        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    public void test2() {
        //given
        int[] citations = {4, 4, 4};
        int expect = 3;
        //when
        int result = hIndex_42747.solution(citations);
        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    public void test3() {
        //given
        int[] citations = {0, 0, 0, 0, 0};
        int expect = 0;
        //when
        int result = hIndex_42747.solution(citations);
        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    public void tes4() {
        //given
        int[] citations = {10, 10, 10, 10, 10};
        int expect = 5;
        //when
        int result = hIndex_42747.solution(citations);
        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}