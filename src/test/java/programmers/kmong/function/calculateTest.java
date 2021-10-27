package programmers.kmong.function;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class calculateTest {
    calculate calculate = new calculate();
    calculate2 calculate2 = new calculate2();

    @Test
    public void test() {
        //given
        int input = 5000000;
        int expect = 4650000;

        //when
        int result = calculate2.calculateProfits(input);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

        //given
        int input2 = 400000;
        int expect2 = 320000;

        //when
        int result2 = calculate2.calculateProfits(input2);
        Assertions.assertThat(result2).isEqualTo(expect2);
    }

}