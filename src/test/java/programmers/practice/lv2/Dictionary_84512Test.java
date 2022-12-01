package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Dictionary_84512Test {
    Dictionary_84512 dictionary_84512 = new Dictionary_84512();

    @Test
    public void test() {
        //given
        String word = "AAAAE";
        int expect = 6;

        //when
        int result = dictionary_84512.solution(word);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test2() {
        //given
        String word = "AAAE";
        int expect = 10;

        //when
        int result = dictionary_84512.solution(word);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    public void test3() {
        //given
        String word = "I";
        int expect = 1563;

        //when
        int result = dictionary_84512.solution(word);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

}