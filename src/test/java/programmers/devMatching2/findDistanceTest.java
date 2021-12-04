package programmers.devMatching2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class findDistanceTest {
    findDistance findDistance = new findDistance();

    @Test
    public void test(){
        String input = "abcc";
        int expect = 23;

        int result = findDistance.solution(input);

        Assertions.assertThat(result).isEqualTo(expect);
    }


}