package programmers.practice.lv3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class TrafficOfThxGivingDayTest {
    TrafficOfThxGivingDay trafficOfThxGivingDay = new TrafficOfThxGivingDay();

    @Test
    public void testToLocalDateTime() {
        //given
        String input = "2016-09-15 21:00:00.966";
        //when
        LocalDateTime result = trafficOfThxGivingDay.toLocalDateTime(input);
        //then
        System.out.println(result);
    }

    @Test
    public void testGetStartTime() {
        //given
        LocalDateTime endTime = LocalDateTime.of(2016, 9, 15, 1, 0, 4, 2000000);
        String doingTime = "2.0";
        //when
        LocalDateTime startTime = trafficOfThxGivingDay.getStartTime(endTime, doingTime);
        //then
        System.out.println(startTime);
    }

    @Test
    public void testSolution() {
        //given
//        String[] inputs = {
//                "2016-09-15 20:59:57.421 0.351s",
//                "2016-09-15 20:59:58.233 1.181s",
//                "2016-09-15 20:59:58.299 0.8s",
//                "2016-09-15 20:59:58.688 1.041s",
//                "2016-09-15 20:59:59.591 1.412s",
//                "2016-09-15 21:00:00.464 1.466s",
//                "2016-09-15 21:00:00.741 1.581s",
//                "2016-09-15 21:00:00.748 2.31s",
//                "2016-09-15 21:00:00.966 0.381s",
//                "2016-09-15 21:00:02.066 2.62s"
//        };
        String[] inputs = {
                "2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"
        };
        int expectResult = 1;

        //when
        int result = trafficOfThxGivingDay.solution(inputs);

        //then
        Assertions.assertThat(result).isEqualTo(expectResult);
    }
}