package leetcode.hard;

import org.junit.jupiter.api.Test;

class RecoverFromPreorderTest {
    @Test
    public void test() {
// given
        String input = "hello";
// when

// then
        System.out.println(input.substring(0, 1));
    }

    @Test
    public void test2() {
        // given
        RecoverFromPreorder recoverFromPreorder = new RecoverFromPreorder();
        String input = "1-2--3--4-5--6--7";

//        // when
//        List<Queue<Integer>> tree = recoverFromPreorder.nodeToMap(input);
//
//        // then
//        for (int i = 0; i < tree.size(); i++) {
//            Queue temp = tree.get(i);
//            while (!temp.isEmpty()) {
//                int poll = (int) temp.poll();
//
//                System.out.println(String.format("depth : %d, 값 : %d", i, poll));
//            }
//        }

    }
}