package programmers.kakao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FirstTest {
    First first = new First();

    @Test
    public void testSolution() {
        //given
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        int[] expectResult = {2, 1, 1, 0};
        //when
        int[] result = first.solution(id_list, report, k);

        //then
        Assertions.assertThat(result).isEqualTo(expectResult);

    }
}