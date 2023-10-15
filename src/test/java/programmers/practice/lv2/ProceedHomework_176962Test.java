package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ProceedHomework_176962Test {
    ProceedHomework_176962 proceedHomework176962 = new ProceedHomework_176962();

    @Test
    public void test1() {
        //given
        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        String[] expect = {"korean", "english", "math"};

        //when
        String[] result = proceedHomework176962.solution(plans);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test3() {
        //given
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        String[] expect = {"science", "history", "computer", "music"};

        //when
        String[] result = proceedHomework176962.solution(plans);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test2() {
        //given
        String[][] plans = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};
        String[] expect = {"bbb", "ccc", "aaa"};

        //when
        String[] result = proceedHomework176962.solution(plans);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }
}