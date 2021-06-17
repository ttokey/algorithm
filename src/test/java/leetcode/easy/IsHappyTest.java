package leetcode.easy;

import org.junit.jupiter.api.Test;

class IsHappyTest {
    IsHappy isHappy = new IsHappy();

    @Test
    public void test() {
        //given 
        int n = 19;
        boolean expect = true;
        
        //when
        boolean result = isHappy.isHappy(n);

        //then
        System.out.println(result);
    }


}