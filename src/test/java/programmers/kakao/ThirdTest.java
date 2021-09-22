package programmers.kakao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class ThirdTest {
    Third third = new Third();

    @Test
    public void testSolution() {
        //given
        int[] fees = {1, 461, 1, 10};
        String[] records = {"00:00 1234 IN"};
        int[] expectResult = {14841};
        //when
        int[] result = third.solution(fees, records);

        //then
        Assertions.assertThat(result).isEqualTo(expectResult);

    }

    @Test
    public void testLocalDateTime() {
        //given
        LocalDateTime time = LocalDateTime.now();
        LocalDateTime time2 = LocalDateTime.now().plusMinutes(1);
        List<LocalDateTime> list = new ArrayList<>();
        //when
        list.add(time);
        list.add(time2);

        //then


    }
}