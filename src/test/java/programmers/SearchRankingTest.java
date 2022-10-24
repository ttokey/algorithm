package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import programmers.practice.SearchRanking;

class SearchRankingTest {
    SearchRanking searchRanking = new SearchRanking();

    @Test
    public void testInfoes() {
        //given
        String[] input = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        //when
        String[][] result = searchRanking.toDBInfoes(input);
        //then
        System.out.println(result);
    }

    @Test
    public void testQuery() {
        //given
        String[] input = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        //when
        String[][] result = searchRanking.toDBQuery(input);
        //then
        System.out.println(result);
    }

    @Test
    public void testSolution() {
        //given
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] expectResult = {1, 1, 1, 1, 2, 4};

        //when
        int[] result = searchRanking.solution(info, query);
        //then
        Assertions.assertThat(result).isEqualTo(expectResult);
    }

}