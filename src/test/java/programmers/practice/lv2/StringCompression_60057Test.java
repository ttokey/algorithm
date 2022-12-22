package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StringCompression_60057Test {
    StringCompression_60057 stringCompression_60057 = new StringCompression_60057();

    @Test
    public void test() {
        //given
        String s = "aabbaccc";
        int expect = 7;

        //when
        int result = stringCompression_60057.solution(s);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}