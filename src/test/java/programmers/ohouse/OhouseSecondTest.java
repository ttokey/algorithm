package programmers.ohouse;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class OhouseSecondTest {
    OhouseSecond ohouseSecond = new OhouseSecond();
    OhouseSecond3 ohouseSecond3 = new OhouseSecond3();
    OhouseSecond4 ohouseSecond4 = new OhouseSecond4();
    OhouseSecond5 ohouseSecond5 = new OhouseSecond5();

    @Test
    public void test() {
        //given
        String str = "ohoohoohooho";
        int expect = 4;

        //when
        int result = ohouseSecond4.solution(str);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    public void testCan() {
        //given
        String str = "ooooohh";
        ohouseSecond.solution(str);
        //when
        List<Integer> canO = ohouseSecond.canO(5);
        List<Integer> canH = ohouseSecond.canH(5);

        //then
        System.out.println(canO);
        System.out.println(canH);

    }
}