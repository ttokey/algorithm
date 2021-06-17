package leetcode.medium;

import org.junit.jupiter.api.Test;

class FindOrderTest {

    FindOrder findOrder = new FindOrder();

    @Test
    public void test() {
        //given
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        //when
        int[] result = findOrder.findOrder(numCourses, prerequisites);
        //then
        for (int num : result) {
            System.out.println(num);
        }
    }
}