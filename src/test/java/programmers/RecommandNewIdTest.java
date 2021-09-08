package programmers;

import org.junit.jupiter.api.Test;

class RecommandNewIdTest {
    RecommandNewId recommandNewId = new RecommandNewId();

    @Test
    public void testStep3() {
        //given
        String input = "...bat..y.abcdefghijklm";
        //when
        String result = recommandNewId.step3(input);
        //then
        System.out.println(result);
    }

    @Test
    public void testStep4() {
        //given
        String input = ".bat..y.abcdefghijklm.";
        //when
        String result = recommandNewId.step4(input);
        //then
        System.out.println(result);
    }

    @Test
    public void testStep5() {
        //given
        String input = "";
        //when
        String result = recommandNewId.step5(input);
        //then
        System.out.println(result);
    }

    @Test
    public void testStep6() {
        //given
        String input = "bat.y.abcdefghih";
        //when
        String result = recommandNewId.step6(input);
        //then
        System.out.println(result);
    }

    @Test
    public void testStep7() {
        //given
        String input = "a";
        //when
        String result = recommandNewId.step7(input);
        //then
        System.out.println(result);
    }

    @Test
    public void testSolution() {
        //given
        String input = "=.=";
        //when
        String result = recommandNewId.solution(input);
        //then
        System.out.println(result);
    }

}