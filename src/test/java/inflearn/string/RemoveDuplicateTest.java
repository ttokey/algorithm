package inflearn.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveDuplicateTest {
    @Test
    public void solution() {
        //given
        String input = "ksekkset";
        String output = "kset";

        //when
        String result = RemoveDuplicate.solution(input);

        //then
        Assertions.assertThat(result).isEqualTo(output);
    }
}
