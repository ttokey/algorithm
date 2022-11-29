package programmers.practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MakeStar_87377Test {

    MakeStar_87377 makeStar_87377 = new MakeStar_87377();

    @Test
    public void test() {
        //given
        int[][] line = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
        String[] result = {"*.*"};

        //when
        String[] expect = makeStar_87377.solution(line);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}