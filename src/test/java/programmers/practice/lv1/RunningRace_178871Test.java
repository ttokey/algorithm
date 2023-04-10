package programmers.practice.lv1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RunningRace_178871Test {
    RunningRace_178871 runningRace_178871 = new RunningRace_178871();

    @Test
    public void test() {
        //given
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] expect = {"mumu", "kai", "mine", "soe", "poe"};
        //when
        String[] result = runningRace_178871.solution(players, callings);

        //then
        Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(expect);
    }
}