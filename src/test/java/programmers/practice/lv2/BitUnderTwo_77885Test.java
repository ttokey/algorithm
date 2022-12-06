package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BitUnderTwo_77885Test {
    BitUnderTwo_77885 bitUnderTwo_77885 = new BitUnderTwo_77885();

    @Test
    public void test() {
        //given
        long[] numbers = {2, 7};
        long[] expect = {3, 11};

        //when
        long[] result = bitUnderTwo_77885.solution(numbers);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}