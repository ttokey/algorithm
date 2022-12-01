package programmers.practice.lv2;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class RenewalMenuTest {
    RenewalMenu renewalMenu = new RenewalMenu();

    @Test
    public void testGetString() {
        //given
        String input = "ABCDE";
        int index = 3;

        //when
        List<String> result = renewalMenu.getString(input, index);

        //then
        System.out.println(result);
    }

    @Test
    public void testGetMap() {
        //given
        String[] input = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int index = 2;

        //when
        Map<String, Integer> result = renewalMenu.getMap(input, index);

        //then
        System.out.println(result);
    }

    @Test
    public void testSolution() {
        //given
        String[] input = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        String[] expect = {"WX", "XY"};


        //when
        String[] result = renewalMenu.solution(input, course);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}