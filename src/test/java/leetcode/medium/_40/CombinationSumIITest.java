package leetcode.medium._40;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CombinationSumIITest {
    CombinationSumII combinationSumII = new CombinationSumII();

    @Test
    void name() {
        //given
        List<Integer> something = List.of(1, 2, 3);
        List<Integer> other = List.of(1, 2, 3);


        //when
        Set<List<Integer>> result = new HashSet<>();
        result.add(something);
        result.add(other);

        //then
        Assertions.assertThat(result.size()).isEqualTo(1);
    }

    @Test
    void test() {
        //given
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> expect = List.of(List.of(1, 1, 6), List.of(1, 2, 5), List.of(1, 7), List.of(2, 6));

        //when
        List<List<Integer>> result = combinationSumII.combinationSum2(candidates, target);

        //then
        Assertions.assertThat(result)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(expect);
    }

    @Test
    void test2() {
        //given
        int[] candidates = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 30;
        List<List<Integer>> expect = List.of(List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));

        //when
        List<List<Integer>> result = combinationSumII.combinationSum2(candidates, target);

        //then
        Assertions.assertThat(result)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(expect);
    }
}
