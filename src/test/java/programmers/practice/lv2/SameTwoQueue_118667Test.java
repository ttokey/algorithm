package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SameTwoQueue_118667Test {
    SameTwoQueue_118667 sameTwoQueue_118667 = new SameTwoQueue_118667();

    @Test
    public void solution() {
        //given
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        int expect = 2;

        //when
        int result = sameTwoQueue_118667.solution(queue1, queue2);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    public void solution2() {
        //given
        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 10, 1, 2};
        int expect = 7;

        //when
        int result = sameTwoQueue_118667.solution(queue1, queue2);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    public void solution3() {
        //given
        int[] queue1 = {5, 1, 1};
        int[] queue2 = {1, 1, 1};
        int expect = 4;

        //when
        int result = sameTwoQueue_118667.solution(queue1, queue2);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }


    @Test
    public void solution4() {
        //given
        int[] queue1 = {1};
        int[] queue2 = {1};
        int expect = 0;

        //when
        int result = sameTwoQueue_118667.solution(queue1, queue2);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

}