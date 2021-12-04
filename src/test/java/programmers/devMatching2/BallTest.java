package programmers.devMatching2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {
    Ball ball = new Ball();

    @Test
    public void test(){
        String[] input = {"######",">#*###","####*#","#<#>>#",">#*#*<","######"};
        int expect = 4;

        int result = ball.solution(input);

        Assertions.assertThat(result).isEqualTo(expect);

    }

}