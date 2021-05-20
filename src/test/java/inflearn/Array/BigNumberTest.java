package inflearn.Array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class BigNumberTest {
    @Test
    public void solution() {
        // given
        int input1 = 6;
        List<Integer> inputList = Arrays.asList(7, 3, 9, 5, 6, 12);
        String expect = "7 9 6 12";

        // when
        String result = BigNumber.solution(inputList);

        // then
        Assertions.assertThat(result).isEqualTo(expect);
    }
}