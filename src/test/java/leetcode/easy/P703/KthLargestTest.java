package leetcode.easy.P703;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class KthLargestTest {
    @Test
    void test() {
        //given
        KthLargest kthLargest = new KthLargest(1, new int[]{});

        List<Integer> result = new ArrayList<>();
        int[] inputs = new int[]{-3, -2, -4, 0, 4};

        //when
        for (int var : inputs) {
            result.add(kthLargest.add(var));
        }

        //then
        System.out.println(result);

    }

    @Test
    void test2() {
        //given
        KthLargest kthLargest = new KthLargest(2, new int[]{0});

        List<Integer> result = new ArrayList<>();
        int[] inputs = new int[]{-1, 1, -2, -4, 3};
        List<Integer> expected = List.of(-1, 0, 0, 0, 1);


        //when
        for (int var : inputs) {
            result.add(kthLargest.add(var));
        }

        //then
        Assertions.assertThat(result).isEqualTo(expected);

    }


}
