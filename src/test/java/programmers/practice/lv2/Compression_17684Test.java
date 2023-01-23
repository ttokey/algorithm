package programmers.practice.lv2;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Compression_17684Test {
    Compression_17684 compression_17684 = new Compression_17684();

    @Test
    public void test() {
        //given
        String input = "KAKAO";
        int[] expect = {11, 1, 27, 15};
        //when
        int[] result = compression_17684.solution(input);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}