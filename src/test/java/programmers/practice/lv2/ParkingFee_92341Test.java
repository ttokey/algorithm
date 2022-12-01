package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParkingFee_92341Test {
    ParkingFee_92341 parkingFee_92341 = new ParkingFee_92341();

    @Test
    public void test() {
        //given
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] expect = {14600, 34400, 5000};

        //when
        int[] result = parkingFee_92341.solution(fees, records);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test2() {
        //given
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] expect = {14600, 34400, 5000};

        //when
        int[] result = parkingFee_92341.solution(fees, records);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}