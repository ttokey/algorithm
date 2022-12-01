package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayAlone_131130Test {
    PlayAlone_131130 playAlone_131130 = new PlayAlone_131130();

    @Test
    public void solution() {
        //given
        int[] input = {8, 6, 3, 7, 2, 5, 1, 4};
        int expect = 12;

        //when
        int result = playAlone_131130.solution(input);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

}