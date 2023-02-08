package programmers.practice.lv4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TwinTowerForest_140105Test {
    TwinTowerForest_140105 twinTowerForest_140105 = new TwinTowerForest_140105();

    @Test
    public void test() {
        //given
        int n = 3;
        int count = 1;
        int expect = 8;
        //when
        int result = twinTowerForest_140105.solution(n, count);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

}