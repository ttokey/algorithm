package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UniquePathsIIITest {
    @Test
    public void test() {
        // given
        boolean[][] test = new boolean[2][2];
        // when

        // then
        System.out.println(test[0][0]);
    }

    @Test
    public void uniquePathsIII() {
        // given
        int[][] input = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        int expectOutput = 2;
        UniquePathsIII uniquePathsIII = new UniquePathsIII();
        // when
        int result = uniquePathsIII.uniquePathsIII(input);
        // then
        Assertions.assertThat(result).isEqualTo(expectOutput);
    }

}