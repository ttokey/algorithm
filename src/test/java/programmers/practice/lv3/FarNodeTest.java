package programmers.practice.lv3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FarNodeTest {
    FarNode farNode = new FarNode();

    @Test
    public void test() {
        //given
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        //when
        int result = farNode.solution(n, vertex);

        //then
        Assertions.assertThat(result).isEqualTo(3);
    }

}