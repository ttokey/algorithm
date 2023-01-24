package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MomentAgoSong_17683Test {
    MomentAgoSong_17683 momentAgoSong_17683 = new MomentAgoSong_17683();

    @Test
    public void test() {
        //given
        String m = "ABCDEFG";
        String[] musicInfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,CDEFGAB"};
        String expect = "HELLO";

        //when
        String result = momentAgoSong_17683.solution(m, musicInfos);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}