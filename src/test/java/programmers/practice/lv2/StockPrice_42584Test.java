package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StockPrice_42584Test {
    StockPrice_42584 stockPrice_42584 = new StockPrice_42584();

    @Test
    public void test() {
        //given
        int[] prices = {1, 2, 3, 2, 3};
        int[] expect = {4, 3, 1, 1, 0};
        //when
        int[] result = stockPrice_42584.solution(prices);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test2() {
        //given
        int[] prices = {5, 4, 3, 2, 1};
        int[] expect = {1, 1, 1, 1, 0};
        //when
        int[] result = stockPrice_42584.solution(prices);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }


    @Test
    public void test3() {
        //given
        int[] prices = {5, 4, 3, 3, 1};
        int[] expect = {1, 1, 2, 1, 0};
        //when
        int[] result = stockPrice_42584.solution(prices);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }


}