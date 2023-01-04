package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SimilarityCantorBit_148652Test {
    SimilarityCantorBit_148652 similarityCantorBit_148652 = new SimilarityCantorBit_148652();

    @Test
    public void test() {
        //given
        int n = 2;
        long l = 4;
        long r = 17;
        int expect = 8;

        //when
        int result = similarityCantorBit_148652.solution(n, l, r);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    public void test2() {
        //given
        int n = 3;
        long l = 27;
        long r = 68;
        int expect = 15;

        //when
        int result = similarityCantorBit_148652.solution(n, l, r);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    public void test3() {
        //given
        int n = 3;
        long l = 50;
        long r = 75;
        int expect = 1;

        //when
        int result = similarityCantorBit_148652.solution(n, l, r);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

}