package programmers.lineFinance;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class lineFinanceThirdTest {
    lineFinanceThird lineFinanceThird = new lineFinanceThird();

    @Test
    public void test() {
        int n = 5;
        int k = 25;
        int[] expect = {4, 5};

        int[] result = lineFinanceThird.solution(n, k);

        Assertions.assertThat(result).isEqualTo(expect);
    }

}