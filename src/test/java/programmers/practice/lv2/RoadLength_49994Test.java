package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RoadLength_49994Test {
    RoadLength_49994 roadLength_49994 = new RoadLength_49994();

    @Test
    public void test() {
        //given
        String dirs = "ULURRDLLU";
        int expect = 7;

        //when
        int result = roadLength_49994.solution(dirs);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}