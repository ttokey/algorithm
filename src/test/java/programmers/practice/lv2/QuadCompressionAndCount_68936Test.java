package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class QuadCompressionAndCount_68936Test {
    QuadCompressionAndCount_68936 quadCompressionAndCount_68936 = new QuadCompressionAndCount_68936();

    @Test
    public void test() {
        //given
        int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        int[] expect = {4, 9};
        
        //when
        int[] result = quadCompressionAndCount_68936.solution(arr);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}