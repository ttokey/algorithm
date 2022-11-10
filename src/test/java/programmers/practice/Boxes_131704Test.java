package programmers.practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Boxes_131704Test {
    Boxes_131704 boxes_131704 = new Boxes_131704();

    @Test
    public void test() {
        //given
        int[] input = {5, 4, 3, 2, 1};
        int expect = 5;

        //when
        int result = boxes_131704.solution(input);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

}