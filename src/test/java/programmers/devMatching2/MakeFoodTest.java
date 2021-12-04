package programmers.devMatching2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeFoodTest {
    MakeFood makeFood = new MakeFood();

    @Test
    public void test(){
        int n = 2;
        String[] recipes = {"A 3","B 2"};
        String[] orders = {"A 1","A 2","B 3","B 4"};
        int expect = 7;

        int result = makeFood.solution(n, recipes, orders);

        Assertions.assertThat(result).isEqualTo(expect);

    }

}