package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GetKTest {
    GetK getK = new GetK();

    @Test
    public void test() {
        //given
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] expectResult = {5, 6, 3};
        //when
        int[] result = getK.solution(array, commands);

        //then
        Assertions.assertThat(result).isEqualTo(expectResult);
    }


}