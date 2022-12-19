package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Tuple_64065Test {
    Tuple_64065 tuple_64065 = new Tuple_64065();

    @Test
    public void test() {
        //given
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] expect = {2, 1, 3, 4};
        //when
        int[] result = tuple_64065.solution(s);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}