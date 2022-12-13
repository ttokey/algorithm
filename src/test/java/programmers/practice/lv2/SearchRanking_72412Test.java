package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchRanking_72412Test {
    @Test
    public void test() {
        SearchRanking_72412 searchRanking_72412 = new SearchRanking_72412();
        //given
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] queries = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] expect = {1, 1, 1, 1, 2, 4};

        //when
        int[] result = searchRanking_72412.solution(info, queries);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    public void test2() {
        SearchRanking2_72412 searchRanking_72412 = new SearchRanking2_72412();
        //given
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] queries = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] expect = {1, 1, 1, 1, 2, 4};

        //when
        int[] result = searchRanking_72412.solution(info, queries);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}