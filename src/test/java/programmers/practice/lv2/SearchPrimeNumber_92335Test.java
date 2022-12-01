package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchPrimeNumber_92335Test {
    SearchPrimeNumber_92335 searchPrimeNumber_92335 = new SearchPrimeNumber_92335();

    @Test
    public void solution() {
        //given
        int n = 437674;
        int k = 3;
        int expect = 3;

        //when
        int result = searchPrimeNumber_92335.solution(n, k);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}