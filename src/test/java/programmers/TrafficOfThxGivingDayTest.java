package programmers;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class TrafficOfThxGivingDayTest {
    TrafficOfThxGivingDay trafficOfThxGivingDay = new TrafficOfThxGivingDay();

    @Test
    public void testParseDateTime() {
        //given
        String input = "2016-09-15 21:00:00.966 0.381s";
        //when
        LocalDateTime result = trafficOfThxGivingDay.parseDateTime(input);
        //then
        System.out.println(result);
    }

}