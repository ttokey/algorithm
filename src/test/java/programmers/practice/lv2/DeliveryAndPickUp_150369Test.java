package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DeliveryAndPickUp_150369Test {
    DeliveryAndPickUp_150369 deliveryAndPickUp_150369 = new DeliveryAndPickUp_150369();

    @Test
    public void test() {
        //given
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};
        long expect = 16;

        //when
        long result = deliveryAndPickUp_150369.solution(cap, n, deliveries, pickups);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test2() {
        //given
        int cap = 2;
        int n = 7;
        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
        int[] pickups = {0, 2, 0, 1, 0, 2, 0};
        long expect = 30;

        //when
        long result = deliveryAndPickUp_150369.solution(cap, n, deliveries, pickups);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}