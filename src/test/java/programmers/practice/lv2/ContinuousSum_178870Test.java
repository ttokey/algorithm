package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ContinuousSum_178870Test {
    ContinuousSum_178870 continuousSum178870 = new ContinuousSum_178870();

    @Test
    public void test1() {
        //given
        int[] seq = {1, 2, 3, 4, 5};
        int k = 7;
        int[] expect = {2, 3};

        //when
        int[] result = continuousSum178870.solution(seq, k);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test2() {
        //given
        int[] seq = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        int[] expect = {6, 6};

        //when
        int[] result = continuousSum178870.solution(seq, k);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test3() {
        //given
        int[] seq = {2, 2, 2, 2, 2};
        int k = 6;
        int[] expect = {0, 2};

        //when
        int[] result = continuousSum178870.solution(seq, k);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test4() {
        //given
        int[] seq = {5, 5, 5, 5, 5};
        int k = 5;
        int[] expect = {0, 0};

        //when
        int[] result = continuousSum178870.solution(seq, k);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }
}