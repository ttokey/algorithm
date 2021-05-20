package inflearn.Array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class VisibleStudentTest {

    @Test
    public void solution() {
        // given
        List<Integer> inputList = Arrays.asList(130, 135, 148, 140, 145, 150, 150, 153);
        int expect = 5;
        // when
        int result = VisibleStudent.solution(inputList);

        // then

        Assertions.assertThat(result).isEqualTo(expect);
    }
}